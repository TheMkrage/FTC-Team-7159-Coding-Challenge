package com.themkrage.codingchallenge.week3;

import java.util.Stack;

public class Hard {
	private static int GOAL = 123456789;

	private static final String[] places = { "", "thousand", "million",
			"billion", "trillion" };
	private static final String[] tensPlaces = { "", " ten", " twenty",
			" thirty", " forty", " fifty", " sixty", " seventy", " eighty",
			" ninety" };

	private static final String[] numNames = { "", " one", " two", " three",
			" four", " five", " six", " seven", " eight", " nine", " ten",
			" eleven", " twelve", " thirteen", " fourteen", " fifteen",
			" sixteen", " seventeen", " eighteen", " nineteen" };

	private static String convertLessThanOneThousand(int number) {
		String soFar;
		if (number % 100 < 20) { // These numbers dont follow pattern
			soFar = numNames[number % 100];
			number /= 100;
		} else { // Every number follows the following (other than 1 - 20
			soFar = numNames[number % 10];
			number /= 10;

			soFar = tensPlaces[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return numNames[number] + " hundred" + soFar;
	}

	public static void main(String[] arg) {
		Stack<Integer> list = new Stack<Integer>();
		while (GOAL > 0) {
			list.add(GOAL % 1000);
			GOAL = GOAL / 1000;
		}
		int max = list.size() - 1;
		int counter = 0;
		while (counter < max + 1) {
			System.out.print(convertLessThanOneThousand(list.pop()) + " "
					+ places[max - counter]);
			counter++;
		}
	}
}
