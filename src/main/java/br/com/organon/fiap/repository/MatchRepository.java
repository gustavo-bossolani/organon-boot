package br.com.organon.fiap.repository;

import br.com.organon.fiap.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    Optional<Match> findByPacienteDoadorId(int id);
    Optional<Match> findByPacienteReceptorId(int id);

}
