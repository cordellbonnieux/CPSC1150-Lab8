import java.util.*;
public class Matrix {
    public static void main(String[] args) {

        // read a matrix size
        int m = readM();

        // Q1 - generate a matrix 
        double[][] matrix = genMatrix(m);

        // Q2 - print matrix
        printMatrix(matrix);

        // Q3 - is matrix symmetric?
        // this is a symmetric array you can uncomment to test the method
        //double[][] testArr = {{1,2,3},{2,4,5},{3,5,8}};
        System.out.println("Is this matrix symmetric? " + ((isSymmetric(matrix)) ? "Yes" : "No"));


    }
    /**
     * Read an integer to be used as a matrix size. 
     * Validates the integer to ensure it is within the range of 1-99.
     * If the integer is invalid, the method is called again.
     * @return readM() recursively call the method if the integer is invalid
     * @return m return the matrix size if valid
     */
    public static int readM(){

        // create scanner object
        Scanner scan = new Scanner(System.in);

        // prompt user to enter desired matrix size
        System.out.print("Please enter a matrix size (positive integer below 100): ");

        // read matrix size
        int m = scan.nextInt();

        // check for validity and return
        if (m > 99 || m < 1)
            return readM();
        else
            return m;
    }

    /**
     * Question 1
     * Creates a 2D matrix (double array) of m x m size, filled with randomly generated doubles.
     * @param m size of the matrix
     * @return matrix of m x m size
     */
    public static double[][] genMatrix(int m) {

        // create double matrix of size m x m
        double[][] matrix = new double[m][m];

        // fill the matrix with random values
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < m; column++) {
                matrix[row][column] = 1 + Math.random() * 99;
            }
        }

        return matrix;
    }

    /**
     * Question 2
     * Prints a 2D matrix array of type double to the console
     * 
     * Must rework this one
     * @param matrix a 2D double array to be printed
     */
    public static void printMatrix(double[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            // add a row heading
            System.out.print("row #" + ((row < 9) ? "0" + (row+1) : (row+1)) + ":");
            
            for (int column = 0; column < matrix[row].length; column++) {

                // truncate the double to 2 decimal points
                double num = Math.floor(matrix[row][column] * 100) / 100;

                // add a 0 at the begining if needed 
                if (num < 10) {

                    System.out.print("  0" + num);

                    // add a 0 at the end if needed
                    if (String.valueOf(num).length() < 4)
                        System.out.print("0");

                } else {

                    System.out.print("  " + num);

                    // add 0 to the end if needed
                    if (String.valueOf(num).length() < 5)
                        System.out.print("0");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
    /**
     * Question 3
     * 
     * @param matrix
     * @return
     */
    public static Boolean isSymmetric(double[][] matrix) {

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i])
                    return false;
            }
        }

        return true;
    }
}