package wit.comp1050;

public class Code{
    public int numofColors;

    public Code(int[] val){

        code = String.valueOf(val);
    }
    private String code;


    public String getCode() {

        return code;
    }
}