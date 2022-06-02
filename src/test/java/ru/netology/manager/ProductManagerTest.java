package ru.netology.manager;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProductRepo;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final Product product1 = new Product(1, "product1_A1", 100);
    private final Book book1 = new Book(2, "book1", 500, "A1");
    private final Smartphone smartphone1 = new Smartphone(3, "smartphone1", 10000, "A1");
    private final Product product2 = new Product(4, "product2_A2", 100);
    private final Book book2 = new Book(5, "book2", 500, "A2");
    private final Smartphone smartphone2 = new Smartphone(6, "smartphone2", 10000, "A2");

    private final ProductManager manager = new ProductManager(new ProductRepo());

    @BeforeEach
    void setUp() {
        manager.add(product1);
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(product2);
        manager.add(book2);
        manager.add(smartphone2);
    }

    @Test
    void shouldReturnByText() {

        Product[] expected = {product1, book1, smartphone1};
        Product[] actual = manager.searchBy("A1");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldReturnByName(){
        Product[] expected = {book1,book2};
        Product[] actual = manager.searchBy("book");
        assertArrayEquals(expected,actual);
    }
}