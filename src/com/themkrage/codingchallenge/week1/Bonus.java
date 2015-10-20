package com.themkrage.codingchallenge.week1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Bonus {

	public static ArrayList<Integer> getPrimeFactors(int number) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 2; i <= number; i++) { // Add one until i (what we try to divide number by) is greater than the number itself
			while (number % i == 0) { // while number is evenly divisible by i
				results.add(i);
				number /= i; // get the new "number" then continue finding factors 
			}
		}
		return results;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setTitle("Prime Factorization");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top = new JPanel(new FlowLayout());
		JPanel bot = new JPanel(new FlowLayout());

		final JLabel labelAnswer = new JLabel();
		final JTextField field = new JTextField(10);

		top.add(field);
		bot.add(labelAnswer);

		JPanel outer = new JPanel(new BorderLayout());
		outer.add(top, BorderLayout.NORTH);
		outer.add(bot, BorderLayout.CENTER);

		frame.add(outer);

		// Listen for changes in the text
		field.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				if (field.getText().length() > 0) {
					String legit = "";
					for (Integer x : getPrimeFactors(Integer.parseInt(field
							.getText())))
						legit += x + " ";
					if (legit.isEmpty())
						legit = "None";
					labelAnswer.setText(legit);
				} else {
					labelAnswer.setText("None");
				}
			}

			public void insertUpdate(DocumentEvent e) {
				String legit = "";
				for (Integer x : getPrimeFactors(Integer.parseInt(field.getText())))
					legit += x + " ";
				if (legit.isEmpty())
					legit = "None";
				labelAnswer.setText(legit);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}
		});
		frame.setVisible(true);
	}
}