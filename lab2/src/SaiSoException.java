
public class SaiSoException extends Exception {
    private String so;
    public SaiSoException(String so) {
        this.so = so;
    }
    public String getMessage(){
         return "gia tri \'"+ so + "\' khong phai so";
    }
//    public static void main(String[] args) {
//        SaiSoException saiso = new SaiSoException("15");
//        System.out.println(saiso.getMessage());
//    }
}

