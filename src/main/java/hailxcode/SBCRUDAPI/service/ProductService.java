package hailxcode.SBCRUDAPI.service;

import hailxcode.SBCRUDAPI.entity.Product;

import java.util.List;

public interface ProductService {
    public String addProduct(Product product);
    public String addProductList(List<Product> products);
    public String updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Integer id);
    public Product getProductByName(String name);
    public String deleteByProductById(Integer id);
}
