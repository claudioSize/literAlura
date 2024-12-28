package org.example.literatualura;


import org.apache.catalina.User;
import org.example.literatualura.DTO.LibroDTO;
import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Repository.AuthorRepository;
import org.example.literatualura.Repository.LenguageRepository;
import org.example.literatualura.Repository.LibroRepository;
import org.example.literatualura.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class LiteratuAluraApplication {
    
    @Autowired
    private SaveBook saveBook;
    @Autowired
    private GetBooks getBooks;
    @Autowired
    private GetAuthor getAuthor;
    @Autowired
    private GetAuthoresYear getAuthoresYear;
    @Autowired
    private GetLenguage getLenguage;




    public static void main(String[] args) {
        SpringApplication.run(LiteratuAluraApplication.class, args);
/*        Template cont = context.getBean(Template.class);


        */
    }
    @Bean
    @Transactional
    public CommandLineRunner run() {
        return args -> {
            boolean boleano = false;
            while (!boleano){
                String menu = """
                    ***************************************************
                      *****  Bienvenido a la biblioteca ALURA   *****
                    ***************************************************

                    1 - Busqueda de libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Busqueda de autores por año
                    5 - Busqueda de libro por Idioma
                    6 - Salir
                    \n""";
                System.out.println(menu);
                Scanner scanner = new Scanner(System.in);
                Integer elect;
                if (!scanner.hasNextInt()){
                    System.out.println("Error solo debe ingresar numeros");
                }else {
                    elect = scanner.nextInt();
                    switch (elect) {
                        case 1 -> System.out.println(saveBook.saveLibro());

                        case 2 -> getBooks.getBooksList().forEach(System.out::println);

                        case 3 -> getAuthor.getAuthorsList().forEach(System.out::println);

                        case 4 -> getAuthoresYear.getAuthorYears().forEach(System.out::println);

                        case 5 -> getLenguage.getLenguage().forEach(System.out::println);

                        case 6 -> {

                            System.out.println("Saliendo de la aplicación\n");
                            System.exit(9);
                        }
                        default -> System.out.println("Opción no valida intenta otra vez");
                    }
                }

            }
        };
    }


}
/*




* */