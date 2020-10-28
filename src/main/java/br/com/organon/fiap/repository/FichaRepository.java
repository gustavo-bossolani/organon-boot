package br.com.organon.fiap.repository;

import br.com.organon.fiap.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FichaRepository extends JpaRepository<Ficha, Integer> {
    Optional<Ficha> findAllById(int id);
}
