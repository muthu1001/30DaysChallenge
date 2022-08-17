import java.util.Scanner;

public class ShapeProblem {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        scanner.close();
       Rectangle rect = new Rectangle(input1,input2);
       rect.area();
    }
}

class Shape{
    int length,breadth = 0;
    public Shape(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public void area(){
        System.out.println(length +" "+breadth);
    }
}

class Rectangle extends Shape{

    public Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    @Override
    public void area() {
        super.area();
        System.out.println(length*breadth);
    }
}
