import java.util.Scanner;

public class MyFirstJava {
    public static void main(String[] args) {
        int result = sum3();
        System.out.println(result);
    }

    public static int sum3(int a, int b, int c) {
        return a + b + c;
    }

    public static int sum3() {
        return sum3(1, 2, 3);
    }

}
