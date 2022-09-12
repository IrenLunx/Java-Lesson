// Написать программу, показывающую последовательность действий для игры “Ханойская башня”

package HomeWork3;
import java.util.Scanner;

public class HomeWork31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество колец: ");
        int val = in.nextInt();
        in.close();
        int start = 1;
        int betw = 2;
        int tow = 3;
        han_tow(val, start, betw, tow);
    }

    static void han_tow(int val, int start, int betw, int tow) {
        if (val != 0) {
            han_tow(val - 1, start, tow, betw);
            System.out.printf("Переместите из '%d' в '%d'\n", start, tow); 
            han_tow(val - 1, betw, start, tow);
        }
    }
}
