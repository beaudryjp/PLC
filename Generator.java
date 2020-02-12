public class Generator{

    public static final int LT      = 1;
    public static final int LTOREQ  = 2;
    public static final int GT      = 3;
    public static final int GTOREQ  = 4;
    public static final int EQ      = 5;
    public static final int NOTEQ   = 6;
    public static final int AND     = 7;
    public static final int OR      = 8;
    public static final int NOT     = 9;
    public static int numTempVars   = -1;
    public static int numLabels     = -1;

    public static String newTempVar(){
        numTempVars++;
        return "t" + numTempVars;
    }

    public static String newLabel(){
        numLabels++;
        return "L" + numLabels;
    }

    public static void label(String label){
        System.out.println(label + ":");
    }

    public static void gotoLabel(String label){
        System.out.println("\tgoto " + label + ";");
    }

    public static String print(String value){
        System.out.println("\tprint " + value + ";");
        return value;
    }

    public static void halt(){
        System.out.println("\thalt;");
    }

    public static String assignment(String var, String number){
        System.out.println("\t" + var + " = " + number + ";");
        return var;
    }

    public static String arithmetic(String number){
        String temp = newTempVar(); 
        System.out.println("\t" + temp + " = " + number + ";");
        return temp;
    }

    public static Tag condition(int cond, String arg1, String arg2){
        Tag result = new Tag(newLabel(), newLabel());
        switch(cond){
            case EQ: 
                System.out.println("\tif (" + arg1 + " == " + arg2 + ") goto " + result.getV() + ";");
                System.out.println("\tgoto " + result.getF() + ";");
                break;
            case NOTEQ:
                System.out.println("\tif (" + arg1 + " == " + arg2 + ") goto " + result.getF() + ";");
                System.out.println("\tgoto " + result.getV() + ";");
                break;
            case LT:
                System.out.println("\tif (" + arg1 + " < " + arg2 + ") goto " + result.getV() + ";");
                System.out.println("\tgoto " + result.getF() + ";");
                break;
            case LTOREQ:
                System.out.println("\tif (" + arg2 + " < " + arg1 + ") goto " + result.getF() + ";");
                System.out.println("\tgoto " + result.getV() + ";");
                break;
            case GT:
                System.out.println("\tif (" + arg2 + " < " + arg1 + ") goto " + result.getV() + ";");
                System.out.println("\tgoto " + result.getF() + ";");
                break;
            case GTOREQ:
                System.out.println("\tif (" + arg1 + " < " + arg2 + ") goto " + result.getF() + ";");
                System.out.println("\tgoto " + result.getV() + ";");
                break;
            default:
                break;
        }
        return result;
    }

    public static Tag operator(int cond, Tag c1, Tag c2){
        Tag result = c2;
        switch(cond){
            case NOT:
                result = new Tag(c1.getF(), c1.getV());
                break;
            case AND:
                label(c1.getF()); 
                gotoLabel(c2.getV());
                break;
            case OR:
                label(c1.getV()); 
                gotoLabel(c2.getF());
                break;
            default:
                break;
        }
        return result;
    }

}