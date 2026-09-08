import java.util.Scanner;
import java.io.*;
public class ReadWriteToFiles{
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("input.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("output.txt");
        while(in.hasNext()) {
            String s = in.nextLine();
            System.out.println(s);
            out.println(s);
        }
        in.close();
        out.close();
    }
}
