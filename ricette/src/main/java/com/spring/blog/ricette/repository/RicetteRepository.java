package com.spring.blog.ricette.repository;

import com.spring.blog.ricette.model.Ricette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicetteRepository extends JpaRepository<Ricette, Integer> {

}
