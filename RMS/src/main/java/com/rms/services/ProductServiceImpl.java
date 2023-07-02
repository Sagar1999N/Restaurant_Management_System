package com.rms.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.daos.ProductDao;
import com.rms.dtos.ProductDTO;
import com.rms.dtos.ProductDTOSend;
import com.rms.entities.Product;
import com.rms.utils.DtoEntityConverter;


@Service
public class ProductServiceImpl {

	@Autowired
	private DtoEntityConverter converter;
	@Autowired	
	private ProductDao productDao;
	
	public Map<String, Object> addProduct(ProductDTO productDTO){
		Product product = converter.toProductEntity(productDTO);
		product = productDao.save(product);	
		return Collections.singletonMap("insertedId", product.getProductId());	
	}
	
	public Map<String, Object> updateProduct(Integer id, ProductDTO productDTO){
		Product product = productDao.findByProductId(id);
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product = productDao.save(product);
		return Collections.singletonMap("updated", product.getProductId());
	}
	
	public Map<String, Object> updateProductStatus(ProductDTO productDTO,Integer id) {
		Product product=productDao.findByProductId(id);
		product.setProductStatus(productDTO.getProductStatus());
		product = productDao.save(product);
		return Collections.singletonMap("Updated", product.getProductId());
	}
	
	public List<ProductDTOSend> getAllProduct(){
		List<ProductDTOSend> sendList = new ArrayList<ProductDTOSend>();
		List<Product> list = productDao.findAll();
		for(Product product : list) {
			sendList.add(converter.toProductDTO(product));
		}
		System.out.println(sendList);
		return sendList;
	}
	
	public List<ProductDTOSend> getAllProductByStatus(){
		List<ProductDTOSend> sendList = new ArrayList<ProductDTOSend>();
		List<Product>list = productDao.findByProductStatus("Enabled");
		for(Product product: list) {
			sendList.add(converter.toProductDTO(product));
		}
		return sendList;
	}
	
	public List<ProductDTOSend> getProductByCat(Integer id){
		List<ProductDTOSend> sendList = new ArrayList<ProductDTOSend>();
		List<Product>list=productDao.findByCategory_CategoryIdAndProductStatus(id, "Enabled");
		for(Product product : list) {
			sendList.add(converter.toProductDTO(product));
		}
		return sendList;
	}
	
	public ProductDTOSend getByProductId(Integer id) {
		ProductDTOSend dtoSend = converter.toProductDTO(productDao.findByProductId(id));
		return dtoSend;	
	}
	public Integer deleteByProductId(Integer id) {
		if(productDao.existsById(id)) {
			productDao.deleteById(id);
			return 1;
		}
		return 0;
	}
}
