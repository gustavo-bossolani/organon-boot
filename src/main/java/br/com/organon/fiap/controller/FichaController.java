package br.com.organon.fiap.controller;

import br.com.organon.fiap.entity.Ficha;
import br.com.organon.fiap.exception.ResourceNotFoundException;
import br.com.organon.fiap.forms.FichaForm;
import br.com.organon.fiap.repository.FichaRepository;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("fichas")
public class FichaController {

    private FichaRepository fichaRepository;

    public FichaController(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    @GetMapping
    public List<Ficha> index() {
        return this.fichaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ficha create(@RequestBody FichaForm fichaForm) {
        Ficha ficha = new Ficha(
                fichaForm.getTipoCadastro(),
                fichaForm.getTipoSanguineo(),
                fichaForm.getPeso(),
                fichaForm.getIdade(),
                fichaForm.getPeso());
        this.fichaRepository.save(ficha);
        return ficha;
    }

    @GetMapping("{id}")
    public Ficha getOne(@NotNull @PathVariable int id) {
        Ficha ficha = this.fichaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ficha;
    }

}
