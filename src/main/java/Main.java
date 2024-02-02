import database.HibernateUtil;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //Creamos la sesion
        Session session = sessionFactory.getCurrentSession();
        // Activar la transaccion de objetos.
        session.beginTransaction();
        Liga liga = new Liga("Liga Española", "Agosto","Mayo" );
        session.persist(liga);
        session.getTransaction().commit();
        session.close();


        }


    }
