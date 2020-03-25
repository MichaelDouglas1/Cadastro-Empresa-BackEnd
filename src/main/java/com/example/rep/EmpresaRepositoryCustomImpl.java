package com.example.rep;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.model.Empresa;

public class EmpresaRepositoryCustomImpl implements EmpresaRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<Empresa> recuperarPorNomeOuEmailJPQL(String nome, String cnpj) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p FROM Empresa p WHERE 1=1 ");
		
		if (Objects.nonNull(nome)) {
			sql.append(" AND p.nome = :nome ");
		}
		
		if (Objects.nonNull(cnpj)) {
			sql.append(" AND p.cnpj = :cnpj ");
		}
		
		TypedQuery<Empresa> query = em.createQuery(sql.toString(), Empresa.class);
		
		if (Objects.nonNull(nome)) {
			query.setParameter("nome", nome);
		}
		
		if (Objects.nonNull(cnpj)) {
			query.setParameter("cnpj", cnpj);
		}
		
		return query.getResultList();
	}

}
