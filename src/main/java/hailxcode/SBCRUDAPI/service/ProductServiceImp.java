package hailxcode.SBCRUDAPI.service;

import hailxcode.SBCRUDAPI.entity.Product;
import hailxcode.SBCRUDAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product Saved Successfully";
    }

    @Override
    public String addProductList(List<Product> products) {
        productRepository.saveAll(products);
        return "List of Products Saved Successfully";
    }

    @Override
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "Product Updated Successfully";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> productById = productRepository.findById(id);
        if(productById.isPresent()){
            return productById.get();
        }
        return null;
    }

    @Override
    public Product getProductByName(String name) {
       return productRepository.findByName(name);
    }

    @Override
    public String deleteByProductById(Integer id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product with id " +id +" deleted Successfully";
        }else {
            return "No record found";
        }
    }
}
