package com.example.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Empresa;

@Repository
public interface EmpresaRepository 
        extends JpaRepository<Empresa, Long> {
		
	@Query("SELECT p FROM Empresa p WHERE p.nome = ?1 or p.cnpj = ?2")
	List<Empresa> listarPorNomeOuCnpj(String nome, String cnpj);
}