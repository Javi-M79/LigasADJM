package controller;

import database.HibernateUtil;
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

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.persist(liga);
//        listaLigas.add(liga);

        session.getTransaction().commit();

        session.close();

    }


}
