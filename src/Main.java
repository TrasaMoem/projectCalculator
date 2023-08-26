import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("input");
        FileWriter fw = new FileWriter("output");
        Scanner fileReader = new Scanner(file);
        double fNum = 0, sNum=0;
        String op = "";
        String fNumCh = "", sNumCh = "";
        try {
            fNumCh = fileReader.next();
            fNum = Double.parseDouble(fNumCh);
            op = fileReader.next();
            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                fw.write(((fNum*10)%10==0? Math.round(fNum) : fNum) + " " + op + " " + ((sNum*10)%10==0? Math.round(sNum) : sNum) + " = " + "Operation Error!");
                fw.close(); fileReader.close();
                System.exit(0);
            }
            sNumCh = fileReader.next();
            sNum = Double.parseDouble(sNumCh);
            if (sNum==0 && op.equals("/")) {
                fw.write(((fNum*10)%10==0? Math.round(fNum) : fNum) + " " + op + " " + Math.round(sNum) + " = " + "Error! Division by zero");
                fw.close(); fileReader.close();
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            fw.write( fNumCh + " " + op + " " + sNumCh + " = " + "Error! Not number");
            fw.close(); fileReader.close();
            System.exit(0);
        }
        fw.append(String.valueOf((fNum * 10) % 10 == 0 ? Math.round(fNum) : fNum)).append(" ").append(op).append(" ").append(String.valueOf((sNum * 10) % 10 == 0 ? Math.round(sNum) : sNum)).append(" = ").append(String.valueOf(op.equals("+") ? fNum + sNum : op.equals("-") ? fNum - sNum : op.equals("*") ? fNum * sNum : fNum / sNum));
        fw.close(); fileReader.close();
    }
}