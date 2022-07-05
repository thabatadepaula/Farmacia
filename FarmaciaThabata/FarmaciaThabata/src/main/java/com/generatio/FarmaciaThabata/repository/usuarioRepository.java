package com.generatio.FarmaciaThabata.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generatio.FarmaciaThabata.model.usuario;

@Repository

public interface usuarioRepository extends JpaRepository<usuario, Long> {
	public List<usuario> findAllByNomeContainingIgnoreCase(String nome);

}
