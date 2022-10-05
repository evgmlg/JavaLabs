package giezz;

import giezz.model.Item;
import org.hibernate.Session;

public class CreateData {
    public static void main(String[] args) {
        Session session = HibernateUtil.sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 40; i++) {
            session.persist(new Item(0));
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.sessionFactory.close();
    }
}
