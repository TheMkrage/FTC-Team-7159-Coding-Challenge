package com.themkrage.codingchallenge.week2;

public class Hard {

	private static String GOAL = "apple";
	private static String start = "jfifdor312f";

	public static void main(String[] args) {
		int moves = 0, searchAhead = -1;
		String mutalatedString = start;
		for (int i = 0; i < GOAL.length(); i++) {
			if (mutalatedString.length() <= i) {
				mutalatedString += GOAL.toCharArray()[i];
				moves++;
				System.out.println("Added " + GOAL.toCharArray()[i] + " "
						+ mutalatedString);
			} else if (mutalatedString.toCharArray()[i] == GOAL.toCharArray()[i]) {

			} else {
				// if from current index to end of GOAL has the current start
				// letter

				// Look ahead and determine the index of the right
				// character
				for (int x = i; x < mutalatedString.length(); x++) {
					if (mutalatedString.toCharArray()[x] == GOAL.toCharArray()[i]) {
						searchAhead = x;
						break;
					}
				}

				if (searchAhead != -1) {
					for (int x = i; x < searchAhead; x++) {
						moves++;
						System.out.println("Removed "
								+ mutalatedString.charAt(i) + " ");
						mutalatedString = mutalatedString.substring(0, i)
								+ mutalatedString.substring(i + 1,
										mutalatedString.length());
						System.out.print(mutalatedString + " \n");
					}
				} else {

					System.out.println("Removed "
							+ mutalatedString.toCharArray()[i] + " "
							+ mutalatedString);
					mutalatedString = mutalatedString.substring(0, i)
							+ GOAL.toCharArray()[i]
							+ mutalatedString.substring(i + 1,
									mutalatedString.length());

					System.out.println("Added " + GOAL.toCharArray()[i] + " "
							+ mutalatedString);
					moves += 2;
				}
			}

		}
		if (!mutalatedString.equals(GOAL)) {
			for (int i = 0; i < mutalatedString.length() - GOAL.length(); i++) {
				System.out.println("Removed "
						+ mutalatedString.toCharArray()[i + GOAL.length()]);
				moves++;
			}
			mutalatedString = mutalatedString.substring(0, GOAL.length());
		}
		System.out.println("Got to " + mutalatedString + " in " + moves
				+ " moves");
	}
}