package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    @Transactional
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Product product3 = new Product("product3");
        Item item1 = new Item(product1, BigDecimal.valueOf(21.50), 2);
        Item item2 = new Item(product1, BigDecimal.valueOf(20.00), 1);
        Item item3 = new Item(product2, BigDecimal.valueOf(10.00), 3);
        Item item4 = new Item(product3, BigDecimal.valueOf(52.00), 2);
        Item item5 = new Item(product3, BigDecimal.valueOf(40.00), 1);
        Invoice invoice1 = new Invoice("1111", Arrays.asList(new Item[]{item1, item2, item3}));
        Invoice invoice2 = new Invoice("2222", Arrays.asList(new Item[]{item4, item5}));

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();
        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();
        Invoice resultInvoice1 = invoiceDao.findByNumber("1111");
        Invoice resultInvoice2 = invoiceDao.findByNumber("2222");


        //Then
        Assert.assertNotNull(resultInvoice1);
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertEquals(3, resultInvoice1.getItems().size());
        Assert.assertNotNull(resultInvoice2);
        Assert.assertNotEquals(0, invoice2Id);
        Assert.assertEquals(2, resultInvoice2.getItems().size());

    }

}
