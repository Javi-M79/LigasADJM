package controller;

import database.HibernateUtil;
import jakarta.persistence.Query;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAOEquipo {

    private final SessionFactory sessionFactory;

    public DAOEquipo() {

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //METODO DE INSERCION DE UN EQUIPO SIN LIGA.

    public void insertarEquipo(Equipo equipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Comprobamos si el equipo existe.
        Query query = session.createQuery("FROM Equipo WHERE nombre = :nombre", Equipo.class);
        query.setParameter("nombre", equipo.getNombre());
        List<Equipo> equiposCreados = query.getResultList();
        //Si no existe lo creo.
        if (equiposCreados.isEmpty()) {
            session.persist(equipo);
            session.getTransaction().commit();
            System.out.println("Equipo creado con exito.");
        } else {
            System.out.println("El equipo ya existe en la base de datos.");
        }
        session.close();
    }

    //OBTENER EQUiPOS DE LA BASE DE DATOS.
    public void listaEquipos() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("Select e from Equipo e", Equipo.class);
        List<Equipo> equipos = query.getResultList();

        for (Equipo e : equipos) {
            if (e.getLiga() != null) {
                System.out.println("- ID Equipo: " + e.getId());
                System.out.println("    - Nombre: " + e.getNombre());
                System.out.println("    - Ciudad: " + e.getCiudad());
                System.out.println("    - Liga: " + e.getLiga().getNombre());
                //SI ALGUN EQUIPO NO TIENE LIGA LO MOSTRAMOS SIN ELLA
            } else {
                System.out.println("- ID Equipo: " + e.getId());
                System.out.println("    - Nombre: " + e.getNombre());
                System.out.println("    - Ciudad: " + e.getCiudad());
            }
        }
        session.getTransaction().commit();
        session.close();

    }

    //BUSQUEDA UN SOLO EQUIPO POR NOMBRE.
    public void getEquipo(String nombre) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("Select e from Equipo e WHERE nombre= :nombre", Equipo.class)
                .setParameter("nombre", nombre);

        Equipo equipo = (Equipo) query.getSingleResult();

        if (equipo != null) {
            //SI ESTA INSCRITO EN UNA LIGA.
            if (equipo.getLiga() != null) {
                System.out.println("- ID Equipo: " + equipo.getId());
                System.out.println("    - Nombre: " + equipo.getNombre());
                System.out.println("    - Ciudad: " + equipo.getCiudad());
                System.out.println("    - Liga: " + equipo.getLiga().getNombre());

            } else {
                System.out.println("- ID Equipo: " + equipo.getId());
                System.out.println("    - Nombre: " + equipo.getNombre());
                System.out.println("    - Ciudad: " + equipo.getCiudad());
                System.out.println("    - Todavia no esta inscrito en ninguna liga.");
            }
        } else {
            System.out.println("El equipo no existe.");
        }
        session.getTransaction().commit();
        session.close();

    }

    //BUSQUEDA UN SOLO EQUIPO POR ID.

    public void getEquipoId(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("Select e from Equipo e WHERE id= :id", Equipo.class)
                .setParameter("id", id);
        List<Equipo> equiposId = query.getResultList();

        for (Equipo e : equiposId) {

            if (e.getLiga() != null) {
                System.out.println("- ID Equipo: " + e.getId());
                System.out.println("    - Nombre: " + e.getNombre());
                System.out.println("    - Ciudad: " + e.getCiudad());
                System.out.println("    - Liga: " + e.getLiga().getNombre());
                //SI ALGUN EQUIPO NO TIENE LIGA LO MOSTRAMOS SIN ELLA
            } else {
                System.out.println("- ID Equipo: " + e.getId());
                System.out.println("    - Nombre: " + e.getNombre());
                System.out.println("    - Ciudad: " + e.getCiudad());

            }
        }

        session.getTransaction().commit();
        session.close();


    }

    //AÑADIR EQUIPOS A LIGA
    public void equipoALiga(Equipo equipo, Liga liga) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//Comprobamos si la liga existe
        Query queryLiga = session.createQuery("FROM Liga WHERE nombre = :nombre");
        queryLiga.setParameter("nombre", liga.getNombre());
        List<Liga> ligasCreadas = queryLiga.getResultList();

        if (ligasCreadas.isEmpty()) {
            session.persist(liga);
            System.out.println("Liga " + liga.getNombre() + " creada con exito.");
        } else {
            liga = ligasCreadas.getFirst();
        }
        //Comprobamos que el equipo exista

        Query query = session.createQuery("FROM Equipo WHERE nombre = :nombre", Equipo.class);
        query.setParameter("nombre", equipo.getNombre());
        List<Equipo> equiposCreados = query.getResultList();

        //Si no existe lo creo y le añado la liga

        if (equiposCreados.isEmpty()) {
            equipo.setLiga(liga);
            session.persist(equipo);
            System.out.println("Equipo creado con exito y asignado a la liga: " + liga.getNombre());

        } else {
            equipo = equiposCreados.getFirst();
            if (equipo.getLiga() == null) {
                equipo.setLiga(liga);
                session.persist(equipo);
                System.out.println("El equipo se ha actualizado y se ha asigando a la liga.");
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    //ASIGNAR EQUIPOS A UNA LIGA POR SU ID

    public void equipoALigaporId(int idEquipo, int idLiga) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//Comprobamos si la liga existe con ese ID
        Query queryLiga = session.createQuery("FROM Liga WHERE id = :id");
        queryLiga.setParameter("id", idLiga);
        List<Liga> ligasCreadas = queryLiga.getResultList();

        if (ligasCreadas.isEmpty()) {
            System.out.println("La liga con Id " + idLiga + "no existe.");
        }
        //Comprobamos que el equipo exista

        Query query = session.createQuery("FROM Equipo WHERE id = :id", Equipo.class);
        query.setParameter("id", idEquipo);
        List<Equipo> equiposCreados = query.getResultList();

        if (equiposCreados.isEmpty()) {
            System.out.println("El equipo con el ID: " + idEquipo + " no existe.");
        } else {
            Equipo equipo = equiposCreados.getFirst();

            //SI NO TIENE ASIGNADA UN ALIGA SE LA ASIGNAMOS.
            if (equipo.getLiga() == null) {
                equipo.setLiga(ligasCreadas.getFirst());
                session.persist(equipo);
                System.out.println("El equipo se ha actualizado y se ha asigando a la liga.");
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    //BORRAR EQUIPO POR ID
    public void borrarEquipo(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Equipo e WHERE e.id = :id")
                .setParameter("id", id);

        //Executeupdate(); Nos devuelve un numero que hace referencia al numero de filas que ha borrado.
        int equipoBorrado = query.executeUpdate();
        if (equipoBorrado == 0) {
            System.out.println("El equipo con ID: " + id + " no existe.");
        } else {
            System.out.println("Equipo con ID: " + id + " ha sido borrado con exito.");

        }

        session.getTransaction().commit();
        session.close();


    }


    //  MODIFICACION NOMBRE EQUIPOS
    public void modificarNombreEquipo(int id, String nombre) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Query query = session.createQuery("UPDATE Equipo e set e.nombre = :nombre WHERE e.id = :id")
                .setParameter("nombre", nombre)
                .setParameter("id" , id);

        int equipoModificado = query.executeUpdate();

        if(equipoModificado>0){

            System.out.println("Equipo actualizado con exito.");
        }else {
            System.out.println("No se ha podido actualizar el equipo.");
        }

        //En este caso no debemos persistir de nuevo el objeto.

        session.getTransaction().commit();
        session.close();
    }

}








