package com.example.helloworldspring.ch3.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singerdemoforlookup")
@Scope("prototype")
public class SingerDemoForLookup {
    private String lyric = "I played a quick game of chess "+
            "with the salt and pepper shaker";

    public void sing(){

    }
}
