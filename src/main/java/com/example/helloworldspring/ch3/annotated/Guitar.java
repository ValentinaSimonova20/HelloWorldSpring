package com.example.helloworldspring.ch3.annotated;

import org.springframework.stereotype.Component;

@Component("gopher")
public class Guitar {
    public void sing() {
        System.out.println("Cm EB Fm Ab Bb");
    }
}
