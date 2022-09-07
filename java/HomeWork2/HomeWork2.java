// Написать программу вычисления n-ого треугольного числа.

package HomeWork2;
import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int num = in.nextInt();
        in.close();

        if (num < 1) System.out.println("Решения нет!");
        else {
            int res = triangleVal(num);
            System.out.println(res);
        }
    }
    static int triangleVal(int num) {
        if (num == 0) return 0;
        return triangleVal(num - 1) + num;
    }
}
