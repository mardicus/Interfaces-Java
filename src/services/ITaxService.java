package services;

public interface ITaxService {
	Double calculateSimpleInterest(Double amount, Integer months);
	Double calculatePaymentFee(Double amount);
}
