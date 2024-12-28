package org.example.literatualura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatesWrapper {
    @JsonAlias("id") private Integer id;
    @JsonAlias("title") private String titles;
    @JsonAlias("authors") private List<AuthorDTO> authot;
    @JsonAlias("languages") private List<LenguageDTO> languages;
    @JsonAlias("download_count") private Integer downCount;

    public DatesWrapper(Integer id, String titles, List<AuthorDTO> author, List<LenguageDTO> languages, Integer downCount) {
        this.id = id;
        this.titles = titles;
        this.authot = author;
        this.languages = languages;
        this.downCount = downCount;
    }

    public DatesWrapper() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public List<AuthorDTO> getAuthot() {
        return authot;
    }

    public void setAuthot(List<AuthorDTO> authot) {
        this.authot = authot;
    }

    public List<LenguageDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LenguageDTO> languages) {
        this.languages = languages;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();

        response.append("---------Libro---------\n");
        response.append("Titulo: ").append(this.titles).append("\n");

        if (authot != null && !authot.isEmpty()) {
            for (AuthorDTO author : authot) {
                response.append("Autor: ").append(author.getNombre()).append("\n");
                response.append("  Año de nacimiento: ")
                        .append(author.getBirthDate() != null ? author.getBirthDate() : "Desconocido")
                        .append("\n");
                response.append("  Año de muerte: ")
                        .append(author.getDeathdate() != null ? author.getDeathdate() : "Desconocido")
                        .append("\n");
            }
        } else {
            response.append("Autores: No disponibles\n");
        }

        if (languages != null && !languages.isEmpty()) {
            for (LenguageDTO language : languages) {
                response.append("Lenguaje: ").append(language.getLenguage()).append("\n");
            }
        } else {
            response.append("Lenguajes: No disponibles\n");
        }

        response.append("Numero de descargas: ").append(this.downCount != null ? this.downCount : 0).append("\n");
        response.append("-----------------------\n");

        return response.toString();
    }

}