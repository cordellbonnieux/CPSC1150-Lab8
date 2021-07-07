import javax.swing.JOptionPane;
public class TestSwing {
	public static void main(String[] args){

		String userInput = JOptionPane.showInputDialog(null, "Enter a positive number : ");
		int num = Integer.parseInt(userInput);
		if (num > 0)
			JOptionPane.showMessageDialog(null, num*num + " is the square of " + num );
		else 
			JOptionPane.showMessageDialog(null, "Invalid Data: " + num + " is not a positive number!"  );
	}
}