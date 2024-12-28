package org.example.literatualura.Service;

import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Repository.LenguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class GetLenguage {

    @Autowired
    LenguageRepository lenguageRepository;

    //Metodo para pedir libros con los idiomas listados si se encuentra devuelve una lista respuesta con los libros registrado en ese idioma
    public List<String> getLenguage(){

        List<String> response = new ArrayList<>();
        String menu = """
                    ***************************************************
                      *****  Seleccione un idioma   *****
                    ***************************************************

                    1 - Spanish
                    2 - English
                    
                    \n""";
        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        Integer elect;
        String leng = "";
        if (!scanner.hasNextInt()){
            response.add("Error solo debe ingresar numeros");
        }else {
            elect = scanner.nextInt();
            switch (elect) {
                case 1 -> leng = "es";

                case 2 -> leng = "en";

                default -> System.out.println("Opción no valida intenta otra vez");
            }


            List<LenguageEntity> autos = lenguageRepository.findLenguage(leng);
            for (LenguageEntity auto : autos) {

                LibroEntity libro1 = auto.getLibroEntity();
                String slas = "---------Autor---------";
                response.add(slas);

                for (AuthorEntity len : libro1.getAuthor()) {
                    response.add("Nombre: " + len.getNombre());
                    response.add("fecha nacimiento: " + len.getBirthDate());
                    response.add("fecha muerte: " + len.getDeathdate());
                }

                response.add("Lenguajes: " + auto.getLenguage());
                response.add("Libro: " + libro1.getTitles());
                String slas2 = "-----------------------";
                response.add(slas2);
            }
            return response;
        }
        return response;
    }


}
