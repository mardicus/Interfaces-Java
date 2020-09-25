package services;

public class Paypal implements ITaxService {

	@Override
	public Double calculateSimpleInterest(Double amount, Integer months) {
		return amount += 0.01*amount*months;
	}

	@Override
	public Double calculatePaymentFee(Double amount) {
		return amount*0.02;
	}

}
