/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThrowableExample;

/**
 *
 * @author MTBEBAN
 */
class SaiSoException extends Exception {
    private String so;
    public SaiSoException(String so) {
        this.so = so;
    }
    public String getMessage(){
         return "gia tri \'"+ so + "\' khong phai so";
    }
}
