package com.example.helloworldspring.ch3.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean{

    private SingerDemoForLookup mySinger;

    @Autowired
    @Qualifier("singerdemoforlookup")
    public void setMySinger(SingerDemoForLookup mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public SingerDemoForLookup getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
