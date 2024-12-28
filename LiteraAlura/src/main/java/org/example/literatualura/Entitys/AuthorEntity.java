package org.example.literatualura.Entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "author_Entity")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer birthDate;
    private Integer deathdate;

    @ManyToOne
    @JoinColumn(name = "book_entity_id")
    private LibroEntity libroEntity;

    public AuthorEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(Integer deathdate) {
        this.deathdate = deathdate;
    }

    public LibroEntity getLibroEntity() {
        return libroEntity;
    }

    public void setLibroEntity(LibroEntity libroEntity) {
        this.libroEntity = libroEntity;
    }


}