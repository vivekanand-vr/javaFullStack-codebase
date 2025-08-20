package in.ineuron.nitin.service;

public class BankLoanService {

	public BankLoanService() {
		System.out.println("BankLoanService:: ZERO PARAM CONSTRUCTOR\n");
	}

	public float calculateSimpleInterest(float pAmount, float rate, float time) {
		System.out.println("BankLoanService.calculateSimpleInterest()");
		if (pAmount <= 0 || rate <= 0 || time <= 0)
			throw new IllegalArgumentException("Invliad inputs");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return (pAmount * rate * time) / 100.0f;
	}
}
