package spring.testng.service;

import spring.testng.exception.ProductNotFoundException;
import spring.testng.model.Product;

import java.util.List;

/**
 * Created by ThangN on 8/8/2016.
 */
public interface ProductService {

    public void createProduct(Product product);

    public void deleteProduct(Product product) throws ProductNotFoundException;

    public Product findProductById(Integer id) throws ProductNotFoundException;

    public List<Product> findAll();

}
