import controller.DAOEquipo;
import controller.DAOLiga;
import controller.DAOPartido;
import model.DatosEquipo;
import model.Equipo;
import model.Liga;
import model.Partido;

import java.util.ArrayList;
import java.util.List;

public class Entrada {


    public static void main(String[] args) {


        DAOEquipo operacionesEquipo = new DAOEquipo();
        DAOLiga operacionesLigas = new DAOLiga();
        DAOPartido operacionesPartido = new DAOPartido();


        /*BORRADO DE DATOS DE LA DB

        for (int i = 0; i < 100; i++) {
            operacionesPartido.borrarPartido(i);
        }
        for (int i = 0; i < 100; i++) {
            operacionesEquipo.borrarEquipo(i);
        }


        for (int i = 0; i < 100; i++) {
            operacionesLigas.borrarLiga(i);
        }*/


        //CREAR UN A LIGA

//        operacionesLigas.insertarLiga(new Liga("Liga EA Sports ", "Agosto", "Mayo"));

        //CREAR 8 EQUIPOS

//        operacionesEquipo.insertarEquipo(new Equipo("Real Madrid", "Madrid"));
//        operacionesEquipo.insertarEquipo(new Equipo("Atletico de Madrid", "Madrid"));
//        operacionesEquipo.insertarEquipo(new Equipo("F.C Barcelona", "Barcelona"));
//        operacionesEquipo.insertarEquipo(new Equipo("Girona", "Girona"));
//        operacionesEquipo.insertarEquipo(new Equipo("Celta de Vigo", " Vigo"));
//        operacionesEquipo.insertarEquipo(new Equipo("Almeria CF", "Almeria"));
//        operacionesEquipo.insertarEquipo(new Equipo("Atlethic de Bilbao", "Bilbao"));
//        operacionesEquipo.insertarEquipo(new Equipo("Real Sociedad", "San Senbastian"));


        //AÑADIR LOS EQUIPOS A UNA LIGA

        //Nuevos equipos y se le asignan una liga directamente.
//        operacionesEquipo.equipoALiga(new Equipo("PSG", "Paris"), new Liga("Ligue 1 Uber Eats", "Junio","Febrero"));
//        operacionesEquipo.equipoALiga(new Equipo("Manchester United", "Manchester"), new Liga("Premier League", "Enero","Diciembre"));

        //Equipos existentes a los que solo se les inscribe en una liga a traves de su ID.
//        operacionesEquipo.equipoALigaporId(99,80);
//        operacionesEquipo.equipoALigaporId(100,80);
//        operacionesEquipo.equipoALigaporId(101,80);
//        operacionesEquipo.equipoALigaporId(102,80);
//

        //CREAR 6 PARTIDOS
//
//        operacionesPartido.insertarPartido("2024-8-15" , 99, 100);
//        operacionesPartido.insertarPartido("2024-8-15" , 101, 102);
//        operacionesPartido.insertarPartido("2024-8-16" , 103, 104);
//        operacionesPartido.insertarPartido("2024-9-02" , 105, 106);
//        operacionesPartido.insertarPartido("2024-9-03" , 99, 102);
//        operacionesPartido.insertarPartido("2024-9-03" , 101, 100);


        //MOSTRAR DATOS DE TODOS LOS EQUIPOS

//        operacionesEquipo.listaEquipos();

        //ELIMINAR DOS EQUIPOS
//

        //Debemos borrar primero los partidos en los que estan involucrados

//        operacionesPartido.borrarPartido(12);

//
//        operacionesEquipo.borrarEquipo(105);
//        operacionesEquipo.borrarEquipo(106);


        //MOSTRAR PARTIDOS DE UNA LIGA CONCRETA

//        operacionesPartido.partidosLiga(80);


//        operacionesEquipo.listaEquipos();

        operacionesEquipo.modificarNombreEquipo(107, "Paris Saint Germain");

    }


}
