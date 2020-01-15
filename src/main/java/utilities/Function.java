package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Function {

	/*
	 * Returns date in String format
	 * dd/MM/yyyy
	 */
	
	public String getDate() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date = LocalDateTime.now();
        return dtf.format(date);

	}

}
