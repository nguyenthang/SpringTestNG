package spring.testng.dao;

import spring.testng.exception.ProductNotFoundException;
import spring.testng.model.Product;

import java.util.List;

/**
 * Created by ThangN on 8/8/2016.
 */
public class ProductDAOImpl implements ProductDAO {
    public void createProduct(Product product) {

    }

    public void deleteProduct(Product product) throws ProductNotFoundException {

    }

    public Product findProductById(Integer id) throws ProductNotFoundException {
        return null;
    }

    public List<Product> findAll() {
        return null;
    }
}
