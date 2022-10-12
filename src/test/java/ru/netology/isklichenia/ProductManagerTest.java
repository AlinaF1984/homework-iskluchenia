package ru.netology.isklichenia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {


    Product product1 = new Product(1, "AA", 10);
    Product product2 = new Product(2, "aa", 100);
    Product product3 = new Product(3, "ab", 200);
    Product repository = new Product(1, "AA", 10);
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }


    // @Test
    // public void removeIdProduct() {
    //    Product repo = new Product(1, "aa", 10);
    //    repo.saveProducts(product1);
    //  repo.saveProducts(product2);
    //   repo.saveProducts(product3);
    //   repo.removeById(product2.getId());

    //   Product[] expected = {product1, product3};
//
    // Assertions.assertArrayEquals(expected, actual);
    //  }


    @Test
    public void removeIdProductNull() {
        Product repo = new Product(1, "AA", 10);
        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);
        });
    }

    @Test
    public void removeIdProductById() {
        Product repo = new Product(2, "aa", 10);
        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.removeById(product2.findById);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }


}