import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Hard {
	static int[] inputs = { 9186, 73, 98, 882, 13779, 179, 388, 1531, 1092,
			5832, 675171, 538, 9032, 778, };

	public static ArrayList<Integer> primeFactors(int number) {
		int n = number;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		return factors;
	}

	public static void main(String[] args) {
		System.out.println(primeFactors(12));
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setTitle("Prime Factorization");
		frame.setLocationRelativeTo(null);

		JPanel top = new JPanel(new FlowLayout());
		JPanel bot = new JPanel(new FlowLayout());

		final JLabel labelAnswer = new JLabel();
		JButton factorButton = new JButton("Enter");
		final JTextField field = new JTextField(10);

		top.add(field);
		top.add(factorButton);
		bot.add(labelAnswer);

		JPanel outer = new JPanel(new BorderLayout());
		outer.add(top, BorderLayout.NORTH);
		outer.add(bot, BorderLayout.CENTER);

		frame.add(outer);

		// Listen for changes in the text
		field.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
		    warn();
		  }
		  public void removeUpdate(DocumentEvent e) {
		    warn();
		  }
		  public void insertUpdate(DocumentEvent e) {
		    warn();
		  }

		  public void warn() {
		     if (Integer.parseInt(field.getText())<=0){
		       JOptionPane.showMessageDialog(null,
		          "Error: Please enter number bigger than 0", "Error Massage",
		          JOptionPane.ERROR_MESSAGE);
		     }
		  }
		});
		factorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String legit = "";
				for (Integer x : primeFactors(Integer.parseInt(field.getText())))
					legit += x + " ";
				labelAnswer.setText(legit);
			}
		});
		frame.setVisible(true);

		for (int i : inputs)
			for (int j : inputs)
				if (i * j == 1350342)
					System.out.println("I: " + i + " J: " + j);
	}
}