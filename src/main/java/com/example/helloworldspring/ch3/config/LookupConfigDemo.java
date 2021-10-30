package com.example.helloworldspring.ch3.config;

import com.example.helloworldspring.ch3.annotated.DemoBean;
import com.example.helloworldspring.ch3.Singer;
import com.example.helloworldspring.ch3.annotated.SingerDemoForLookup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;

public class LookupConfigDemo {

    @Configuration
    @ComponentScan(basePackages = {"com.example.helloworldspring.ch3.annotated"})
    public static class LookupConfig{}

    public static void main(String[] args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        LookupConfig.class);

        DemoBean abstractBean =
                ctx.getBean("abstractLookupBean", DemoBean.class);

        DemoBean standardBean =
                ctx.getBean("standardLookupBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);
        ctx.close();


    }

    public static void displayInfo(String beanName, DemoBean bean){
        SingerDemoForLookup singer1 = bean.getMySinger();
        SingerDemoForLookup singer2 = bean.getMySinger();
        System.out.println(""+beanName+": "+ "Singer Instances the Same? "+
                (singer1 == singer2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for(int x = 0; x<100000; x++){
            SingerDemoForLookup singer = bean.getMySinger();
            singer.sing();
        }

        stopWatch.stop();
        System.out.println("100000 gets took "+stopWatch.getTotalTimeMillis()+" ms");
    }
}
