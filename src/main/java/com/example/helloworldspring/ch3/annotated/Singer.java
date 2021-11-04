package com.example.helloworldspring.ch3.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("nonSingleton")
@Scope("prototype")
public class Singer {

    private String name = "unknown";

    private String lyric = "We found a message in a bottle we were drinking";


    public Singer(@Value("John Mayer") String name){
        this.name = name;
    }

    public void sing(){
        System.out.println(lyric);
    }

    public String getName() {
        return name;
    }
}
