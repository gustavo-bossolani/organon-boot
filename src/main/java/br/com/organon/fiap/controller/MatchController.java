package br.com.organon.fiap.controller;

import br.com.organon.fiap.entity.Ficha;
import br.com.organon.fiap.entity.Match;
import br.com.organon.fiap.exception.ResourceNotFoundException;
import br.com.organon.fiap.forms.MatchByFichaIdForm;
import br.com.organon.fiap.forms.MatchForm;
import br.com.organon.fiap.repository.FichaRepository;
import br.com.organon.fiap.repository.MatchRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("matchs")
public class MatchController {

    private MatchRepository matchRepository;
    private FichaRepository fichaRepository;

    public MatchController(MatchRepository matchRepository, FichaRepository fichaRepository) {
        this.matchRepository = matchRepository;
        this.fichaRepository = fichaRepository;
    }

    @PostMapping
    public Match create(@RequestBody MatchForm matchForm) {
        Ficha fichaDoador = this.fichaRepository.findById(matchForm.getPacienteDoador()).orElseThrow(ResourceNotFoundException::new);
        Ficha fichaReceptor = this.fichaRepository.findById(matchForm.getPacienteReceptor()).orElseThrow(ResourceNotFoundException::new);

        if(fichaDoador.getId() == fichaReceptor.getId()) {
            throw new IllegalArgumentException("Um doador não pode receber orgãos dele mesmo");
        }
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

    @GetMapping("")
    public Match getMatchByFichaId(@RequestBody MatchByFichaIdForm form) {

        Ficha ficha = this.fichaRepository.findById(form.getId()).orElseThrow(ResourceNotFoundException::new);

        System.out.println(form.getId());
        System.out.println(form.getTipoFicha());

        Match match;
        if (form.getTipoFicha() == 1) {
            match = this.matchRepository.findByPacienteDoadorId(form.getId()).orElseThrow(ResourceNotFoundException::new);
        } else {
            match = this.matchRepository.findByPacienteReceptorId(form.getId()).orElseThrow(ResourceNotFoundException::new);
        }
        return match;
    }


}
