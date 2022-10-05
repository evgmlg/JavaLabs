package giezz;

import giezz.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Item.class)
            .buildSessionFactory();
}