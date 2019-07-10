package com.example.demo;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
    private int startPos = 1;
    private int endPos = 100;
    private static final Map<Integer, String> DIVIDER = new HashMap<>();{
        DIVIDER.put(3, "Foo");
        DIVIDER.put(5, "Bar");
        DIVIDER.put(7, "Qix");
    }
    Test(){
        try{

            PrintStream out = System.out;
            while(startPos<=endPos){
                out.println(startPos +" "+ extractWords(startPos));
                startPos++;
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
    private String extractWords(int startPos) {

        String r = "";
        for (Entry<Integer, String> divider : DIVIDER.entrySet()) {

            if(startPos % divider.getKey() == 0){
                r += divider.getValue();
            }
        }
        if(startPos > 9){
            r += DIVIDER.containsKey(startPos / 10)? DIVIDER.get(startPos / 10) : "";
            startPos = startPos % 10;
        }
        r += DIVIDER.containsKey(startPos)? DIVIDER.get(startPos) : "";
        return r;
    }
}