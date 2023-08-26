import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner fileReader = new Scanner(file);
        double fNum = 0, sNum=0;
        String op = "";
        try {
            fNum = Double.parseDouble(fileReader.next());
            op = fileReader.next();
            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                System.out.println("Operation Error!");
                System.exit(0);
            }
            sNum = Double.parseDouble(fileReader.next());
            if (sNum==0 && op.equals("/")) {
                System.out.println("Error! Division by zero");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error! Not number");
            System.exit(0);
        }
        System.out.println(op.equals("+") ? fNum+sNum : op.equals("-") ? fNum-sNum : op.equals("*") ? fNum*sNum : fNum/sNum);
    }
}