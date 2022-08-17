import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();
        try {
            Integer x= Integer.valueOf(S);
            System.out.println(x);
        }catch (NumberFormatException ex){
            System.out.println("Bad String");
        }
        bufferedReader.close();
    }
}
