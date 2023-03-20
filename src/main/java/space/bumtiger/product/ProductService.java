package space.bumtiger.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> listAll() {
		List<Product> productList = new ArrayList<Product>();
		var productIter = repository.findAll();
		productIter.forEach(prod -> {
			productList.add(prod);
		});
		return productList;
	}
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public Product get(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
}
