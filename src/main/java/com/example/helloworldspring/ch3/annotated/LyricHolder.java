package com.example.helloworldspring.ch3.annotated;

import org.springframework.stereotype.Service;

@Service("lyricHolder")
public class LyricHolder {
    private String value = "'You be the DJ, I'll be the driver'";

    @Override
    public String toString() {
        return "LyricHolder: { "+value+"}";
    }
}
