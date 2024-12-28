package org.example.literatualura.Service;

import org.example.literatualura.DTO.LibroDTO;
import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class GetAuthoresYear {

    @Autowired
    AuthorRepository authorRepository;
    //Metodo para pedir un anio de busqueda si se encuentra devuelve una lista respuesta con los autores encontrado en esa fecha
    public List<String> getAuthorYears(){
        List<String> response = new ArrayList<>();
        System.out.println("Escriba un año");
        Scanner scan = new Scanner(System.in);
        int date;
        if (!scan.hasNextInt()){
            response.add("Error la fecha solo debe contener numeros enteros");
        }else {
            try {
                date = scan.nextInt();

                List<AuthorEntity> autos = authorRepository.findAuthorYears(date);
                for(AuthorEntity auto : autos){

                    LibroEntity libro1 = auto.getLibroEntity();
                    String slas = "---------Autor---------";
                    response.add(slas);

                    response.add("Nombre: "+auto.getNombre());
                    response.add("fecha nacimiento: "+auto.getBirthDate());
                    response.add("fecha muerte: "+auto.getDeathdate());

                    for (LenguageEntity len : libro1.getLanguages()){
                        response.add("Lenguajes: "+len.getLenguage());
                    }

                    response.add("Libro: "+ libro1.getTitles());
                    String slas2 = "-----------------------";
                    response.add(slas2);
                }
                return response;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                response.add("No existe un registro en esa fecha");
            }
        }
        return response;
    }

}
