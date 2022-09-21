// Реализация волнового алгоритма

package HomeWork5;

public class HomeWork5 {
    public static void main(String[] args) {
        int[][] arr = new int[10][9];
        fillArr(arr);

        int iFin = 2;
        int jFin = 6;
        int finish = arr[iFin][jFin] = 1;
        int start = arr[7][2] = 2;

        printArr(arr);
        System.out.println("________________________________________________________");

        checkArr(arr, start, finish);
        printArr(arr);
        System.out.println("________________________________________________________");

        findWay(arr, start, iFin, jFin);
        printArr(arr);
    }

    static void findWay(int[][] arr, int start, int i, int j) {
        int value = arr[i][j];
        while (value > start) {
            if (arr[i + 1][j] == value - 1) {
                arr[i][j] = 0;
                value--;
                i++;
            }
            else if (arr[i][j + 1] == value - 1) {
                arr[i][j] = 0;
                value--;
                j++;
            }
            else if (arr[i - 1][j] == value - 1) {
                arr[i][j] = 0;
                value--;
                i--;
            }
            else if (arr[i][j - 1] == value - 1) {
                arr[i][j] = 0;
                value--;
                j--;
            }
            if (value == start) {
                arr[i][j] = 0;
            } 
        }
    }

    static void checkArr(int[][] arr, int start, int finish) {
        boolean checkTrue = true;
        while (checkTrue) { 
            int count = 0; 
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == start) {
                        if (wayArr(arr, start, finish, i, j) == false) {
                            checkTrue = false;
                        }
                        else {
                            wayArr(arr, start, finish, i, j);
                            checkTrue = true;
                            count++;
                        }
                    }
                }  
            }
            if (count == 0) checkTrue = false; 
            else {
                start++;
                checkTrue = true;
            }
        }
    }

    static boolean wayArr(int[][] arr, int start, int finish, int i, int j) {
        int count = 0;
        if (arr[i + 1][j] == 0 || arr[i + 1][j] == finish) {
            arr[i + 1][j] = start + 1;
            count++;
        }
        if (arr[i][j + 1] == 0 || arr[i][j + 1] == finish) {
            arr[i][j + 1] = start + 1;
            count++;
        }
        if (arr[i - 1][j] == 0 || arr[i - 1][j] == finish) {
            arr[i - 1][j] = start + 1;
            count++;
        }
        if (arr[i][j - 1] == 0 || arr[i][j - 1] == finish) {
            arr[i][j - 1] = start + 1;
            count++;
        }
        if (count == 0) return false;
        else return true;
    }

    static void fillArr(int[][] arr) {
        int value = -3;
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = value;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i][arr[i].length - 1] = value;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            arr[arr.length - 1][i] = value;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i][0] = value;
        }
        for (int i = 3; i < arr.length - 3; i++) {
            arr[i][arr.length / 2] = value;
        }
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(" %4d ", arr[i][j]);
            }
            System.out.println("\n");
        }
    }
}