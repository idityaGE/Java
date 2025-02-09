
import java.util.Scanner;

class TwoDArray {

    private int[][] mat;
    private int rows, cols;

    TwoDArray(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        mat = new int[rows][];
        for (int i = 0; i < rows; i++) {
            if ((i & 1) == 0) { // Even 
                mat[i] = new int[cols];
            } else { // Odd 
                mat[i] = new int[cols + 1];
            }
        }
    }

    public void insert() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("Enter element at index " + i + " " + j + ": ");
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        TwoDArray obj = new TwoDArray(rows, cols);
        obj.insert();
        obj.display();
        sc.close();
    }
}
