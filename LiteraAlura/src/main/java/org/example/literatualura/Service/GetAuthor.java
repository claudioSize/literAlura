package org.example.literatualura.Service;

import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAuthor {
    @Autowired
    LibroRepository libroRepository;
    @Autowired
    private Template template;
    //Metodo que devuelve todos los autores en la BD
    public List<String> getAuthorsList(){
        List<LibroEntity> lib = libroRepository.findAll();
        List<String> response = new ArrayList<>();

        for(LibroEntity libro : lib){
            String slas = "---------Autor---------";
            response.add(slas);
            List<AuthorEntity> au = libro.getAuthor();
            for (AuthorEntity auto : au){
                String autores = "Autor: "+auto.getNombre();
                response.add(autores);
                String birthData = "Año de nacimiento: "+auto.getBirthDate();
                response.add(birthData);
                String deathData = "Año de fallecimiento: "+auto.getDeathdate();
                response.add(deathData);
            }

            List<LenguageEntity> lengua = libro.getLanguages();
            for (LenguageEntity len : lengua){
                String autores = "Lenguaje: "+len.getLenguage();
                response.add(autores);
            }
            response.add("Libro: "+libro.getTitles());

            String slas2 = "-----------------------";
            response.add(slas2);
        }
        return response;
    }
}
