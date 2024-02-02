package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "partidos")

public class Partido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private int id;

    @Column(name = "fecha_partido")
    private String fechaPartido;

    @Column(name = "goles_local")
    private int golesLocal;

    @Column(name = "goles_visitante")
    private int golesVisitante;

    public Partido(String fechaPartido, int golesLocal, int golesVisitante){

        this.fechaPartido=fechaPartido;
        this.golesLocal= golesLocal;
        this.golesVisitante= golesVisitante;


    }


}
