package services;
import java.util.Date;

import entities.Contract;

public class PaymentService {
	
	private Double value;
	private Integer installmentsNumber;
	private Date date;
	private Double taxAmount;

	private ITaxService taxService;

	
	public PaymentService(Double value, Integer installmentsNumber, Date date, ITaxService taxService) {
		this.value = value;
		this.installmentsNumber = installmentsNumber;
		this.date = date;
		this.taxService = taxService;
	}
	
	public Integer monthCount = 0;
	
	public Double calculateTaxAmount() {
		Double amount = value/installmentsNumber; 
		monthCount += 1;
		return taxService.calculateSimpleInterest(amount, monthCount) + taxService.calculatePaymentFee(amount);
	}
}
