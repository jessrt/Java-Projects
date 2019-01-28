import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main {
	public static void main(String args[]) {
		
		// Set random number
		int random = (int)(Math.random() * 100 + 1);
		
		// Set initial JFrame
		JFrame gui = new JFrame();
		gui.setTitle("Guess the number!");
		gui.setResizable(true);
		gui.setSize(500, 200);
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gui.setVisible(true);
	
		// Create content pane
		Container pane = gui.getContentPane();
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
		pane.setBackground(new Color(100,85,100));
		
		// Create text area for user input
		JTextField user_input = new JTextField(10);
		user_input.setHorizontalAlignment(JTextField.CENTER);
		user_input.setFont(new Font("Courier", Font.BOLD, 16));
		pane.add(user_input);
		
		// Create clickable button
		JButton rand = new JButton("Guess between 1 & 100!");
		rand.setBackground(Color.YELLOW);
		pane.add(rand);
		Font c = new Font("Courier", Font.BOLD, 22);
		rand.setFont(c);
		rand.setActionCommand("Check");
		
		//Display message from program
		JLabel return_message = new JLabel("");
		pane.add(return_message);
		
		// Button will take generated random number, user's input, and program's display message
		ButtonEvent chk = new ButtonEvent(random, user_input, return_message);
		rand.addActionListener(chk);
		
	}
}
