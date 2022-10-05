import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Product.class)
//                .addAnnotatedClass(Buyer.class)
//                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        // CRUD
        Session session = factory.getCurrentSession();

        try {
//            CREATE

            session = factory.getCurrentSession();
//            Buyer buyer1 = new Buyer("Antony");
//            Buyer buyer2 = new Buyer("Janeth");
//            Buyer buyer3 = new Buyer("Tom");
//
//            Product product1 = new Product("Milk", 60);
//            Product product2 = new Product("Coffee", 100);
//            Product product3 = new Product("Tea", 70);
//
//            Order order1 = new Order(buyer1, product2);
//            Order order2 = new Order(buyer2, product3);
//            Order order3 = new Order(buyer3, product1);
//
//            session.beginTransaction();
//            session.save(buyer1);
//            session.save(buyer2);
//            session.save(buyer3);
//            session.save(product1);
//            session.save(product2);
//            session.save(product3);
//            session.getTransaction().commit();
//
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.save(order1);
//            session.save(order2);
//            session.save(order3);
//            session.getTransaction().commit();

            System.out.println("Пожалуйста, введите команду: ");
            Scanner scanner = new Scanner(System.in);

            String command = scanner.next();
            if (command.equals("/showProductsByPerson")) {
                String person = scanner.next();
                ShowProducts(person, factory);
            }
            else if (command.equals("/findPersonsByProductTitle")) {
                String product = scanner.next();
                FindBuyers(product, factory);
            }
            else if (command.equals("/removePerson")) {
                String person = scanner.next();
                RemoveBuyer(person, factory);
            }
            else if (command.equals("/removeProduct")) {
                String product = scanner.next();
                RemoveProduct(product, factory);
            }
            else if (command.equals("/buy")) {
                String person = scanner.next();
                String product = scanner.next();
                String price = scanner.next();
                Buy(person, product, Integer.parseInt(price), factory);
            }
//            else if (command.equals("/history")) {
//                String product = scanner.next();
//                History(product, factory);
//            }
        } finally {
            factory.close();
            session.close();
        }
    }

    public static void ShowProducts(String person, SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<String> result = session.createQuery("select product.title from Order o where buyer.name =:person order by buyer.name")
                .setParameter("person", person)
                .getResultList();
        List<Integer> result1 = session.createQuery("select productPrice from Order o where buyer.name =:person order by buyer.name")
                .setParameter("person", person)
                .getResultList();
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < result.size(); i++) {
//            set.add(result.get(i).toString());
//        }
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).toString() + "\t" + result1.get(i).toString());
        }
//        System.out.println(result.get(0));
        session.getTransaction().commit();
    }

    public static void FindBuyers(String product, SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<String> result = session.createQuery("select buyer.name from Order o where product.title = :product")
                .setParameter("product", product)
                .getResultList();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            set.add(result.get(i).toString());
        }
        System.out.println(set);
        session.getTransaction().commit();
    }

    public static void RemoveBuyer(String person, SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        System.out.println(person);
        session.createQuery("delete from Buyer b where b.name = :person")
                .setParameter("person", person)
                .executeUpdate();
        System.out.println("Person removed!");
        session.getTransaction().commit();
    }

    public static void RemoveProduct(String product, SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Product p where p.title = :product")
                .setParameter("product", product)
                .executeUpdate();
        System.out.println("Product removed!");
        session.getTransaction().commit();
    }

    public static void Buy(String person, String productTitle, int productPrice, SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> product = session.createQuery("select p from Product p where p.title = :product")
                .setParameter("product", productTitle)
                .getResultList();
        List<Buyer> buyer = session.createQuery("select b from Buyer b where b.name = :buyer")
                .setParameter("buyer", person)
                .getResultList();

        Order order = new Order(buyer.get(0), product.get(0), productPrice);
        session.save(order);
        System.out.println("Buy confirmed! " + order.toString());
        session.getTransaction().commit();
    }


//    public static void Update(String person, String productTitle, SessionFactory factory) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        List<Product> product = session.createQuery("select p from Product p where p.title = :product")
//                .setParameter("product", productTitle)
//                .getResultList();
//        List<Buyer> buyer = session.createQuery("select b from Buyer b where b.name = :buyer")
//                .setParameter("buyer", person)
//                .getResultList();
//        List<Order> orders = session.createQuery("select o from Order o where o. = :order")
//                .setParameter("buyer", person)
//                .getResultList();
//        Order order = new Order(buyer.get(0), product.get(0));
//        Order order = new Order(buyer.get(0), product.get(0));
//
//        session.save(order);
//        System.out.println("Buy confirmed! " + order.toString());
//        session.getTransaction().commit();
//    }

//    public static void History(String product, SessionFactory factory) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        List<String> result = session.createQuery("select product.price from Order o where product.title = :product")
//                .setParameter("product", product)
//                .getResultList();
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < result.size(); i++) {
//            set.add(result.get(i).toString());
//        }
//        System.out.println(set);
//        session.getTransaction().commit();
//    }
}