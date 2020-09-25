package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import services.PaymentService;
import services.Paypal;

public class Contract {
	private Integer number;
	private Date date;
	private Double totalValue;
	private PaymentService paymentInstance;
	
	private List<Installment> list = new ArrayList<>();
	
	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getList() {
		return list;
	}	
	
	public void instantiatePayment(Double doubles, int number, Date date) {
		paymentInstance = new PaymentService(doubles, number, date, new Paypal());
	}
	
	public void addToList(Date date){
	Double taxAmount = paymentInstance.calculateTaxAmount();
	list.add(new Installment(taxAmount, date));
	}
}
