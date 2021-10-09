package org.example.model;

import org.example.entity.DiscountProduct;
import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class DB {

    public static List<Product> warehouse;

    static {
        warehouse = new ArrayList<>();
        warehouse.add(new DiscountProduct('A', 1.25, 3.00, 3));
        warehouse.add(new Product('B', 4.25));
        warehouse.add(new DiscountProduct('C', 1.00, 5.00, 6));
        warehouse.add(new Product('D', 0.75));
    }

}
