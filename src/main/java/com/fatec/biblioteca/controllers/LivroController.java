package com.fatec.biblioteca.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.fatec.biblioteca.controllers.dtos.LivroDto;
import com.fatec.biblioteca.controllers.forms.LivroForm;
import com.fatec.biblioteca.models.Livro;
import com.fatec.biblioteca.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public List<LivroDto> list(){
        List<Livro> livros = livroRepository.findAll();
        return LivroDto.converter(livros);
    }


    // @PostMapping
	// @Transactional
	// @CacheEvict(value = "listaDeTopicos", allEntries = true)
	// public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
	// 	Topico topico = form.converter(cursoRepository);
	// 	topicoRepository.save(topico);
		
	// 	URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
	// 	return ResponseEntity.created(uri).body(new TopicoDto(topico));
	// }
	

    @PostMapping
    @Transactional
    public LivroDto post(@RequestBody LivroForm form, UriComponentsBuilder uriBuilder) {
        Livro livro = form.converter();
		livroRepository.save(livro);

        return new LivroDto(livro);
    }
    

    
}
