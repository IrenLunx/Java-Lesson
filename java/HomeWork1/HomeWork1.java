/*
+На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d, к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к2, к2, к2, к2, к2, к2 или к1, к1, к2, к2, к2 
Можно начать с более простого – просто подсчёта общего количесвтва вариантов 
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения. 
*Подумать над тем, как сделать минимальное количество команд
 */

package HomeWork1;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число 'a': ");
        int numA = in.nextInt();
        System.out.println("Введите число 'b': ");
        int numB = in.nextInt();
        in.close();
        
        int numC = 2;
        int numD = 1;
        if (numA >= numB) {
            System.out.printf("Решения нет!");
        } 
        else {
            int[] mas = new int[numB + 1];
            mas[numA] = 1;
            int[] res = recWay(mas, numA + 1, numB + 1, numC, numD);
            System.out.println(printArr(res));
            String resWay = wayArr(numA, numB, numC, numD);
            System.out.println(resWay); 
        }
    }

    static String printArr(int[] mas) {
        String res = "";
        for (int i = 0; i < mas.length; i++) {
            if (i == mas.length - 1) {
                res += String.format("\nКоличество вариантов для %d = %d", i, mas[i]);
            }
            else res += String.format("%d=%d ", i, mas[i]);
        }
        return res;
    }

    static int[] recWay(int[] mas, int numA, int numB, int numC, int numD) {
        if (numA == numB) return mas;
        if (numA % 2 == 0) {
            mas[numA] = mas[numA - numD] + mas[numA / numC];
            return recWay(mas, numA + numD, numB, numC, numD);
        }
        else {
            mas[numA] = mas[numA - numD];
            return recWay(mas, numA + numD, numB, numC, numD);
        }
    }

    static String wayArr(int numA, int numB, int numC, int numD) {
        String result = "Путь: ";
        while (numA < numB) {
            if (numA % 2 == 0 & numA * numC <= numB & numA > 0) {
                numA *= numC;
                result += "k1 ";
            }
            else {
                numA += numD;
                result += "k2 ";
            }
        } 
        return result;
    }


}