package org.example;


public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketService = new TicketCrudService();

        // Create and read a Client
        Client client = new Client();
        client.setName("New Client");
        clientService.create(client);
        Client savedClient = clientService.read(client.getId());
        System.out.println("Saved Client: " + savedClient.getName());

        // Create and read a Planet
        Planet planet = new Planet();
        planet.setId("NEP");
        planet.setName("Neptune");
        planetService.create(planet);
        Planet savedPlanet = planetService.read(planet.getId());
        System.out.println("Saved Planet: " + savedPlanet.getName());

        // Create a Ticket
        Ticket ticket = new Ticket();
        ticket.setClient(savedClient);
        ticket.setFromPlanet(planetService.read("EARTH"));
        ticket.setToPlanet(savedPlanet);

        try {
            ticketService.create(ticket);
            Ticket savedTicket = ticketService.read(ticket.getId());
            System.out.println("Saved Ticket: " + savedTicket.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create ticket: " + e.getMessage());
        }

        // Test invalid ticket creation
        try {
            Ticket invalidTicket = new Ticket();
            invalidTicket.setClient(null);
            invalidTicket.setFromPlanet(null);
            invalidTicket.setToPlanet(null);
            ticketService.create(invalidTicket);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create invalid ticket: " + e.getMessage());
        }

        // Update and delete a Ticket
        ticket.setToPlanet(planetService.read("VEN"));
        ticketService.update(ticket);
        ticketService.delete(ticket.getId());

        // Clean up created client and planet
        clientService.delete(savedClient.getId());
        planetService.delete(savedPlanet.getId());
    }
}