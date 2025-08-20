package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.ProductBO;

@Repository
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBO> fetchProductByNames(String name1, String name2) {

		SimpleJdbcCall jdbc = new SimpleJdbcCall(dataSource).withProcedureName("P_GET_PRODUCT_BY_NAME")
				.returningResultSet("products", new BeanPropertyRowMapper<ProductBO>(ProductBO.class));

		Map<String, Object> out = jdbc.execute(Map.of("name1", name1, "name2", name2));
		System.out.println(out);
		List<ProductBO> listProducts = (List<ProductBO>) out.get("products");
		return listProducts;
	}

}
