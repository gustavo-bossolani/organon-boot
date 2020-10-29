package br.com.organon.fiap.repository;

import br.com.organon.fiap.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<Ficha, Integer> {
}
