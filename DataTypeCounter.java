import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataTypeCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine();

        ResultFinder.typeCounter(sentence);

        bufferedReader.close();
    }
}

class ResultFinder {

    /*
     * Complete the 'typeCounter' function below.
     *
     * The function accepts STRING sentence as parameter.
     */

    public static void typeCounter(String sentence) {
        String[] input = sentence.split(" ");
        int stringDatatype = 0;
        int integerDatatype = 0;
        int doubleDatatype = 0;
        for (String data1 : input) {
            String data = data1.replaceAll(",","");
            boolean isInt = false;
            boolean isDouble = false;
            try {
                int tempi = Integer.parseInt(data);
                System.out.println("Int : " + tempi + " data :" + data);
                integerDatatype++;
                isInt = true;
            } catch (NumberFormatException ignored) {

            }
            if (!isInt) {
                try {
                    double tempD = Double.parseDouble(data);
                    System.out.println("double: " + tempD + " data :" + data);
                    doubleDatatype++;
                    isDouble = true;
                } catch (NumberFormatException ignored) {

                }
            }

            if (!isDouble && !isInt) {
                System.out.println("String: " + data);
                stringDatatype++;
            }

        }
        System.out.println(
            "string " + stringDatatype + "\n" +
            "integer " + integerDatatype + "\n" +
            "double " + doubleDatatype
        );
    }

}
