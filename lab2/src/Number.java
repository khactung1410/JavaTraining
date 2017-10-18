/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MTBEBAN
 */
public class Number{
    static int toNumber(String value){
        try{
            Integer integer =Integer.parseInt(value);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String[] args) {
        int number = toNumber("34");
        System.out.println("number = " + number);
    }
}
