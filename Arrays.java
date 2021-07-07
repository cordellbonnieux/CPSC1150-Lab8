import java.util.Scanner;
/**
 * Arrays.java
 * This program reads 5 double values, then returns their average; all inside in the console.
 * 
 * Class: CPSC 1050 W01
 * Instructor: Dr. Bita Shadgar
 * 
 * @author Cordell Bonnieux
 * @version 1.0
 * @since 2021-07-07
 */
public class Arrays {

    public static void main(String[] args) {

        // read 5 doubles from the user
        double[] values = new double[5];
        getValues(values);

        // uncomment to test the other (integer) average() method
        //int[] testInts = {3, 4, 5, 6, 7};
        //System.out.println("average is " + average(testInts));


        // get the average of the 5 doubles
        double average = average(values);

        // print the average
        System.out.println("The avaerage of the array is: " + average);
        
        
    }

    /**
     * Receives a double array, then reads in 5 values to that array
     * @param values the array in which values are read into
     */
    public static void getValues(double[] values) {

        // create scanner object
        Scanner scan = new Scanner(System.in);

        // prompt the user
        System.out.println("Please enter 5 float values");

        // read in the values from user
        for (int i = 1; i <= 5; i++) {
            System.out.print("Value #" + i + ": ");
            values[i-1] = scan.nextDouble();
            //System.out.println();
        }

        // Print out the current values
        System.out.println("The array is currently storing: " + values[0] 
            + ", " + values[1] + ", " + values[2] 
            + ", " + values[3] + ", " + values[4]);

        // close the scanner
        scan.close();
    }

    /**
     * Takes in an array of integers, sums them, then divides the result
     * by the number of array items, finally returns the result.
     * @param array an array of integers to be averaged
     * @return an integer which is the average of the sum of array
     */
	public static int average(int[] array) {

        // store the sum; store the index num
        int sum = 0, num = 0;

        // loop and assign
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            num++;
        }

        // return the average
        return sum / num;
	}

    /**
     * Takes in an array of doubles, sums them, then divides the result
     * by the number of array items, finally returns the result.
     * @param array an array of doubles to be averaged
     * @return an integer which is the average of the sum of array
     */
	public static double average(double[] array) {

        // store the sum; store the index num
        double sum = 0;
        int num = 0;

        // loop and assign
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            num++;
        }

        // return the average
        return sum / num;
	}
}