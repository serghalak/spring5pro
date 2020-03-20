package com.apress.prospring5.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContext {

    public static void main(String[] args) {
        GenericXmlApplicationContext parent=new GenericXmlApplicationContext();
        parent.load("classpath:spring/parent-context.xml");
        parent.refresh();

        GenericXmlApplicationContext child=new GenericXmlApplicationContext();
        child.load("classpath:spring/child-context.xml");
        child.setParent(parent);
        child.refresh();



        Song song1=child.getBean("song1",Song.class);
        Song song2=child.getBean("song2",Song.class);
        Song song3=child.getBean("song3",Song.class);

        System.out.println("from parent ctx: " + song1.getTitle());
        System.out.println("from child ctx: " + song2.getTitle());
        System.out.println("from parent ctx: " + song3.getTitle());

        child.close();
        parent.close();

    }
}
