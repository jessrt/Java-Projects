import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonEvent implements ActionListener{
	private int n; 
	JTextField user_input;
	JLabel return_message;
	
	// Constructor for ButtonEvent class
	
	public ButtonEvent(int n, JTextField user_input, JLabel return_message) {
		this.n = n; 
		this.user_input = user_input;
		this.return_message = return_message;
		return_message.setForeground(Color.white);
		return_message.setFont(new Font("Courier", Font.BOLD, 26));
	}
	
	public void actionPerformed(ActionEvent ar) {
		String ui = user_input.getText(); 
		int guessed_number = 0; 
	
		// Determines if user's input is equal to generated number.
		// Returns a message if guess is too high or low. 
		// Returns an error message if input is not an integer
		
		try {
			guessed_number = Integer.parseInt(ui);
			if (ar.getActionCommand().equals("Check")) {
				if (guessed_number > n) {
					return_message.setText(guessed_number + " is too high of a guess.");
				}
				else if (guessed_number < n) {
					return_message.setText(guessed_number + " is too low of a guess.");
				}
				else return_message.setText("Yes! The number is " + n + "!");
			}
		}
		catch(NumberFormatException e) {
			return_message.setText("Input must be an integer.");
		}	
	}
}
