package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {

    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    public Item() {
    //do nothing
    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = this.price.multiply(BigDecimal.valueOf(this.quantity));
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ITEM_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @ManyToOne(
        targetEntity = Product.class,
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    public Product getProduct() {
        return product;
    }

    @NotNull
    @Column(name = "ITEM_PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "ITEM_QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @NotNull
    @Column(name = "ITEM_VALUE")
    public BigDecimal getValue() {
        return value;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "Item{" +
                "id=" + id +
                ", product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }
}
