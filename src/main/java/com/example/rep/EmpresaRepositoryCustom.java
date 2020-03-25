package com.example.rep;

import java.util.List;

import com.example.model.Empresa;

public interface EmpresaRepositoryCustom {
	

	List<Empresa> recuperarPorNomeOuEmailJPQL(String nome, String email);

}
