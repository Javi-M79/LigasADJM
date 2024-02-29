package controller;


//ESTAS CLASES GESTIONAN LAS OPERACIONES QUE PODEMOS HACER CON CADA UNA DE LAS CLASES PRINCIPALES

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Partido;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class DAOPartido {

    //Cada una tendra un objeto de SessionFactory para poder acceder a la DB.
    private SessionFactory sessionFactory;


    //La iniciamos dentro del constructor.
    public DAOPartido() {

        sessionFactory = HibernateUtil.getSessionFactory();
    }


    //INSERTAR PARTIDO

    public void insertarPartido(String fecha, int idEquipoLocal, int idEquipoVisitante) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //SIMULAMOS UN MARCADOR ALEATORIO.

        int golesLocal = (int) (Math.random() * 10 + 1);
        int golesVisitante = (int) (Math.random() * 10 + 1);

        //RECUPERAMOS LOS EQUIPOS A TRAVES DE SU ID.

        Query queryLocal = session.createQuery("SELECT e FROM Equipo e WHERE id= :id ", Equipo.class)
                .setParameter("id", idEquipoLocal);

        Query queryVisitante = session.createQuery("SELECT e FROM Equipo e WHERE id= :id", Equipo.class)
                .setParameter("id", idEquipoVisitante);

        //LOS IGUALAMOS A DOS OBJETOS NUEVOS PARA SACAR SUS DATOS.
        Equipo equipoLocal = (Equipo) queryLocal.getSingleResult();
        Equipo equipoVisitante = (Equipo) queryVisitante.getSingleResult();

        //CREAMOS UN PARTIDO

        Partido partido = new Partido(fecha, golesLocal, golesVisitante);

        //SI LOS EQUIPOS EXISTE EL PARTIDO SE PUEDE CREAR, SI NO SE DEBEN AÑADIR A LA BASE DE DATOS.
        if (equipoLocal != null) {
            partido.setEquipoLocal(equipoLocal);
            partido.setEquipoLocal(equipoLocal);
        } else {
            System.out.println(" El equipo local con ID: " + equipoLocal.getId() + " no se encuentra en la base de datos.");
        }
        if (equipoVisitante != null) {
            partido.setEquipoVisitante(equipoVisitante);
        } else {
            System.out.println(" El equipo visitante con ID: " + equipoVisitante.getId() + " no se encuentra en la base de datos.");
        }
        //ESTABLECEMOS QUE EL PARTIDO SE JUEGA EN LA LIGA DEL EQUIPO LOCAL YA QUE SOLO TENEMOS UN ID.
        partido.setLiga(equipoLocal.getLiga());
        session.persist(partido);
        System.out.println("Partido creado con exito.");
        session.getTransaction().commit();
        session.close();
    }


    //OBTENER LA LISTA TOTAL DE PARTIDOS DISPUTADOS EN TODAS LAS LIGAS
    public void calendarioPartidos() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //Creamos la query para listar los partidos.

        Query query = session.createQuery(" SELECT p FROM Partido p", Partido.class);

        List<Partido> listaPartidos = query.getResultList();

        for (Partido p : listaPartidos) {

            System.out.println("Fecha: " + p.getFechaPartido());
            System.out.println("Resultado: " + p.getEquipoLocal().getNombre() + " " + p.getGolesLocal() + " - " + p.getEquipoVisitante().getNombre() + " " + p.getGolesVisitante());
            if (p.getGolesLocal() > p.getGolesVisitante()) {
                System.out.println("Ganador: " + p.getEquipoLocal().getNombre());
            } else {
                System.out.println("Ganador: " + p.getEquipoVisitante().getNombre());
            }


        }
        session.getTransaction().commit();
        session.close();


    }

    //LISTAR LOS PARTIDOS DE UNA LIGA POR ID.
    public void partidosLiga(int idLiga) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT p FROM Partido p WHERE p.liga.id = :id")
                .setParameter("id", idLiga);

        List<Partido> partidosLiga = query.getResultList();

        for (Partido p : partidosLiga
        ) {
            System.out.println("Fecha: " + p.getFechaPartido());
            System.out.println("Resultado: " + p.getEquipoLocal().getNombre() + " " + p.getGolesLocal() + " - " + p.getEquipoVisitante().getNombre() + " " + p.getGolesVisitante());
            if (p.getGolesLocal() > p.getGolesVisitante()) {
                System.out.println("Ganador " + p.getEquipoLocal().getNombre());
            } else {
                System.out.println("Ganador " + p.getEquipoVisitante().getNombre());
            }

        }


    }

    //BORRAR PARTIDO
    public void borrarPartido(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Partido p WHERE p.id= :id")
                .setParameter("id", id);

        int borrarPartido = query.executeUpdate();

        if (borrarPartido > 0) {
            System.out.println("Partido con ID: " + id + " borrado con exito.");
        } else {
            System.out.println("El partido no esta registrado en la Base de datos");
        }

        session.getTransaction().commit();
        session.close();
    }

}



