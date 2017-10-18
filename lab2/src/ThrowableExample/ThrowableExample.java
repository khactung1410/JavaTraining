package ThrowableExample;


public class ThrowableExample {
    static int toNumber(String value) throws SaiSoException {
        try{
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch(NumberFormatException e){
            throw new SaiSoException(value);
        }
    }
    public static void main(String[] args) {
        try{
            System.out.println("number = "+toNumber("123"));
        }catch(SaiSoException e){
            System.err.println(e.getMessage());
        }
    }
}