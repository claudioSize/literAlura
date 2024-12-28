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
public class GetBooks {
    @Autowired
    LibroRepository libroRepository;

    //Metodo que devuelve todos los libros registrados en la BD
    public List<String> getBooksList(){
        List<LibroEntity> lib = libroRepository.findAll();
        List<String> response = new ArrayList<>();

        for(LibroEntity libro : lib){
            String slas = "---------Libro---------";
            response.add(slas);
            String titleR = "Titulo: "+libro.getTitles();
            response.add(titleR);
            List<AuthorEntity> au = libro.getAuthor();
            for (AuthorEntity auto : au){
                String autores = "Autor: "+auto.getNombre();
                response.add(autores);
            }

            List<LenguageEntity> lengua = libro.getLanguages();
            for (LenguageEntity len : lengua){
                String autores = "Lenguaje: "+len.getLenguage();
                response.add(autores);
            }
            String downLo ="Numero de descargas: "+ String.valueOf(libro.getDownCount());
            response.add(downLo);
            String slas2 = "-----------------------";
            response.add(slas2);
        }
        return response;
    }

}
