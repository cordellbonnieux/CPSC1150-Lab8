import java.util.Scanner;
public class Arrays {

    public static void main(String[] args) {

        // read 5 doubles from the user
        double[] values = new double[5];
        getValues(values);

        // if you want to test the other average() method
        //int[] testInts = {3, 4, 5, 6, 7};
        //System.out.println("average is " + average(testInts));


        // get the average of the 5 doubles
        double average = average(values);

        // print the average
        System.out.println(average);
        
        
    }

    public static void getValues(double[] values) {

        // create scanner object
        Scanner scan = new Scanner(System.in);

        // prompt the user
        System.out.println("Please enter 5 float values");

        // read in the values from user
        for (int i = 1; i <= 5; i++) {
            System.out.print("Value #" + i + ": ");
            values[i-1] = scan.nextDouble();
            System.out.println();
        }

        // Print out the current values
        System.out.println("The array is currently storing: " + values[0] 
            + ", " + values[1] + ", " + values[2] 
            + ", " + values[3] + ", " + values[4]);

        // close the scanner
        scan.close();
    }

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

	public static double average(double[] array) {

		return array;
	}
}