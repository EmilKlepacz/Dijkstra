package com.company;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Vertex<String>> cities = FileUtils.readCitiesFromFile("cities.txt");
        Graph<String> graph = new Graph<>(new ArrayList<>(cities.values()));
        Dijkstra dijkstra = new Dijkstra();

        System.out.println("Distance from Krakow to Gdansk is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("Krakow"), cities.get("Gdansk")));
        System.out.println("Distance from Gdansk to Krakow is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("Gdansk"), cities.get("Krakow")));
        System.out.println("Distance from New York to Boston is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("New York"), cities.get("Boston")));
        System.out.println("Distance from New York to Poznan is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("New York"), cities.get("Poznan")));
    }
}
