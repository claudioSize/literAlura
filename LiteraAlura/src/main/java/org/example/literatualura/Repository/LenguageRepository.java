package org.example.literatualura.Repository;

import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.hibernate.id.IncrementGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LenguageRepository extends JpaRepository<LenguageEntity, Integer> {
    @Query(value = "SELECT * FROM lenguage_entity WHERE lenguage = :elect", nativeQuery = true)
    List<LenguageEntity> findLenguage(@Param("elect") String elect );
}
