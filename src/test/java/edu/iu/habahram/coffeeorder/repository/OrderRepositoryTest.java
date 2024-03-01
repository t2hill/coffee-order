package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    private String lineToRemove;
    private static int id;

    @BeforeAll()
    static void getId() throws IOException {
        File inputFile = new File("db.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        id = 0;
        while(reader.readLine() != null) {
            id++;
        }
        reader.close();
    }

    @Test
    void add_DarkRoast() throws Exception {
        Receipt expected = new Receipt(id, 1.99F, "Dark roast");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        Receipt output = orderRepository.add(new OrderData("dark roast", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Decaf() throws Exception {
        Receipt expected = new Receipt(id, 1.28F, "Decaf");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        Receipt output = orderRepository.add(new OrderData("decaf", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Espresso() throws Exception {
        Receipt expected = new Receipt(id, 1.34F, "Espresso");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        Receipt output = orderRepository.add(new OrderData("espresso", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_HouseBlend() throws Exception {
        Receipt expected = new Receipt(id, 1.65F, "House blend");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        Receipt output = orderRepository.add(new OrderData("house blend", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_DarkRoast_Milk() throws Exception {
        Receipt expected = new Receipt(id, 2.39F, "Dark roast, Milk");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("milk");
        Receipt output = orderRepository.add(new OrderData("Dark roast", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Espresso_Soy() throws Exception {
        Receipt expected = new Receipt(id, 1.61F, "Espresso, Soy");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("soy");
        Receipt output = orderRepository.add(new OrderData("Espresso", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_HouseBlend_Mocha() throws Exception {
        Receipt expected = new Receipt(id, 1.95F, "House blend, Mocha");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("mocha");
        Receipt output = orderRepository.add(new OrderData("house blend", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Decaf_Whip() throws Exception {
        Receipt expected = new Receipt(id, 1.53F, "Decaf, Whip");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("whip");
        Receipt output = orderRepository.add(new OrderData("decaf", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_DarkRoast_Milk_Soy() throws Exception {
        Receipt expected = new Receipt(id, 2.66F, "Dark roast, Milk, Soy");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("milk");
        condiments.add("soy");
        Receipt output = orderRepository.add(new OrderData("Dark roast", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Espresso_Soy_Mocha() throws Exception {
        Receipt expected = new Receipt(id, 1.91F, "Espresso, Soy, Mocha");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("soy");
        condiments.add("mocha");
        Receipt output = orderRepository.add(new OrderData("Espresso", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_HouseBlend_Mocha_Whip() throws Exception {
        Receipt expected = new Receipt(id, 2.2F, "House blend, Mocha, Whip");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("mocha");
        condiments.add("whip");
        Receipt output = orderRepository.add(new OrderData("house blend", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Decaf_Whip_Milk() throws Exception {
        Receipt expected = new Receipt(id, 1.93F, "Decaf, Whip, Milk");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("whip");
        condiments.add("milk");
        Receipt output = orderRepository.add(new OrderData("decaf", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_DarkRoast_Milk_Soy_Mocha() throws Exception {
        Receipt expected = new Receipt(id, 2.96F, "Dark roast, Milk, Soy, Mocha");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("milk");
        condiments.add("soy");
        condiments.add("mocha");
        Receipt output = orderRepository.add(new OrderData("Dark roast", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_DarkRoast_ALL() throws Exception {
        Receipt expected = new Receipt(id, 3.21F, "Dark roast, Milk, Soy, Mocha, Whip");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("milk");
        condiments.add("soy");
        condiments.add("mocha");
        condiments.add("whip");
        Receipt output = orderRepository.add(new OrderData("Dark roast", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Espresso_double_whip() throws Exception {
        Receipt expected = new Receipt(id, 1.84F, "Espresso, Whip, Whip");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("whip");
        condiments.add("whip");
        Receipt output = orderRepository.add(new OrderData("Espresso", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }
    @Test
    void add_Decaf_double_milk_All() throws Exception {
        Receipt expected = new Receipt(id, 2.9F, "Decaf, Milk, Milk, Mocha, Whip, Soy");
        OrderRepository orderRepository = new OrderRepository();
        List<String> condiments = new ArrayList<>();
        condiments.add("milk");
        condiments.add("milk");
        condiments.add("mocha");
        condiments.add("whip");
        condiments.add("soy");
        Receipt output = orderRepository.add(new OrderData("Decaf", condiments));
        lineToRemove = expected.id() + ", " + expected.cost() + ", " + expected.description();
        assertEquals(expected, output);
    }

    @AfterEach()
    void tearDown() throws IOException {
        File inputFile = new File("db.txt");
        File tempFile = new File("db_temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        boolean first = true;
        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            if (first) {
                writer.write(currentLine);
                first = false;
            }
            else
                writer.write(System.lineSeparator() + currentLine);
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}