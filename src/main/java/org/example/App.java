package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(org.example.Cart.class);
        config.addAnnotatedClass(org.example.Item.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println( "Hello!");
        Item item1 = new Item(100);
        Item item2 = new Item(200);
        Item item3 = new Item(300);
        Item item4 = new Item(400);
        Cart cart1 = new Cart(1,"First_Cart");
        cart1.getItems().addAll(Arrays.asList(item1, item2, item3, item4));
        session.persist(cart1);
        transaction.commit();
        session.close();
    }
}
