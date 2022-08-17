public class ClassA {
    int add(int i , int j){
        return i+j;
    }
}

interface Intab{
    public int add(int a, int b);
}

class ClassB {
    public static void main(String[] vararg) {
        try {
            Float f = new Float("3.0");
            int i = f.intValue();
            byte b = f.byteValue();
            double d = f.doubleValue();
            System.out.println(i + b + d);
        }catch (NumberFormatException ex){
            System.out.println("Ex");
        }
    }
}
