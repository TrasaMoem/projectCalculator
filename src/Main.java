import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("input");
        FileWriter fw = new FileWriter("output");
        Scanner fileReader = new Scanner(file);
        double fNum = 0, sNum=0;
        String op = "";
        try {
            fNum = Double.parseDouble(fileReader.next());
            op = fileReader.next();
            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                fw.write("Operation Error!");
                fw.close(); fileReader.close();
                System.exit(0);
            }
            sNum = Double.parseDouble(fileReader.next());
            if (sNum==0 && op.equals("/")) {
                fw.write("Error! Division by zero");
                fw.close(); fileReader.close();
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            fw.write("Error! Not number");
            fw.close(); fileReader.close();
            System.exit(0);
        }
        fw.append(Double.toString(op.equals("+") ? fNum+sNum : op.equals("-") ? fNum-sNum : op.equals("*") ? fNum*sNum : fNum/sNum));
        fw.close(); fileReader.close();
    }
}