package model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "ligas")
public class Liga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liga")
    private int id;

    @Column(name = "nombre_liga")
    private String nombre;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_fin")
    private String fechaFin;


    //RELACION CON EQUIPO
    //El mapeo lo relaciona con el  objeto liga que hemos creado en Equipo.
    @OneToMany(mappedBy = "liga", cascade = CascadeType.ALL)
    private List<Equipo> equipos = new ArrayList<>();

    //RELACION CON PARTIDOS
    @OneToMany(mappedBy = "liga")
    private List<Partido> partidosLiga = new ArrayList<>();

    public Liga(String nombre, String fechaInicio, String fechaFin) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }




    @Override
    public String toString() {
        return "Liga{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", equipos=" + equipos +
                '}';
    }
}
