package org.example.literatualura.Repository;

import org.example.literatualura.Entitys.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    @Query(value = "SELECT * FROM author_entity WHERE birth_date  BETWEEN :inicio AND (:inicio - MOD(:inicio, 100) + 99)", nativeQuery = true)
    List<AuthorEntity> findAuthorYears(@Param("inicio") int inicio);

}
