package com.generatio.FarmaciaThabata.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generatio.FarmaciaThabata.model.produto;
import com.generatio.FarmaciaThabata.repository.produtoRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("/produto")

public class produtoController {
	@Autowired
	private produtoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<produto>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<produto> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	
	@PostMapping
	public ResponseEntity<produto> inserirProduto(@RequestBody produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		
	}
	
	@PutMapping
	public ResponseEntity<produto> atualizarProduto( @RequestBody produto produto){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(produto));
		
	}
	
	@DeleteMapping("/{id}")
	public  void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}