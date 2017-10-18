/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumberExample;

import java.util.*;

/**
 *
 * @author MTBEBAN
 */
public class NumberExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[0]);
        System.out.println("num1 - num2 =" +(num1 -num2));
        System.out.println("num1 > num2 ="+(num1 > num2));
    }
}
