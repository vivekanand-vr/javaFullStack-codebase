package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.ProductBO;
import in.ineuron.dao.IProductDAO;
import in.ineuron.dto.ProductDTO;

@Service
public class ProductServiceMgmtImpl implements IProductServiceMgmt {

	@Autowired
	private IProductDAO dao;

	@Override
	public List<ProductDTO> getProductByNames(String name1, String name2) {
		List<ProductBO> productBO = dao.fetchProductByNames(name1, name2);

		ArrayList<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		productBO.forEach(bo -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(bo, dto);
			listProductDTO.add(dto);
		});
		return listProductDTO;
	}

}
