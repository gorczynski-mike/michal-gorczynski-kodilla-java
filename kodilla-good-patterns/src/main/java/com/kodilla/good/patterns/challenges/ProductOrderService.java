package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;

public class ProductOrderService {

    public static void main(String[] args) {

        InformationService informationService = new ConsoleInformationService();
        OrderService orderService = new WarehouseOrderService(new InMemoryWarehouseService());
        OrderRepository orderRepository = new FileOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(informationService, orderService, orderRepository);

        User mike = new User("Mike", 100);
        Product electronics10 = new Product(ProductCategory.ELECTRONICS, "ELECTRONICS10", new BigDecimal(2));
        orderProcessor.process(new OrderRequest(mike, electronics10, 1));
        orderProcessor.process(new OrderRequest(mike, electronics10, 2));
        orderProcessor.process(new OrderRequest(mike, electronics10, 3));
        orderProcessor.process(new OrderRequest(mike, electronics10, 4));
        orderProcessor.process(new OrderRequest(mike, electronics10, 5));
    }

}
