import controller.DAOEquipo;
import controller.DAOLiga;
import controller.DAOPartido;
import model.DatosEquipo;
import model.Equipo;
import model.Liga;

import java.util.ArrayList;
import java.util.List;

public class Entrada {


    public static void main(String[] args) {


        DAOEquipo operacionesEquipo = new DAOEquipo();
        DAOLiga operacionesLigas = new DAOLiga();
        DAOPartido operacionesPartido = new DAOPartido();

        operacionesLigas.insertarLiga(new Liga("Liga EA Sports ", "Agosto", "Mayo"));
        operacionesEquipo.insertarEquipo(new Equipo("Real Madrid", "Madrid"));



//        operacionesEquipo.insertarEquipo(new Equipo("Atletico de Madrid", "Madrid"));
//
//        operacionesEquipo.insertarEquipo(new Equipo("Rayo Vallecano", "Madrid"));
//        operacionesEquipo.insertarEquipo(new Equipo("Girona F.C", "Girona"));
//        operacionesEquipo.insertarEquipo(new Equipo("Real Betis Balompie", "Sevilla", (new DatosEquipo("Benito Villamarin", "https://www.realbetisbalompie.es/"))));

//        operacionesEquipo.equipoALiga(new Equipo("Manchester United", "Manchester", (new DatosEquipo("Old Trafford" ,"https://www.manutd.com/es/" ))), (new Liga("Premier Leage2", "Enero", "Mayo")));
//        operacionesEquipo.equipoALiga(new Equipo("Real Madrid", "Madrid"), (new Liga("Liga EA", "Agosto", "Mayo")));
////        operacionesLigas.verEquiposliga("Liga EA");//
//        operacionesEquipo.eliminarEquipo(equipo1);
//        operacionesLigas.insertarLiga(new Liga("Liga Fancesa", "Abril", "Junio"));
//        operacionesEquipo.getEquipos();
//        operacionesEquipo.getEquipo("Real Madrid");
//        operacionesEquipo.equipoALiga(new Equipo("Barcelona FC", "Barcelona"), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.equipoALiga(new Equipo("Villareal FC", "Castellon"), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.getEquipoId(30);
//        operacionesEquipo.listaEquipos();
//        operacionesLigas.addEquipoLiga((new Equipo("Villareal FC", "Castellon")), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.equipoALiga((new Equipo("Almeria", "Almeria")), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.equipoALiga((new Equipo("Getafe", "Madrid")), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.equipoALiga((new Equipo("Sevilla", "Sevilla")), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.equipoALiga((new Equipo("Osasuna", "Pamplona")), (new Liga("Liga EA", "Agosto", "Mayo")));
//        operacionesEquipo.listaEquipos();
////        operacionesLigas.getLiga("Liga EA");
//        operacionesEquipo.listaEquipos();
//        operacionesLigas.insertarLiga(new Liga("Bundesliga", "Enero", "Diciembre"));
//        operacionesLigas.listaLigas();
//        operacionesLigas.getLiga("Bundesliga");
//        operacionesLigas.listarEquiposPorLiga(66);
//        operacionesLigas.listarEquiposPorLiga(36);
//        operacionesLigas.listarEquiposPorLiga(45);
//        operacionesLigas.listarEquiposNombre("Liga EA");
//        operacionesLigas.listarEquiposPorLiga(45);
//        operacionesLigas.listarEquiposPorLiga(45);
//        operacionesLigas.getLigaID(66);
//        operacionesEquipo.borrarEquipo(66);
//        operacionesEquipo.borrarEquipo(67);
//        operacionesEquipo.borrarEquipo(63);
//        operacionesEquipo.borrarEquipo(64);
//        operacionesEquipo.borrarEquipo(69);
//        operacionesEquipo.borrarEquipo(70);
//        operacionesEquipo.borrarEquipo(71);
//        operacionesEquipo.borrarEquipo(72);
//        operacionesEquipo.borrarEquipo(68);
//
//        operacionesLigas.borrarLiga(64);
//        operacionesLigas.borrarLiga(65);
//        operacionesLigas.borrarLiga(66);













    }


}
