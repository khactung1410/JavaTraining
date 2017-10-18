/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MTBEBAN
 */
public class SystemExample {
    public static void main(String[] args) {
        System.out.println("JAVA_HOME ="+System.getProperty("java.home"));
        System.setProperty("java.home","C:\\ProgramFiles\\Java\\jre19");
        System.out.println("JAVA_HOME="+System.getProperty("java.home"));
        System.out.println("User = "+System.getProperty("user.name"));
    }
}
