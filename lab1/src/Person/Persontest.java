/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.util.Scanner;

/**
 *
 * @author MTBEBAN
 */
public class Persontest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        args[0] = "Duong";
        args[1] = "Tung";
        Person person1 = new Person(args[0]);
        Person person2 = new Person(args[1]);
        
    }
}
