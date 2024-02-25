package controller;

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DAOLiga {

    private SessionFactory sessionFactory;
    private List<Liga> listaLigas = new ArrayList<>();


    public DAOLiga() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    public void insertarLiga(Liga liga) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(liga);
        listaLigas.add(liga);
        session.getTransaction().commit();
        session.close();

    }

    public void verEquiposliga(String nombreLiga){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Liga liga = session.createNativeQuery("Select * From ligas where nombre_liga = '" + nombreLiga+"'"  , Liga.class).list().get(0);
        session.getTransaction().commit();

        List<Equipo> equipos =  liga.getListaEquipos();
        for ( Equipo e : equipos ) {
            e.mostrarDatosEquipo();
        }
        session.close();
    }

}
