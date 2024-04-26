package hailxcode.SBCRUDAPI.repository;

import hailxcode.SBCRUDAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findByName(String name);
}
