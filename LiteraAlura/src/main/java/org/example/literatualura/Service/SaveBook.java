package org.example.literatualura.Service;

import org.example.literatualura.DTO.AuthorDTO;
import org.example.literatualura.DTO.DatesWrapper;
import org.example.literatualura.DTO.LenguageDTO;
import org.example.literatualura.DTO.LibroDTO;
import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class SaveBook {
    @Autowired
    Template template;
    @Autowired
    LibroRepository libroRepository;

    private final LibroEntity libro = new LibroEntity();
    private final AuthorEntity authoror = new AuthorEntity();
    private final LenguageEntity lenguage = new LenguageEntity();
    //Metodo que permite la busqueda del libro en la api y si la encuentra convierte los dto en entidades y lo guarda en la base de datos
    public String saveLibro(){
        System.out.println("Escriba un libro a buscar");
        Scanner scan = new Scanner(System.in);
        String scaner = scan.next().replace(" ","+");
        LibroDTO dto = template.response(scaner);

        if (dto == null || dto.getResponse().isEmpty()){
            return "No existe registro del libro buscado";
        }

        DatesWrapper response = dto.getResponse().get(0);


        convertAuthorToEntity(response);
        converLengToEntity(response);

        if (libroRepository.existsByTitles(response.getTitles())) {
            return "El libro con el título '" + response.getTitles() + "' ya está registrado.";
        }

        libro.setTitles(response.getTitles());
        libro.setAuthor(List.of(authoror));
        libro.setLanguages(List.of(lenguage));
        libro.setDownCount(response.getDownCount());

        try {
            libroRepository.save(libro);
            return response.toString();
        }catch (Exception e){
            System.out.println("Error al hacer registro");
            throw e;
        }
    }
//Metodo para convertir el dto de autor en la entidad autor para guardarlo en la base de datos
    public void convertAuthorToEntity(DatesWrapper datesWrapper){
        List<AuthorDTO> authorDTO = datesWrapper.getAuthot();
        for (AuthorDTO auto : authorDTO){
            authoror.setNombre(auto.getNombre());
            authoror.setBirthDate(auto.getBirthDate());
            authoror.setDeathdate(auto.getDeathdate());
            authoror.setLibroEntity(libro);
        }
    }
    //Tambien para convertir dto en entity
    public void converLengToEntity(DatesWrapper datesWrapper){
        List<LenguageDTO> leng = datesWrapper.getLanguages();
        for (LenguageDTO lenguageDTO : leng){
            lenguage.setLenguage(lenguageDTO.getLenguage());
            lenguage.setLibroEntity(libro);
        }
    }

}

