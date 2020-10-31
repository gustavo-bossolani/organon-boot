package br.com.organon.fiap.repository;

import br.com.organon.fiap.entity.Ficha;
import br.com.organon.fiap.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<Ficha, Integer> { }
