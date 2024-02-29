package model;


/*Recordar que deben ser clases POJO.
Para ello deben tener:
    - Constructor defautl
    - Getters y Setters publicos
    - ATributos privados
    - Clase Serializable para poder partirla.

 */


import controller.DAOLiga;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// EL USO DE LOMBOOK NOS PERMITE TRAER METODOS Y CONSTRUCTORES CON LAS SIGUIENTES ANOTACIONES
@NoArgsConstructor //CONSTRUCTOR POR DEFECTO
@AllArgsConstructor // CONSTRUCTOR CON TODOS LOS PARAMETROS.
@Getter // TODOS LOS GETTERS
@Setter //TODOS LO SETTERS


//INDICAMOS QUE LA CLASE ES UNA ENTIDAD QUE REPRESENTA UNA TUPLA DE DATOS EN LA DB.
@Entity
// LOS OBJETOS DE LA CLASE IRAN A UNA TABLA EN LA DB llamada "equipos"
@Table(name = "equipos")

public class Equipo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private int id;
    @Column(name = "nombre_equipo")
    private String nombre;
    @Column
    private String ciudad;
    @Embedded
    private DatosEquipo datosEquipo;

    //RELACION LIGA
    //Una liga puede tener muchos equipos, y un equipo solo puede jugar en una liga.
    //CascadeTyoe.ALL hace que los datos persistan en ambos lados de la relacion.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_liga", foreignKey = @ForeignKey(name = "id_liga"))
    private Liga liga;

    //RELACION PARTIDOS
    //COMO EQUIPO LOCAL
    @OneToMany(mappedBy = "equipoLocal")
    private List<Partido> partidosLocal = new ArrayList<>();

    //COMO EQUIPO VISITANTE
    @OneToMany(mappedBy = "equipoVisitante")
    private List<Partido> partidosVisitante = new ArrayList<>();


    //CONSTRUCTOR SIN ID. YA QUE ES PRIMARY KEY Y ESTA EN LA DB DE MANERA INCREMENTAL

    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;

    }

    public Equipo(String nombre, String ciudad, DatosEquipo datosEquipo) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.datosEquipo = datosEquipo;
    }



    public void mostrarDatosEquipo() {
        System.out.println("Nombre Equipo: " + getNombre() +
                "\nCiudad: " + getCiudad() +
                "\nNombre Liga: " + getLiga().getNombre());

    }



}
