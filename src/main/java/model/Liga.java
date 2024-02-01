package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Liga implements Serializable {

    @Id
    @Column (name  = "id_liga")
    private int id;
    @Column
    private String nombre_liga;
    @Column
    private String fecha_inicio;
    @Column
    private String fecha_fin;



}
