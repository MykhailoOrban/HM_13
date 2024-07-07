package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class PlanetCrudService {

    private SessionFactory sessionFactory;

    public PlanetCrudService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void create(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(planet);
        transaction.commit();
        session.close();
    }

    public Planet read(String id) {
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public void update(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(planet);
        transaction.commit();
        session.close();
    }

    public void delete(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        if (planet != null) {
            session.delete(planet);
        }
        transaction.commit();
        session.close();
    }

    public List<Planet> getAll() {
        Session session = sessionFactory.openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }
}