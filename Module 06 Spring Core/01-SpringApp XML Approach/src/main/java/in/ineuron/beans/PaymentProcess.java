package in.ineuron.beans;

public class PaymentProcess 
{
	private IPay pay;
	
	public PaymentProcess(IPay pay)
	{
		this.pay=pay;
		System.out.println("PP object is creating");
	}
	
	public void setPay(IPay pay)
	{
		System.out.println("setter is called");
		this.pay=pay;
	}
	
	public void doPayment(Double amt)
	{
		boolean paymentDone=pay.payBill(amt);
		
		if(paymentDone)
		{
			System.out.println("Payment success");
		}
		else
		{
			System.out.println("Payment failed");
		}
	}

}
