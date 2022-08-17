import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;
    public int maximumElement = 0;
    public int minimumElement;

    public Difference(int[] a) {
        elements = a;
    }

    public void computeDifference() {
        minimumElement = elements[0];
        for (int i = elements.length - 1; i >= 1; i--) {
            int temp = elements[i];
            if(temp>maximumElement){
                maximumElement = temp;
            }
            if(temp<minimumElement){
                minimumElement = temp;
            }
        }
        maximumDifference = maximumElement-minimumElement;
    }

    // Add your code here

} // End of Difference class
public class MaxDifferenceElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
