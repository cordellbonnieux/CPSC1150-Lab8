import java.util.Scanner;
public class Arrays {

    public static void main(String[] args) {

        // read 5 doubles from the user
        double[] values = getValues();

        //for now print the values to test em out.
        System.out.println(values[0] + ", " + values[1] + ", " + 
            values[2] + ", " + values[3] + ", " + values[4]);

        // get the average of the 5 doubles
        double average = average(values);

        // print the average
        System.out.println(average);
        
        
    }

    public static double getValues() {

        // create scanner object
        Scanner scan = new Scanner(System.in);

        // prompt the user
        System.out.println("Please enter 5 float values");

        // create a array to hold float values
        double[] values = new double[5];

        // read in the values from user
        for (int i = 1; i <= 5; i++) {
            System.out.print("Value #" + i + ": ");
            values[i-1] = scan.nextDouble();
            System.out.println();
        }

        return values;
    }
	public static int average(int[] array) {

        return 0;
	}

	public static double average(double[] array) {

		return array;
	}
}