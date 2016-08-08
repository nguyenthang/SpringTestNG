package spring.testng.test;

import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import spring.testng.dao.ProductDAO;
import spring.testng.model.Product;
import spring.testng.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by ThangN on 8/8/2016.
 */
public class ProductServiceImplTest {

    @Mock
    private ProductDAO productDAO;

    @InjectMocks
    ProductServiceImpl productService;

    @Spy
    List<Product> productList = new ArrayList<Product>();

    @Captor
    ArgumentCaptor<Product> captor;

    @org.testng.annotations.BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        productList = getProductLists();
    }

    @Test
    public void listProductShouldNotEmpty(){
        Assert.assertNotNull(productList);
        verify(productDAO).findAll();
    }

    public List<Product> getProductLists() {

        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setCategory("SW");
        p1.setPrice(1000d);
        p1.setProductName("Laptop Sony");
        p1.setUsedTime(new Date());

        products.add(p1);

        return products;
    }
}
