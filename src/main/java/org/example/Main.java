package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        // Test Client CRUD operations
        Client client = new Client();
        client.setName("Client 1");
        clientService.save(client);
        System.out.println("Saved client: " + client);

        Client retrievedClient = clientService.findById(client.getId());
        System.out.println("Retrieved client: " + retrievedClient);

        List<Client> clients = clientService.findAll();
        System.out.println("All clients:");
        clients.forEach(System.out::println);

        clientService.delete(retrievedClient);
        System.out.println("Client deleted.");

        // Test Planet CRUD operations
        Planet planet = new Planet();
        planet.setId("JUP");
        planet.setName("Jupiter");
        planetService.save(planet);
        System.out.println("Saved planet: " + planet);

        Planet retrievedPlanet = planetService.findById(planet.getId());
        System.out.println("Retrieved planet: " + retrievedPlanet);

        List<Planet> planets = planetService.findAll();
        System.out.println("All planets:");
        planets.forEach(System.out::println);

        planetService.delete(retrievedPlanet);
        System.out.println("Planet deleted.");
    }
}