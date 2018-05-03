package com.kodilla.good.patterns.challenges;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileOrderRepository implements OrderRepository {

    private final String fileRepository;

    {
        ClassLoader classLoader = getClass().getClassLoader();
        fileRepository = classLoader.getResource("file/Orders.txt").getFile();
    }

    @Override
    public boolean createOrder(User user, Product product, int quantity) {

        try(
                PrintWriter printWriter = new PrintWriter(new FileWriter(fileRepository))
                ) {
            printWriter.printf("%s - %s - %d - %s", user, product, quantity, LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
