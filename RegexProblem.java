import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RegexProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> mailList = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            String firstName = firstMultipleInput[0];
            String emailID = firstMultipleInput[1];
            nameList.add(firstName);
            mailList.add(emailID);
        }
        bufferedReader.close();

        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String mail = mailList.get(i);
            boolean nameMatches = name.matches("^([a-z])\\w.{0,20}$");
            boolean mailMatches = mail.matches("^([a-z]|@|.)\\w.{0,20}$");
            boolean gmail = mail.matches("^([a-z]|@|.)\\w.{0,20}.@gmail\\.com$");
            if(nameMatches && mailMatches && gmail){
                result.add(name);
            }
        }
        Collections.sort(result);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
