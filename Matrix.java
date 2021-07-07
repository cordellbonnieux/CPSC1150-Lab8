import java.util.*;
public class Matrix {
    public static void main(String[] args) {



    }
    public static int readM(){

        //
    }

    public static double[][] genMatrix(int m) {

        // create double matrix of size m x m
        double[][] matrix = new double[m][m];

        // fill the matrix with random values
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < m; column++) {
                matrix[row][column] = 0 + Math.random() * 99.99;
            }
        }

        return matrix;
    }
}