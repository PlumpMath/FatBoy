import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HighScoreMenu {

	static JFrame window = new JFrame();
	static private HighScoreMenu self;
	static JButton button = new JButton("Fatastic");
	static JTextArea textBox = new JTextArea();
	static JLabel label = new JLabel("Name:");
	static JLabel yourScoreLabel = new JLabel("Your score:");
	static JLabel scoreLabel;
	static String name = new String();
	static ShowHighScore shs;
	static int score;
	static int maxNameLength=14;

	public HighScoreMenu(int pScore)
	{
		shs = new ShowHighScore();
		self= this;
		score = pScore;
	}
	
	public static void inputName(final int score) {

		scoreLabel = new JLabel(Integer.toString(score));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize((int) (Settings.width() * 0.25),
				(int) (Settings.height() * 0.25)); // Bredd och höjd.
		window.setLocation((int) (Settings.width() * 0.6),
				(int) (Settings.height() * 0.2)); // x och y.
		window.setTitle("HighScore");
		//
		// Man lögger komponenterna i en
		// "content pane" (innehöllspanel).
		//
		Container content = window.getContentPane();

		//
		// Hör talar vi om att vi inte vill ha nögon
		// automatisk layouthantering av komponenterna
		// i fönstret (null = ingenting/tomt).
		//
		content.setLayout(null);

		//
		// Nu lögger vi in komponenterna och positionerar dem.
		// Koordinatsystemet börjar i övre vönstra hörnet,
		// y vöxer nedöt. Enheten ör bildpunkter.
		//
		content.add(button);
		content.add(label);
		content.add(textBox);
		content.add(scoreLabel);
		content.add(yourScoreLabel);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (ae.getSource() == button) {
					name = textBox.getText();
					name=name.replaceAll("\\n", "");
					if(name.length()>maxNameLength)
						name=name.substring(0, maxNameLength);
					HighscoreManager hm = new HighscoreManager();
					// Hör sötter vi in vöra variabler för poöng och namn 
					hm.addScore(name,getScore());
					
				    self.window.dispose();
				    shs.showScore();
					
				}
			}
		});

	
		//
		// Argumenten till setBounds() ör x, y, bredd, höjd.
		//
		label.setBounds((int) (window.getWidth() * 0.015),
				(int) (window.getHeight() * 0.005),
				(int) (window.getWidth() * 0.97),
				(int) (window.getHeight() * 0.20));
		textBox.setBounds((int) (window.getWidth() * 0.015),
				(int) (window.getHeight() * 0.20),
				(int) (window.getWidth() * 0.97),
				(int) (window.getHeight() * 0.10));
		button.setBounds((int) (window.getWidth() * 0.33),
				(int) (window.getHeight() * 0.35),
				(int) (window.getWidth() * 0.33),
				(int) (window.getHeight() * 0.20));
		scoreLabel.setBounds((int) (window.getWidth() * 0.45),
				(int) (window.getHeight() * 0.5),
				(int) (window.getWidth() * 0.8),
				(int) (window.getHeight() * 0.5));
		yourScoreLabel.setBounds((int) (window.getWidth() * 0.05),
				(int) (window.getHeight() * 0.5),
				(int) (window.getWidth() * 0.8),
				(int) (window.getHeight() * 0.5));

		//
		// öppna fönstret.
		//
		window.show();

	}

	public static String getName() {
		return name;
	}
	
	public static int getScore() {
		return score;
	}
}
