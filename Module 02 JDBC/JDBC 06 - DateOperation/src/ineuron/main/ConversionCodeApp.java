package ineuron.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class ConversionCodeApp {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		//Read the input from the user
		System.out.println("Enter the date (dd-MM-yyyy) : ");
		String sDate=sc.next();
		
		//convert date from string to java.util.Date format
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyyy"); //it`s case sensitive(format)
		java.util.Date udate = sdf.parse(sDate);
		
		//convert date to SQL date format
		long value = udate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(value);
		
		//printing all three formats
		System.out.println("String format : "+sDate);
		System.out.println("Util date is : "+udate);
		System.out.println("sqlDate is : "+sqlDate);
		
		//Read the input from the user
		System.out.println("Enter the date (yyyy-MM-dd) : ");
		String stdInput=sc.next();
		java.sql.Date sqlStdDate =  java.sql.Date.valueOf(stdInput);
		System.out.println("Standard Input : "+stdInput);
		System.out.println("sql Standard Date : "+sqlStdDate);
		
		
		sc.close();
	}

}
