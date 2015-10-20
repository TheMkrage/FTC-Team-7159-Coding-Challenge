package com.themkrage.codingchallenge.week1;

public class Hard {
	private static int[] inputs = { 9186, 73, 98, 882, 13779, 179, 388, 1531,
			1092, 5832, 675171, 538, 9032, 778, };
	private static final int GOAL = 1350342;

	public static void main(String[] args) {
		for (int i : inputs)
			for (int j : inputs)
				if (i * j == GOAL)
					System.out.println(i + " times " + j + " = " + GOAL);
	}
}
