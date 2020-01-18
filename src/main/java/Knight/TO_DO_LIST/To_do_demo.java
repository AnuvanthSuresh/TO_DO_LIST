package Knight.TO_DO_LIST;

import java.util.Scanner;

import db_Operations.DB_Operation;
import utilities.Function;

public class To_do_demo {

	public static void main(String[] args) {

		// Method defs
		Scanner get_data = new Scanner(System.in);
		DB_Operation db_operation = new DB_Operation();
		Function function = new Function();
		boolean exitFlag = false;
		int option = 0;
		String customDate = "", task_id = "", choice = "";

		if (db_operation.Check_connection()) {

			while (!exitFlag) {
				// db_operation.Check_connection();
				System.out.println();
				System.out.println();
				function.menu();

				// Choice of operation
				try {
					option = Integer.parseInt(get_data.nextLine());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

				switch (option) {

				case 1:
					db_operation.Get_task();
					break;

				case 2:
					System.out.println();
					System.out.println("*****************");
					System.out.println("ADD A NEW TASK");
					System.out.println("*****************");
					System.out.println();
					System.out.print("Enter Task : ");
					String task = get_data.nextLine();
					System.out.print("want to take system date (y/n):  ");
					String dateChoice = get_data.nextLine();
					if (dateChoice.equalsIgnoreCase("n")) {
						System.out.print("Enter date in Format (mm/dd/yyyy) : ");
						customDate = get_data.nextLine();
						db_operation.insert_Task(task, customDate);
					} else if (dateChoice.equalsIgnoreCase("y")) {
						System.out.println(function.getDate());
						db_operation.insert_Task(task, function.getDate());
					} else {
						System.out.println("Invalid option selected aborting");
					}
					// System.out.println("TASK ADDED TO LIST");
					break;

				case 3:

					System.out.println();
					System.out.println("*************************");
					System.out.println("UPDATE STATUS OF A TASK");
					System.out.println("*************************");
					System.out.println();
					System.out.print("Enter Task ID to be updated : ");
					task_id = get_data.nextLine();
					System.out.print("Status to be Updated (completed-C/Due-D) : ");
					String status = get_data.nextLine();
					String pStatus;
					if (status.equalsIgnoreCase("C")) {
						pStatus = "completed";
					} else {
						pStatus = "due";
					}
					db_operation.update_status(pStatus, task_id);
					break;

				case 4:
					System.out.println();
					System.out.println("***********************");
					System.out.println("MAKE CHANGES TO A TASK");
					System.out.println("***********************");
					System.out.println();
					System.out.print("Enter Task ID to be updated : ");
					task_id = get_data.nextLine();
					System.out.print("Enter Task : ");
					task = get_data.nextLine();
					System.out.print("want to take system date (y/n):  ");
					dateChoice = get_data.nextLine();
					if (dateChoice.equalsIgnoreCase("n")) {
						System.out.print("Enter date in Format (mm/dd/yyyy) : ");
						customDate = get_data.nextLine();
						db_operation.update_Task(task, customDate, task_id);
					} else if (dateChoice.equalsIgnoreCase("y")) {
						System.out.println(function.getDate());
						db_operation.update_Task(task, function.getDate(), task_id);
					} else {
						System.out.println("Invalid option Aborting");
					}
					break;

				case 5:
					System.out.println();
					System.out.println("*************");
					System.out.println("DELETE A TASK");
					System.out.println("**************");
					System.out.println();
					System.out.print("Enter task ID to be Deleted : ");
					task_id = get_data.nextLine();
					db_operation.delete_Task(task_id);
					break;

				case 6:
					System.out.println();
					System.out.println("**********************");
					System.out.println("FILTER TASK ON DATES");
					System.out.println("**********************");
					System.out.println();
					System.out.print("want to take system date (y/n):  ");
					dateChoice = get_data.nextLine();
					if (dateChoice.equalsIgnoreCase("n")) {
						System.out.print("Enter date in Format (mm/dd/yyyy) : ");
						customDate = get_data.nextLine();
						db_operation.Filter(customDate);
					} else if (dateChoice.equalsIgnoreCase("y")) {
						System.out.print("Current system date : " + function.getDate());
						db_operation.Filter(function.getDate());
					} else {
						System.out.println("Invalid option Aborting");
					}
					break;

				case 7:
					System.out.println();
					System.out.println("**************");
					System.out.println("RESET ALL TASK ");
					System.out.println("**************");
					System.out.println();
					System.out.print("Will delete all task, do you wish to continue (y/n) :");
					choice = get_data.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						db_operation.Reset_all();
					} else {
						System.out.print("Reset tasks cancelled");
					}
					break;

				case 8:
					System.out.println();
					System.out.println("\t\t\t\t*************************");
					System.out.println("\t\t\t\tEXITING TO DO LIST");
					System.out.println("\t\t\t\t*************************");
					System.out.println();
					System.out.print("Exiting TO DO LIST");
					exitFlag = true;
					break;

				default:
					System.out.print("Enter a valid option");
					break;
				}
			}
		}
		get_data.close();
	}
}