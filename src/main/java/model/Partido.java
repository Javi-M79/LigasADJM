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


    //RELACION EQUIPO LOCAL.

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_local", foreignKey = @ForeignKey(name = "id_equipolocal"))
    private Equipo equipoLocal;

    //RELACION EQUIPO VISITANTE

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_visitante", foreignKey = @ForeignKey(name = "id_equipovisitante"))
    private Equipo equipoVisitante;

   //RELACION LIGA

    // Relación con la clase Liga para la liga a la que pertenece el partido.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_liga", foreignKey = @ForeignKey(name = "id_liga"))
    private Liga liga;




    public Partido(String fechaPartido, int golesLocal, int golesVisitante) {

        this.fechaPartido = fechaPartido;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;


    }

    //METODOS A CREAR
    //JUGAR PARTIDO. fECHA, DOS EQUIPOS Y RESULTADO (RANDOM)
    // MOSTRAR PARTIDOS. CALENDARIO.


    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", fechaPartido='" + fechaPartido + '\'' +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", equipoLocal=" + equipoLocal.getNombre() +
                ", equipoVisitante=" + equipoVisitante.getNombre() +
                ", liga=" + liga.getNombre() +
                '}';
    }
}
