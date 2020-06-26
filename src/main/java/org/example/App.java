package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Post.class);
        config.addAnnotatedClass(Comment.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Post post1 = new Post("New job");
        Post post2 = new Post("Marriage");

        Comment comment1 = new Comment("John Weslbey",post1);
        Comment comment2 = new Comment("Sara Stock",post1);
        Comment comment3 = new Comment("Jefrey Heu",post1);
        Comment comment4 = new Comment("Hanna Rasen",post2);
        post1.getComments().addAll(Arrays.asList(comment1,comment2,comment3));
        post2.getComments().addAll(Arrays.asList(comment4));

        session.save(post1);
        session.save(post2);

        transaction.commit();

        Post post_1 = session.find(Post.class,1);
        Post post_2 = session.find(Post.class,2);
        System.out.println(post_1+"--->"+post_1.getComments());
        System.out.println(post_2+"--->"+post_2.getComments());
        session.close();
    }
}
