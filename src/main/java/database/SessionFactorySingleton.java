package database;


import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import service.dto.CommentDTO;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {
    }

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Expert.class)
                    .addAnnotatedClass(Service.class)
                    .addAnnotatedClass(Comment.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Offer.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}
