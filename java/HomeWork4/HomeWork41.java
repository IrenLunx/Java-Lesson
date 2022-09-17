package HomeWork4;

public class HomeWork41 {
    public static void main(String[] args) {
        int[][] arr = new int[10][9];
        fillArr(arr);
        int finish = arr[2][6] = 1;
        int iStart = arr.length - 3;
        int iFinish = 2;
        int start = arr[iStart][iFinish] = 2;
        checkArr(arr, start, finish);
        printArr(arr);
    }

    static void checkArr(int[][] arr, int start, int finish) {
        boolean checkTrue = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == start) {
                    System.out.println("hhh");
                    if (wayArr(arr, start, finish, i, j) == false) {
                        System.out.println("Прохода нет!");
                        checkTrue = false;
                    }
                    else {
                        wayArr(arr, start, finish, i, j);
                        checkTrue = true;
                    }
                }
            }
            // if (checkTrue == false) break; 
            // else {
            //     start++;
            // }
            start++;
        }
    }

    static boolean wayArr(int[][] arr, int start, int finish, int i, int j) {
        int count = 0;
        System.out.println("jjj");
        if (arr[i][j + 1] == 0) {
            arr[i][j + 1] = start + 1;
            count++;
        }
        if (arr[i][j - 1] == 0) {
            arr[i][j - 1] = start + 1;
            count++;
        }
        if (arr[i - 1][j] == 0) {
            arr[i - 1][j] = start + 1;
            count++;
        }
        if (arr[i + 1][j] == 0) {
            arr[i + 1][j] = start + 1;
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
                System.out.printf(" %d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
