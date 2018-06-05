package com.kodilla.hibernate.invoice;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {

    private int id;
    private String number;
    private List<Item> items = new ArrayList<>();

    public Invoice() {
    //do nothing
    }

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "INVOICE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "INVOICE_NUMBER")
    public String getNumber() {
        return number;
    }

    @OneToMany
    (
        targetEntity = Item.class,
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    public List<Item> getItems() {
        return items;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", items=" + items +
                '}';
    }
}
