package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.ProductDTO;

public interface IProductServiceMgmt {
	public List<ProductDTO> getProductByNames(String name1,String name2);
}
