package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Function {
	
	

	/*
	 * Returns date in String format
	 * dd/MM/yyyy
	 */
	
	public String getDate() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime date = LocalDateTime.now();
        return dtf.format(date);

	}

	/*
	 * Prints the list of menus available 
	 */
 
	public void menu() {
		System.out.println("\t\t\t\t********************************");
		System.out.print("\t\t\t\t*********");
		System.out.print("  --MENU-- ");
		System.out.println("*********");
		System.out.println("\t\t\t\t********************************");
		System.out.println();
	    System.out.println("1. Display All current task.");
	    System.out.println("2. Add a new task.");
	    System.out.println("3. Update COMPLETION status to a task");
	    System.out.println("4. Make changes on existing tasks.");
	    System.out.println("5. Delete a task.");
	    System.out.println("6. Filter task based on date.");
	    System.out.println("7. RESET all task's");
	    System.out.println("8. Exit.");
	    System.out.println();
	    System.out.print("Enter the option number and hit enter : ");
	}

	
}
