package ua.lviv.iot.lab_4;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.lviv.iot.lab_4.model.*;

import java.util.Properties;

@Getter
public class Connector {

    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        try {
            Properties properties = new Properties();
            Configuration configuration = new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Device.class)
                    .addAnnotatedClass(DeviceNotification.class)
                    .addAnnotatedClass(DevicePlacing.class)
                    .addAnnotatedClass(DeviceType.class)
                    .addAnnotatedClass(MyObject.class)
                    .addAnnotatedClass(Role.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(RoomType.class)
                    .addAnnotatedClass(SystemNotification.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserSecurity.class)
                    .addAnnotatedClass(Zone.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connector() {
    }

    public static Session getSession() {
        if (session==null || !session.isConnected()){
            session = sessionFactory.openSession();
        }
        return session;
    }
}
