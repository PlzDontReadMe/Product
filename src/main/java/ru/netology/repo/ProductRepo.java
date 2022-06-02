package ru.netology.repo;

import lombok.Data;
import ru.netology.domain.Product;

@Data
public class ProductRepo {

    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        this.items = tmp;
    }

    public Product[] findAll() {
        return this.items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] removedById(int id) {
        if (findById(id) == null) {
            return new Product[0];
        }
        Product[] tmp = new Product[items.length - 1];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
            }
            index++;
        }
        this.items = tmp;
        return tmp;
    }
}



