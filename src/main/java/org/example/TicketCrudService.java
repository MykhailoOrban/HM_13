package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;

public class TicketCrudService {

    private SessionFactory sessionFactory;

    public TicketCrudService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void create(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (ticket.getClient() == null || session.get(Client.class, ticket.getClient().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null client");
        }

        if (ticket.getFromPlanet() == null || session.get(Planet.class, ticket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null from planet");
        }

        if (ticket.getToPlanet() == null || session.get(Planet.class, ticket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null to planet");
        }

        ticket.setCreatedAt(LocalDateTime.now());
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket read(Long id) {
        Session session = sessionFactory.openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public void update(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (ticket.getClient() == null || session.get(Client.class, ticket.getClient().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null client");
        }

        if (ticket.getFromPlanet() == null || session.get(Planet.class, ticket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null from planet");
        }

        if (ticket.getToPlanet() == null || session.get(Planet.class, ticket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null to planet");
        }

        session.update(ticket);
        transaction.commit();
        session.close();
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        if (ticket != null) {
            session.delete(ticket);
        }
        transaction.commit();
        session.close();
    }

    public List<Ticket> getAll() {
        Session session = sessionFactory.openSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }
}
////test