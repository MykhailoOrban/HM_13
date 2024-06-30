package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlanetCrudService {

    private final SessionFactory sessionFactory;

    public PlanetCrudService() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public Planet save(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(planet);
        transaction.commit();
        session.close();
        return planet;
    }

    public Planet findById(String id) {
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public List<Planet> findAll() {
        Session session = sessionFactory.openSession();
        List<Planet> planets = session.createQuery("FROM Planet", Planet.class).list();
        session.close();
        return planets;
    }

    public void delete(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(planet);
        transaction.commit();
        session.close();
    }
}