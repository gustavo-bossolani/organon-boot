package br.com.organon.fiap.controller;

import br.com.organon.fiap.entity.Ficha;
import br.com.organon.fiap.entity.Match;
import br.com.organon.fiap.exception.ResourceNotFoundException;
import br.com.organon.fiap.forms.MatchForm;
import br.com.organon.fiap.repository.FichaRepository;
import br.com.organon.fiap.repository.MatchRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("matchs")
public class MatchController {

    private MatchRepository matchRepository;
    private FichaRepository fichaRepository;

    public MatchController(MatchRepository matchRepository, FichaRepository fichaRepository) {
        this.matchRepository = matchRepository;
        this.fichaRepository = fichaRepository;
    }

    @GetMapping
    public List<Match> index() {
        return this.matchRepository.findAll();
    }

    @PostMapping
    public Match create(@RequestBody MatchForm matchForm) {
        Ficha fichaDoador = this.fichaRepository.findById(matchForm.getPacienteDoador()).orElseThrow(ResourceNotFoundException::new);
        Ficha fichaReceptor = this.fichaRepository.findById(matchForm.getPacienteReceptor()).orElseThrow(ResourceNotFoundException::new);

        Match match = new Match(
                matchForm.getNomeFuncionario(),
                matchForm.getStatus(),
                matchForm.getDataGravacao(),
                matchForm.getDataAtualizacao(),
                matchForm.getGrauParentesco(),
                fichaDoador,
                fichaReceptor
                );

        this.matchRepository.save(match);
        return match;
    }


}
