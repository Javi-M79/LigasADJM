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
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "partidos")

public class Partido implements Serializable {

    @Id
    @Column(name = "id_partido")
    private int id;
    @Column(name = "fecha_partido")
    private Date fechaPartido;
    @Column(name = "goles_local")
    private int golesLocal;
    @Column(name = "goles_visitante")
    private int golesVisitante;

    public Partido(Date fechaPartido, int golesLocal, int golesVisitante){

        this.fechaPartido=fechaPartido;
        this.golesLocal= golesLocal;
        this.golesVisitante= golesVisitante;


    }


}
