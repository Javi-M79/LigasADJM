package model;


/*Recordar que deben ser clases POJO.
Para ello deben tener:
    - Construnctor defautl
    - Getters y Setters publicos
    - ATributos privados
    - Clase Serializable para poder partirla.

 */


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


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





    //CONSTRUCTOR SIN ID. YA QUE ES PRIMARY KEY Y ESTA EN LA DB DE MANERA INCREMENTAL
    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }


}
