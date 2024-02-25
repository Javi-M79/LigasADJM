package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


@Embeddable
public class DatosEquipo implements Serializable {

    @Column
    private String estadio;

    @Column
    private String web;



}
