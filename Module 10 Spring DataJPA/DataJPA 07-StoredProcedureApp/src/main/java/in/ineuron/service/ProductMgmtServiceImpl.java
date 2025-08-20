package in.ineuron.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.bo.Product;

/*
 * Stored Procedure: MySQL
 * -----------------
 * 
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_BY_NAME`(IN name1 VARCHAR(20), IN name2 VARCHAR(20))
   BEGIN
		SELECT pid,pname,price,qty FROM products WHERE pname IN (name1,name2); 
   END;
 * 
 */

@Component("service")
public class ProductMgmtServiceImpl implements IProductMgmtService {

	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> fetchProductsByName(String product1, String product2) {
		
		System.out.println("EntityManager => " + manager.getClass().getName());
		
		/*
		 * 	Calling the stored procedure
		 */
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_PRODUCT_BY_NAME", Product.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

		query.setParameter(1, product1);
		query.setParameter(2, product2);

		List<Product> listProducts = query.getResultList();

		return listProducts;
	}

}
