package app;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Product> products = Arrays.asList(
                new Product("Apple", "Fruits", 3.0),
                new Product("Orange", "Fruits", 2.5),
                new Product("Tomato", "Vegetables", 1.8),
                new Product("Carrot", "Vegetables", 1.2),
                new Product("Milk", "Dairy", 1.5),
                new Product("Cheese", "Dairy", 5.0),
                new Product("Chicken", "Meat", 7.0),
                new Product("Beef", "Meat", 10.0),
                new Product("Yogurt", "Dairy", 2.0)
        );


        Map<String, Double> averagePrices = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));


        System.out.println("Середні ціни за категоріями:");
        averagePrices.forEach((category, avgPrice) ->
                System.out.println(category + ": " + avgPrice)
        );


        Optional<Map.Entry<String, Double>> maxAveragePriceCategory = averagePrices.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        maxAveragePriceCategory.ifPresent(entry ->
                System.out.println("Категорія з найвищою середньою ціною: " + entry.getKey() + " (середня ціна: " + entry.getValue() + ")")
        );
    }
}
