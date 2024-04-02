import java.util.Arrays;

public class Matrix {
    int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix multiply(int scalar) {
        int[][] newMatrix = Arrays.copyOf(this.matrix, this.matrix.length);

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++)
                newMatrix[i][j] *= scalar;
        }

        return new Matrix(newMatrix);
    }

    public Matrix multiply(Matrix newMatrix) {
        int [][] A = this.matrix;
        int [][] B = newMatrix.matrix;

        int[][] AB = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++)
                    AB[i][j] += A[i][k] * B[k][j];
            }
        }

        return new Matrix(AB);
    }

    public Matrix transpose() {
        int[][] matList = this.matrix;

        int[][] newList = new int[this.matrix.length][this.matrix[0].length];

        for (int i = 0; i < matList.length; i++) {
            for (int j = 0; j < matList[0].length; j++) {
                newList[j][i] = matList[i][j];
            }
        }

        return new Matrix(newList);
    }

    public Matrix add(int[][] anotherMatrix) {
        int[][] newMatrix = Arrays.copyOf(anotherMatrix, anotherMatrix.length);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++)
                newMatrix[i][j] = this.matrix[i][j] + anotherMatrix[i][j];
        }

        return new Matrix(newMatrix);
    }

    public Matrix add(Matrix anotherMatrix) {
        int[][] newMatrix = Arrays.copyOf(anotherMatrix.matrix, anotherMatrix.matrix.length);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++)
                newMatrix[i][j] = this.matrix[i][j] + anotherMatrix.matrix[i][j];
        }

        return new Matrix(newMatrix);
    }

    public Matrix subtract(int[][] anotherMatrix) {
        int[][] newMatrix = Arrays.copyOf(anotherMatrix, anotherMatrix.length);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++)
                newMatrix[i][j] = this.matrix[i][j] - anotherMatrix[i][j];
        }

        return new Matrix(newMatrix);
    }

    public Matrix subtract(Matrix anotherMatrix) {
        int[][] newMatrix = Arrays.copyOf(anotherMatrix.matrix, anotherMatrix.matrix.length);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++)
                newMatrix[i][j] = this.matrix[i][j] - anotherMatrix.matrix[i][j];
        }

        return new Matrix(newMatrix);
    }

    public String toString() {
        return Arrays.deepToString(this.matrix);
    }
}
