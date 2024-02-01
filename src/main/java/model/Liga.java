package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "ligas")
public class Liga implements Serializable {

    @Id
    @Column(name = "id_liga")
    private int id;
    @Column(name = "nombre_liga")
    private String nombre;
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Column(name = "fecha_fin")
    private String fechaFin;


    public Liga(String nombre, String fechaInicio, String fechaFin) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

}
