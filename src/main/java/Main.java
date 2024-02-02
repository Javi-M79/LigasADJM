import controller.DAOEquipo;
import controller.DAOLiga;
import controller.DAOPartido;
import database.HibernateUtil;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {


    public static void main(String[] args) {


        DAOEquipo operacionesEquipo = new DAOEquipo();
        DAOLiga operacionesLigas = new DAOLiga();
        DAOPartido operacionesPartido = new DAOPartido();

        operacionesEquipo.insertarEquipo(new Equipo("Atletico de Madrid", "Madrid"));
        operacionesEquipo.insertarEquipo(new Equipo("Real Madrid", "Madrid"));
        operacionesEquipo.insertarEquipo(new Equipo("Rayo Vallecano", "Madrid"));
        operacionesEquipo.insertarEquipo(new Equipo("Girona F.C", "Girona"));



    }


}
