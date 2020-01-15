package db_Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Operation {
	private final static String URL = "jdbc:postgresql://localhost:5432/to_do_main";
	private final static String user = "to_do";
	private final static String password = "pass123";
	public static Connection db = null;

	/* 
	 * Get_task = print's all task.
	 * insert_Task = insert's task, date.
	 * update_Task = updates's any data.
	 * update_Status = update's status as done.
	 * delete_Task = Delete's task.
	 * Reset_all = Deletes all task.
	 * task_filter = print's tasks based on dates. */

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    /*
	 * prints current DATE TASK STATUS
	 */
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public void Get_task() {
		try {
			db = DriverManager.getConnection(URL, user, password);
			// Prints all data from DB task_main table
			Thread.sleep(2000);
			Statement statement = db.createStatement();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t#############################");
			System.out.print("\t\t\t\t##########");
			System.out.print("  TO DO  ");
			System.out.println("##########");
			System.out.println("\t\t\t\t#############################");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			ResultSet resultset = statement.executeQuery("SELECT TO_CHAR(date,'Mon dd yyyy') as date, TASK, STATUS, TASK_ID FROM task_main ORDER BY date DESC;");
			System.out.printf("| %-30.30s | %-30.30s | %-30.30s | %-10.10s%n", "DATE", "TASK", "STATUS", "TASK ID");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			while (resultset.next()) {
				System.out.printf("| %-30.30s | %-30.30s | %-30.30s | %-10.10s%n", resultset.getString("date"),
						resultset.getString("task"), resultset.getString("status"), resultset.getString("task_id"));
			}
			} catch (Exception e) {
			System.out.println("Query Error");
			e.printStackTrace();
		}
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	/*
	 * Inserts a new task into table 
	 * @param Task as String
	 * @param Date as String
	 */
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public void insert_Task(String task, String date) {
		try {
			db = DriverManager.getConnection(URL, user, password);
			// Statement execution
			Statement statement = db.createStatement();
			String insertQuery = "INSERT INTO task_main (date,task) values ((TO_DATE('"+ date+"','DD/MM/YYYY')),'"+ task +"');";
			statement.executeUpdate(insertQuery);
			System.out.println("Insertion succesful");

		} catch (Exception e) {
			System.out.println("Update task failed");
			e.printStackTrace();
		}
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   /*
    * updates the task based on the parameters 
    *     1) Updates task details 
    *     @param task, date, task id
    */
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public void update_Task(String task, String date, String task_id) {
		int flag = 0;
		// UPDATE task_main SET date='1/2/2003',task='updated task',status='completed' WHERE task_id='2';
		try {
			db = DriverManager.getConnection(URL, user, password);
			Statement statement = db.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT TASK_ID FROM task_main;");
			while (resultset.next()) {
				if (resultset.getString("task_id").equalsIgnoreCase(task_id)) {
					flag = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Update method failed");
			e.printStackTrace();
		}

		// Update statement
		try {
			if (flag == 1) {
				db = DriverManager.getConnection(URL, user, password);
				Statement statement = db.createStatement();
				String updateQuery = "UPDATE task_main SET date='" + date + "',task='" + task + "' WHERE task_id='"
						+ task_id + "';";
				statement.executeUpdate(updateQuery);
				System.out.println("Update successful");
			} else {
				System.out.println("Task ID doesnt exist");
			}
		} catch (Exception e) {
			System.out.println("Update Query failed");
			e.printStackTrace();
		}

	}
	   //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	   /*
	    * updates the status based on the parameters 
	    *     1) Updates status details 
	    *     @param status, task id
	    */
	   //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public void update_status(String status, String task_id) {
		int flag = 0;
		// UPDATE task_main SET status='completed' WHERE task_id='2';
		try {
			db = DriverManager.getConnection(URL, user, password);
			Statement statement = db.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT TASK_ID FROM task_main;");
			while (resultset.next()) {
				if (resultset.getString("task_id").equalsIgnoreCase(task_id)) {
					flag = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Update status method failed");
			e.printStackTrace();
		}

		// Update statement
		try {
			if (flag == 1) {
				db = DriverManager.getConnection(URL, user, password);
				Statement statement = db.createStatement();
				String updateQuery = "UPDATE task_main SET status='" + status + "' WHERE task_id='"
						+ task_id + "';";
				statement.executeUpdate(updateQuery);
				System.out.println("Status updated");
			} else {
				System.out.println("Task ID doesnt exist");
			}
		} catch (Exception e) {
			System.out.println("Update status Query failed");
			e.printStackTrace();
		}

	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	/*
	 * Deletes task based on ID
	 * @param task_id
	 */
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public void delete_Task(String task_id) {
		int flag = 0;
		// UPDATE task_main SET status='completed' WHERE task_id='2';
		try {
			db = DriverManager.getConnection(URL, user, password);
			Statement statement = db.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT TASK_ID FROM task_main;");
			while (resultset.next()) {
				if (resultset.getString("task_id").equalsIgnoreCase(task_id)) {
					flag = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Update status method failed");
			e.printStackTrace();
		}

		// Delete statement
		try {
			if (flag == 1) {
				db = DriverManager.getConnection(URL, user, password);
				Statement statement = db.createStatement();
				String updateQuery = "DELETE FROM task_main WHERE task_id='"+ task_id + "';";
				statement.executeUpdate(updateQuery);
				System.out.println("Task deleted");
			} else {
				System.out.println("Task ID doesnt exist");
			}
		} catch (Exception e) {
			System.out.println("Delete task Query failed");
			e.printStackTrace();
		}

	}
    //@@@@@@@@@@@@@@@@@@@@@@@@@
	/*
	 * Deletes all task 
	 * resets the whole table
	 * 
	 */
	//@@@@@@@@@@@@@@@@@@@@@@@@@
	public void Reset_all() {
		
		// Delete statement
		try {
		
				db = DriverManager.getConnection(URL, user, password);
				Statement statement = db.createStatement();
				String updateQuery = "DELETE FROM task_main";
				statement.executeUpdate(updateQuery);
				System.out.println("#################  Task List Reset  #################");
				statement.executeUpdate("ALTER SEQUENCE task_main_task_id_seq RESTART WITH 1");
			
		} catch (Exception e) {
			System.out.println("Task reset method failed");
			e.printStackTrace();
		}

	}


}