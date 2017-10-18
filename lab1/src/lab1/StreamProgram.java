/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MTBEBAN
 */
public class StreamProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập chuỗi :");
        String ch = sc.nextLine();
        args = ch.split("\\s+");
        Arrays.stream(args).forEach((String value)->{
        System.out.println("value is "+value);
        });
    }
}
