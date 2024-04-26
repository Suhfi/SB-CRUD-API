package hailxcode.SBCRUDAPI.controller;

import hailxcode.SBCRUDAPI.entity.Product;
import hailxcode.SBCRUDAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        String status = productService.addProduct(product);
        return new ResponseEntity<>(status , HttpStatus.CREATED);
    }
    @PostMapping("/list")
    public ResponseEntity<String> addProductList(@RequestBody List<Product> products){
        String status = productService.addProductList(products);
        return new ResponseEntity<>(status , HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        String updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct , HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product productById = productService.getProductById(id);
        return new ResponseEntity<>(productById , HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        Product productByName = productService.getProductByName(name);
        return new ResponseEntity<>(productByName , HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
        String status = productService.deleteByProductById(id);
        return new ResponseEntity<>(status , HttpStatus.OK);
    }
}
