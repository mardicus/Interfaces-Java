package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int Number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract Value: ");
		double value = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("Enter number of installments: ");
		int installmentsNumber = sc.nextInt();
		sc.nextLine();
		
		Contract contract = new Contract(Number, date, value);
		
		contract.instantiatePayment(value, installmentsNumber, date);
		
		for(int i = 0; i < installmentsNumber; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			date = cal.getTime();
			contract.addToList(date);
		}
		
		System.out.println("Installments:");
		for(Installment i:contract.getList()) {
			System.out.println(sdf.format(i.getDueDate())+" - "+i.getAmount());
		}
		}
		catch(ParseException p) {
			System.out.println("Invalid format");
		}
		sc.close();
	}

}
