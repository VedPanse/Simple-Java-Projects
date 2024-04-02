import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] firstList = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] secondList = {
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        Matrix firstMatrix = new Matrix(firstList);
        Matrix secondMatrix = new Matrix(secondList);

        System.out.println(firstMatrix.multiply(secondMatrix).toString());
    }
}