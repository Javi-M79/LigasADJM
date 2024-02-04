package controller;

import database.HibernateUtil;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DAOLiga {

    private SessionFactory sessionFactory;
//    private ArrayList<Liga> listaLigas = new ArrayList<>();


    public DAOLiga() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    public void insertarLiga(Liga liga) {

        Session session = sessionFactory.openSession();


        session.beginTransaction();

        session.persist(liga);

        session.getTransaction().commit();

        session.close();

    }


    //METODO AÑADIR EQUIPOS A UNA LIGA

    public void añadirEquipo(Equipo equipo, Liga liga) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        equipo.setIdLiga(liga);
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();



    }




}
