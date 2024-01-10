import java.util.*;

public class SeniorStudentManager {
	static Scanner input = new Scanner(System.in);
	static String[][] studentData;
	static int ROWS;
	static int COLS = 4;

	// main method
	public static void main(String[] args) {
		inputStudentData();
		print();
		hasStudentWithName();
		getStudentWithHighestGPA();
	}

	// prompt the user with the amount of students they want in the list
	public static void inputStudentData() {
		System.out.print("Enter number of students: ");
		ROWS = input.nextInt();
		studentData = new String[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			System.out.print("Enter student data (ID, name, major and GPA): ");
			input = new Scanner(System.in);
			String info = input.nextLine();
			// splits strings
			String[] rowInfo = info.split(",");
			// check if the array length is equals to 4
			if (studentData[i].length < 4 || studentData[i].length > 4) {
				System.out.print("Invalid Student Data");
				break;
			} else
				studentData[i] = rowInfo;
		}
	}

	// print the array with the input the user entered
	public static void print() {
		String s;
		System.out.println("Here is the student list");
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				s = studentData[i][j];
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}

	// method checks whether the student is in the list
	public static boolean hasStudentWithName() {
		System.out.print("Enter a student name to search: ");
		String s = input.next();
		boolean found = false;
		// gets the string in to upper case so it can be compared to the values on the list
		s = s.toUpperCase();
		for (int i = 0; i < ROWS; i++) {
			studentData[i][1] = studentData[i][1].toUpperCase();
			if (s.equals(studentData[i][1])) {
				found = true;
			}
		}
		if (found)
			System.out.println("Student with the name " + s + " exists in the list.");
		else
			System.out.println("Student with the name " + s + " is not in the list.");
		return true;
	}

	// checks which student has the highest GPA in the array
	public static void getStudentWithHighestGPA() {
		double x = 0.0;
		double max = 0.0;
		int highestGPA = 0;
		int i = 0;
		String highestPerson = "";
		for (; i < ROWS; i++) {
			x = Double.parseDouble(studentData[i][3]);
			if (x > max) {
				max = x;
				highestGPA = i;
				highestPerson = studentData[i][1];
			}
		}
		System.out.println("The person with the highest GPA is: " + highestPerson);
	}
}
