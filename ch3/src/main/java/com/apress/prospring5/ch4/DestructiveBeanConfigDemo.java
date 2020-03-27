package com.apress.prospring5.ch4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;


public class DestructiveBeanConfigDemo {
    private File file;
    private String filePath;

    @Lazy
    @Configuration
    static class DestructiveBeanConfig{
        @Bean/*( initMethod = "afterPropertiesSet" , destroyMethod = "destroy" )*/
        public DestructiveBeanConfigDemo destructiveBeanConfigDemo(){
            String filePath=System.getProperty("java.io.tmpdir")
                    +System.getProperty("file.separator")+"test.txt";
            DestructiveBeanConfigDemo destructiveBeanConfigDemo=new DestructiveBeanConfigDemo();
            destructiveBeanConfigDemo.setFilePath(filePath);
            return destructiveBeanConfigDemo;
        }
    }


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + DestructiveBeanWithJSR250.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if(!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String... args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/app-context-annotation.xml");
        ctx.refresh();

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBeanWithJSR250");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}
