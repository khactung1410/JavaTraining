/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterExample;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterExample {
    //cách bthg
    
//    private static int countDigit(String value){
//        int i=0,counter =0;
//        while(i<value.length()){
//            char c = value.charAt(i);
//            if(Character.isDigit(c)) counter++;
//            i++;
//        }
//        return counter;
//    }
    
    //dùng stream
    
    static int countDigit(String value){
        AtomicInteger counter = new AtomicInteger(0);
        IntStream stream = value.chars();
        stream.forEach(c -> {
            if(Character.isDigit(c)) counter.incrementAndGet();
        });
        return counter.get();
    }
    public static void main(String[] args) {
        System.out.println("there are "+countDigit("tung 1997") + " digits in the text");
    }
}
