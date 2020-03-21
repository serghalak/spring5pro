package com.apress.prospring5.ch3.annotated.lookup;

import com.apress.prospring5.ch3.annotated.lookup.DemoBean;
import com.apress.prospring5.ch3.annotated.lookup.SingerProtoType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

public class LookupConfigDemo {


    @Configuration
    @ComponentScan(basePackages = "com.apress.prospring5.ch3.annotated.lookup")
    public static class LookupConfig{ }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(LookupConfig.class);
        DemoBean abstractBean = context.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardBean = context.getBean("standardLookupDemoBean", DemoBean.class);
        displayInfo("abstarctLookupBean",abstractBean);
        displayInfo("standardLookupBean",standardBean);
        context.close();
    }

    public static void displayInfo(String beanName, DemoBean bean) {
        SingerProtoType singer1 = bean.getMySinger();
        SingerProtoType singer2 = bean.getMySinger();

        System.out.println("[" + beanName + "]: Singer Instances the Same?  "
                + (singer1 == singer2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100000; x++) {
            SingerProtoType singer = bean.getMySinger();
            //singer.sing();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
