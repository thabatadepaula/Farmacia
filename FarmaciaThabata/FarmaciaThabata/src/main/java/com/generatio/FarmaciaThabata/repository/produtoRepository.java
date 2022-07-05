package com.generatio.FarmaciaThabata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generatio.FarmaciaThabata.model.produto;

public interface produtoRepository extends JpaRepository<produto, Long> {
	public List<produto> findAllByNomeContainingIgnoreCase(String nome);

}
