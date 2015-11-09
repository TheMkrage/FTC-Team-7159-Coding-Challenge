package com.themkrage.codingchallenge.week4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Week4 {

	private static String[] symbols = { "^", "*", "/", "+", "-" };

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setTitle("Expression Calculator");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top = new JPanel(new FlowLayout());
		JPanel bot = new JPanel(new FlowLayout());

		final JLabel labelAnswer = new JLabel("Type An Expression Above");
		final JTextField field = new JTextField(10);

		JButton but = new JButton("GO");
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				labelAnswer.setText(getAnswer(field.getText()));
			}

		});
		top.add(but);
		top.add(field);
		bot.add(labelAnswer);

		JPanel outer = new JPanel(new BorderLayout());
		outer.add(top, BorderLayout.NORTH);
		outer.add(bot, BorderLayout.CENTER);

		frame.add(outer);

		frame.setVisible(true);
	}

	private static String getAnswer(String text) {
		text = text.replaceAll(" ", "");
		for (int i = 0; i < symbols.length; i++) {
			String curSymbol = symbols[i];
			System.out.println("testing " + curSymbol + " for " + text);
			while (text.indexOf(curSymbol) != -1) {
				System.out.println(text + " for " + curSymbol);
				int indexOfSymbol = text.indexOf(curSymbol);
				// Find leftStart
				int leftStart = indexOfSymbol - 1;
				for (; leftStart > 0; leftStart--) {
					if (text.charAt(leftStart) == '+'
							|| text.charAt(leftStart) == '-'
							|| text.charAt(leftStart) == '/'
							|| text.charAt(leftStart) == '*'
							|| text.charAt(leftStart) == '^') {
						leftStart++;
						break;
					}
				}
				if (leftStart == -1) // if answer is negative
					return text;
				int rightEnd = indexOfSymbol + 1;
				for (; rightEnd < text.length(); rightEnd++) {
					if (rightEnd == text.length()
							|| text.charAt(rightEnd) == '+'
							|| text.charAt(rightEnd) == '-'
							|| text.charAt(rightEnd) == '/'
							|| text.charAt(rightEnd) == '*'
							|| text.charAt(rightEnd) == '^') {
						break;
					}
				}
				System.out.println("leftStart: " + leftStart + " rightEnd "
						+ rightEnd);
				double leftTerm = Double.parseDouble(text.substring(leftStart,
						indexOfSymbol));
				double rightTerm = Double.parseDouble(text.substring(
						indexOfSymbol + 1, rightEnd));
				System.out
						.println("left: " + leftTerm + " right: " + rightTerm);
				text = text.substring(0, leftStart)
						+ getForFunction(curSymbol, leftTerm, rightTerm)
						+ text.subSequence(rightEnd, text.length());
				System.out.println(text);
			}
		}
		return text;
	}

	private static String getForFunction(String curSymbol, double leftTerm,
			double rightTerm) {
		switch (curSymbol) {
		case "^":
			return "" + Math.pow(leftTerm, rightTerm);
		case "*":
			return "" + (leftTerm * rightTerm);
		case "/":
			return "" + (leftTerm / rightTerm);
		case "+":
			return "" + (leftTerm + rightTerm);
		case "-":
			return "" + (leftTerm - rightTerm);
		default:
			return "Something broke";
		}
	}
}
