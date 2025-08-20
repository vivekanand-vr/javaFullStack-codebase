package in.ineuron.beans;

public class DebitCardPay implements IPay {

	public DebitCardPay()
	{
		System.out.println("Debit card object is created by IOC");
	}
	
	public boolean payBill(Double amt) 
	{
		System.out.println("Paying bill through Debit card");
		return true;
	}

}
