package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Empresa;
import com.example.rep.EmpresaRepository;
import com.example.rep.EmpresaRepositoryCustomImpl;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaDAO;
	
	@Autowired
	private EmpresaRepositoryCustomImpl empresaImplDAO;
	
	
	 public Empresa inserir(Empresa empresa) {
	        return empresaDAO.save(empresa);
	    }
	
	public List<Empresa> getAll() {
		return empresaDAO.findAll();
	}
	
	public List<Empresa> listarPaginado(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Empresa> resultadoPaginado = empresaDAO.findAll(paging);
		return resultadoPaginado.hasContent() ? resultadoPaginado.getContent() : new ArrayList<>();
	}
	
	public Empresa getById(Long id) throws Exception {
		return empresaDAO.findById(id).orElseThrow(() -> new Exception("Erro"));
	}
	
	public List<Empresa> listarPorNomeOuCnpj(String nome, String cnpj) {
		return empresaDAO.listarPorNomeOuCnpj(nome, cnpj);
	}
	
	public List<Empresa> recuperarPorNomeOuEmailJPQL(String nome, String email) {
		return empresaImplDAO.recuperarPorNomeOuEmailJPQL(nome, email);
	}
	
}
