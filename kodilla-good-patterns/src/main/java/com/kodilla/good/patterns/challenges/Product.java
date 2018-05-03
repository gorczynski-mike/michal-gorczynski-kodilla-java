package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private final ProductCategory productCategory;
    private final String name;
    private final BigDecimal price;

    public Product(final ProductCategory productCategory, final String name, final BigDecimal price) {
        this.productCategory = productCategory;
        this.name = name;
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productCategory == product.productCategory &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productCategory, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCategory=" + productCategory +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
