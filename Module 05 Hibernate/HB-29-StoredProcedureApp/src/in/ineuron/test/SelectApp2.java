package in.ineuron.test;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import in.ineuron.util.HibernateUtil;

/*
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_DETAILS_BY_ID`
 * 			(IN id INT,OUT NAME VARCHAR(20),OUT rate INT, OUT qnt INT)
	BEGIN
		SELECT pname,price,qty INTO NAME,rate,qnt FROM products WHERE pid = id;
	END$$
DELIMITER ;
 * 
 * 
 */
public class SelectApp2 {
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Integer pid = 1;

			// Creating a Procedure call object
			ProcedureCall procedureCall = session.createStoredProcedureCall("P_GET_PRODUCT_DETAILS_BY_ID");

			// Binding input parameter value for Procedure call object
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(pid);
			procedureCall.registerParameter(2, String.class, ParameterMode.OUT);
			procedureCall.registerParameter(3, Integer.class, ParameterMode.OUT);
			procedureCall.registerParameter(4, Integer.class, ParameterMode.OUT);

			// Executing the procedurecall to get the result
			String pname = (String) procedureCall.getOutputParameterValue(2);
			Integer price = (Integer) procedureCall.getOutputParameterValue(3);
			Integer qty = (Integer) procedureCall.getOutputParameterValue(4);
			
			System.out.println("PNAME\tPRICE\tQTY");
			System.out.println(pname + "\t" + price + "\t" + qty);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
