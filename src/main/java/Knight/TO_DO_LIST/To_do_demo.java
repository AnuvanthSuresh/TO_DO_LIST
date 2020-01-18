package Knight.TO_DO_LIST;

import db_Operations.DB_Operation;
import utilities.Function;
public class To_do_demo {

	
	public static void main(String[] args){
		
		// Method defs
		DB_Operation db_operation = new DB_Operation();
		Function function = new Function();

		db_operation.insert_Task("test", function.getDate());
		// db_operation.delete_Task("2");
		//db_operation.Reset_all();
		db_operation.Get_task();
		
	}
}