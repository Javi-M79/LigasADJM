import controller.DAOEquipo;
import controller.DAOLiga;
import controller.DAOPartido;
import model.DatosEquipo;
import model.Equipo;
import model.Liga;

import java.util.List;

public class Entrada {


    public static void main(String[] args) {


        DAOEquipo operacionesEquipo = new DAOEquipo();
        DAOLiga operacionesLigas = new DAOLiga();
        DAOPartido operacionesPartido = new DAOPartido();


//        operacionesEquipo.insertarEquipo(new Equipo("Atletico de Madrid", "Madrid"));
//        operacionesEquipo.insertarEquipo(new Equipo("Real Madrid", "Madrid"));
//        operacionesEquipo.insertarEquipo(new Equipo("Rayo Vallecano", "Madrid"));
//        operacionesEquipo.insertarEquipo(new Equipo("Girona F.C", "Girona"));
//        operacionesEquipo.insertarEquipo(new Equipo("Real Betis Balompie", "Sevilla", (new DatosEquipo("Benito Villamarin", "https://www.realbetisbalompie.es/"))));
//        operacionesLigas.insertarLiga(new Liga("Premier League", "Abril", "Junio"));
//        operacionesEquipo.equipoALiga(new Equipo("Manchester United", "Manchester", (new DatosEquipo("Old Trafford" ,"https://www.manutd.com/es/" ))), (new Liga("Premier Leage2", "Enero", "Mayo")));
//        operacionesEquipo.equipoALiga(new Equipo("Real Madrid", "Madrid"), (new Liga("Liga EA", "Agosto", "Mayo")));
        operacionesLigas.verEquiposliga("Liga EA");

    }


}
