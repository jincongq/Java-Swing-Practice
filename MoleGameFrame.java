import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoleGameFrame extends JFrame {
	
	private int score;
	private int number_of_rows;
	private int number_of_columns;
	private int buttonToLightUp;
	private int maxTime;
	
	private String buttonArray[][];
	private JPanel panel;
	private Clock clock;
	private Random rand;
	
	public MoleGameFrame() {
		
		panel = new JPanel();
		number_of_rows = 2;
		number_of_columns = 3;
		maxTime = 2000;
		
		buttonArray = new String[][]{
			{"w","e", "r"},
			{"s", "d", "f"}
		};
		
		
		panel.setLayout(new GridLayout(number_of_rows, number_of_columns));
		
		for (int i = 0; i < number_of_rows; i++) {
			
			for (int j = 0; j < number_of_columns; j++) {
				JButton button = new JButton(buttonArray[i][j]);
				ActionListener buttonListener = new ButtonListener();
				button.addActionListener(buttonListener);
				button.setFont(new Font("Helvetica", Font.PLAIN,60));
				panel.add(button);
			}
		}
		this.add(panel);
	}
	
	private int findButtonToLightUp() {
		rand = new Random();
		return rand.nextInt(number_of_rows * number_of_columns) + 1;
	}
	
	private int findTimeBeforeLightUp() {
		rand = new Random();
		return rand.nextInt(maxTime) + 1;
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JButton button = (JButton) event.getSource();
		}
	}
	
}
