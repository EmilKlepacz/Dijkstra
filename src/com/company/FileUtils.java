package com.company;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileUtils {

    public static Map<String, Vertex<String>> readCitiesFromFile(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(fileName + " does not exist. Exiting.");
            e.printStackTrace();
            System.exit(0);
        }
        Map<String, Vertex<String>> cities = new HashMap<>();

        lines.forEach(l -> {
            Scanner scanner = new Scanner(l);
            scanner.useDelimiter(";");
            String firstCityName = scanner.next();
            String secondCityName = scanner.next();
            float distance = Float.parseFloat(scanner.next());
            Vertex<String> firstCity = new Vertex<>(firstCityName);
            Vertex<String> secondCity = new Vertex<>(secondCityName);
            if (!cities.containsKey(firstCityName)) {
                cities.put(firstCityName, firstCity);
            }
            if (!cities.containsKey(secondCityName)) {
                cities.put(secondCityName, secondCity);
            }
            cities.get(firstCityName).link(cities.get(secondCityName), distance);
        });

        return cities;
    }
}
