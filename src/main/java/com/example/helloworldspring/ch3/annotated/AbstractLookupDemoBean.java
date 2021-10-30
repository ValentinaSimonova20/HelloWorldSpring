package com.example.helloworldspring.ch3.annotated;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupBean")
public class AbstractLookupDemoBean implements DemoBean {

    @Lookup("singerdemoforlookup")
    public SingerDemoForLookup getMySinger(){
        return null; // переопределяется атвоматически
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
