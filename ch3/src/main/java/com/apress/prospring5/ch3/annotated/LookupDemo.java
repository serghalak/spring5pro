package com.apress.prospring5.ch3.annotated;

import com.apress.prospring5.ch3.annotated.lookup.DemoBean;
import com.apress.prospring5.ch3.annotated.lookup.SingerProtoType;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        DemoBean abstractBean = ctx.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupDemoBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);

        ctx.close();
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
