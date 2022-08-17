import java.util.Arrays;
import java.util.Scanner;

public class LibBookFineCalculator {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        String returnedDate = sc.nextLine();
        String dueDate = sc.nextLine();
        calculateFine(returnedDate,dueDate);
    }

    private static void calculateFine(String returnedDate, String dueDate) {
        String[] returnDtArr = returnedDate.split(" ");
        String[] dueDtArr = dueDate.split(" ");
       /* System.out.println(returnedDate);
        System.out.println(Arrays.toString(returnDtArr));
        System.out.println(dueDate);
        System.out.println(Arrays.toString(dueDtArr));*/
        String returnedYr = returnDtArr[2];
        int returnedYrInt = convertStrToInt(returnedYr);
        String returnedMn = returnDtArr[1];
        int returnedMnInt = convertStrToInt(returnedMn);
        String returnedDt = returnDtArr[0];
        int returnedDtInt = convertStrToInt(returnedDt);
        String dueYr = dueDtArr[2];
        int dueYrInt = convertStrToInt(dueYr);
        String dueMn = dueDtArr[1];
        int dueMnInt = convertStrToInt(dueMn);
        String dueDt = dueDtArr[0];
        int dueDtInt = convertStrToInt(dueDt);
        int fine = 0;
        if(returnedYrInt > dueYrInt){
            fine = 10000;
        }else if(returnedYrInt == dueYrInt && returnedMnInt > dueMnInt){
            fine = 500 * (returnedMnInt - dueMnInt);
        }else if(returnedMnInt == dueMnInt && returnedDtInt > dueDtInt){
            fine = 15 * (returnedDtInt - dueDtInt);
        }
        System.out.println(fine);
    }

    private static int convertStrToInt(String input){
        int outPut =0;
        try {
            outPut = Integer.parseInt(input);
        }catch (Exception exception){

        }
        return outPut;
    }
}
