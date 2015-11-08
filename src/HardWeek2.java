
public class HardWeek2 {
	
	private static String GOAL = "Apple";
	private static String start = "pig";
	public static void main(String[] args) {
		for(int i = 0; i < GOAL.length(); i++) {
			if(start.toCharArray()[i] == GOAL.toCharArray()[i])
				break;
			// if from current index to end of GOAL has the current start letter
			if(GOAL.substring(i, GOAL.length()).contains(start.substring(i, i + 1))) { 
				System.out.println("YAY");
			}
		}
	}
}
