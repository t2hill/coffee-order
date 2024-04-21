package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "data/db.txt";

    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.getBeverage().toLowerCase().trim()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.getBeverage()));
        }
        for(String condiment : order.getCondiments()) {
            switch (condiment.toLowerCase().trim()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }

        // Add to database
        int id = 0;
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        // Get id number
        for (String line : data) {
            String[] words = line.split(",");
            // Make sure id is unique
            System.out.println(Arrays.toString(words));
            if (Integer.parseInt(words[0]) == id) { id++; }
            else { break; }
        }
        System.out.println(id);
        // Format to 2 decimal places
        float cost = (float) (Math.round(beverage.cost() * 100.0) / 100.0);
        String newReceipt = id + ", " + cost + ", " + beverage.getDescription();
        appendToFile(path, NEW_LINE + newReceipt);
        return new Receipt(id, cost, beverage.getDescription());
    }

    public List<Receipt> findAll() throws IOException {
        List<Receipt> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            if(!line.trim().isEmpty()) {
                String[] words = line.split(",");
                String description = String.valueOf(words[2]);
                if (words.length > 3) {
                    description = getString(words);
                }
                Receipt r = new Receipt(Integer.parseInt(words[0]), Float.parseFloat(words[1]), description);
                result.add(r);
            }
        }
        return result;
    }

    private static String getString(String[] words) {
        String[] condiments = Arrays.copyOfRange(words, 2, words.length);
        String description = "";
        boolean first = true;
        for (String cond : condiments) {
            if (first) {
                if (condiments.length > 1)
                    description = cond + " with ";
                else
                    description = cond;
                first = false;
            }
            else
                description += cond + ", ";
        }
        description = description.substring(0, description.length() - 2);
        return description;
    }

    public Receipt getOrder() throws IOException {
        List<Receipt> receipts = findAll();
        return receipts.get(receipts.size() - 1);
    }
}
