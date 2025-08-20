package in.ineuron.test;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.MySQLHibernateUtil;
import in.ineuron.util.OracleHibernateUtil;

public class InteractWithMultipleDB {

	public static void main(String[] args) throws Exception {

		ITransferDao dao = new TransferDaoImpl();
		System.out.println(dao.transferProductById(1));

		OracleHibernateUtil.closeSessionFactory();
		MySQLHibernateUtil.closeSessionFactory();

	}
}

