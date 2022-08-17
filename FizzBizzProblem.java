import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBizzProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ResultFizz.fizzBuzz(n);

        bufferedReader.close();
    }
}

class ResultFizz {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        for (int i = 0; i < n; i++) {
            boolean divisibleBy3 = i%3==0;
            boolean divisibleBy5 = i%5==0;
            if(divisibleBy3 & divisibleBy5) System.out.println("FizzBuzz");
            else if(divisibleBy3 & !divisibleBy5) System.out.println("Fizz");
            else if(divisibleBy5) System.out.println("Buzz");
            else System.out.println(i);
        }
    }

}
