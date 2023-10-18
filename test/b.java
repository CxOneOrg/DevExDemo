import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cnt.Security.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Details extends HttpJspBase {

	private static void printSanitizedName (String str) {

		String sanitizedUserData = Security.validName(str);
		out.println (sanitizedUserData);
	}

	public static void testData () {

		String userData = request.getParameter("Data"); 
		out.println (userData);
		printSanitizedName(userData);
	}
