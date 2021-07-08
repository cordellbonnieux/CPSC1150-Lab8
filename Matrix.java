import java.util.*;
import javax.swing.JOptionPane;
/**
 * 
 * 
 * 
 * 
 * 
 */
public class Matrix {
    public static void main(String[] args) {
        
        // 2D array reference
        double[][] matrix = ((args.length > 0) ? convertArray(args) : new double[0][0]);

        String choice = JOptionPane.showInputDialog(null, "Enter the digit corresponding to your desired task: \n 1 : Create a new matrix \n 2 : Display current matrix \n 3 : Square current matrix \n 4 : Multiply current matrix with a coefficient \n 5 : Check if current matrix is symmetric \n 6 : Quit the program ");

		int selection = Integer.parseInt(choice);

        switch (selection) {
            case 1: // create matrix
                int m = read(); // get matrix size
                double[][] newMatrix = genMatrix(m); // generate matrix based on size
                main(returnMatrix(newMatrix)); // return to main menu
                break;
            case 2: // print matrix
                if (matrix.length == 0) { // check for matrix
                    JOptionPane.showMessageDialog(null, "You need to create an array first!");
                    main(null); 
                } 
                printMatrix(matrix);
                main(returnMatrix(matrix)); // return to main menu
                break;
            case 3: // square matrix
                if (matrix.length == 0) { // check for matrix
                    JOptionPane.showMessageDialog(null, "You need to create an array first!");
                    main(null); 
                } 
                square(matrix);
                main(returnMatrix(matrix)); // return to main menu
                break;
            case 4: // multiply matrix
                if (matrix.length == 0) { // check for matrix
                    JOptionPane.showMessageDialog(null, "You need to create an array first!");
                    main(null); 
                } 
                System.out.print("Now to multiply the array by a multiple of your choice. ");
                int c = read();
                multiply(matrix, c);
                main(returnMatrix(matrix)); // return to main menu
                break;
            case 5: // check matrix for symmetry
                if (matrix.length == 0) { // check for matrix
                    JOptionPane.showMessageDialog(null, "You need to create an array first!");
                    main(null); 
                } 
                System.out.print("Is current matrix symmetric?");
                isSymmetric(matrix);
                main(returnMatrix(matrix)); // return to main menu
                break;
            case 6:
                System.exit(0);
            default:
                main(null);
        }
    }
    /**
     * This method takes a array of strings that was passed into main()
     * and converts it into a 2D array of doubles.
     * @param args a previously created matrix, that has been converted
     * @return matrix a 2D array of doubles converted from args
     */
    public static double[][] convertArray(String[] args) {
    
        // 2D array to store converted array numbers
        double[][] matrix = new double[args.length][args.length];

        // fill the matrix with current matrix
        for (int row = 0; row < args.length; row++) {
                    
                // take the current array item in args and split into it's own array
                String[] split = args[row].split(":");

                for (int column = 0; column < split.length; column++) {

                    // assign each column in current row, with values from split (args) array and convert to double
                    matrix[row][column] = Double.parseDouble(split[column]);
                }
                    
        }
        return matrix;
    }
    /**
     * This method is used to return a 1D string version of a 2D double matrix array
     * so that it can be used as a parameter in main().
     * @param matrix a 2D array of doubles, to be converted
     * @return stringMatrix a 1D string array, where each row holds all columns of the matching row of matrix
     */
    public static String[] returnMatrix(double[][] matrix) {

        String[] stringMatrix = new String[matrix.length];

        // fill the string matrix with stringified doubles from matrix
        // each row contains all columns separated by ":"s
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                stringMatrix[row] += String.valueOf(matrix[row][column]) + ":";
            }
        }

        return stringMatrix;
    }
    /**
     * Read an integer to be used as a matrix size. 
     * Validates the integer to ensure it is within the range of 1-99.
     * If the integer is invalid, the method is called again.
     * @return readM() recursively call the method if the integer is invalid
     * @return m return the matrix size if valid
     */
    public static int read(){

        // create scanner object
        Scanner scan = new Scanner(System.in);

        // prompt user to enter desired matrix size
        System.out.print("Please enter a positive integer that is less than 100: ");

        // read matrix size
        int m = scan.nextInt();

        // check for validity and return
        if (m > 99 || m < 1)
            return read();
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
     * Takes in an array of doubles and tests to see if it is symmetrical or not     * 
     * @param matrix the array of doubles to be tested
     * @return true if symmetrical, otherwise false.
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
    /**
     * Question 4
     * Takes in a double 2D array and a double, then multiplies each item in that array by the double.
     * @param matrix the matrix who's contents are to be multiplied
     * @param c the multiple 
     */
    public static void multiply(double[][] matrix, double c) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                // multiply each item by c
                matrix[i][j] = c * matrix[i][j];
            }
        }
        System.out.println("The each item in the matrix now has been multiplied by " + c);
    }
    /**
     * Question 5
     * Write a method named Square that given a matrices of n
     * rows and n columns of doubles, calculates, and returns the square of the given matrix.
     * Or, Returns a new matrix (matrixN) that holds the square of matrix * matrix.
     * @param matrix the 2D matrix to be squared
     * @return matrixN a new matrix to be returned
     */
    public static double[][] square(double[][] matrix) {

        // to store new array
        double[][] matrixN = new double[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {

            for (int column2 = 0; column2 < matrix[row].length; column2++) {

                // holds the sum of each row
                int rowSum = 0;

                for (int column = 0, row2 = 0; column < matrix[row].length; column++, row2++) {
                    
                    rowSum += matrix[row][column] * matrix[row2][column2];

                }

                // put sum into new matrix position
                matrixN[row][column2] = rowSum;
            }
        }

        return matrixN;
    }
}