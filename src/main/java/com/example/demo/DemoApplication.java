package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Empresa;
import com.example.service.EmpresaService;

@SpringBootApplication(scanBasePackages = { "com.example.demo", "com.example.model", "com.example.rep",
		"com.example.service" })
@EntityScan("com.example.model")
@EnableJpaRepositories(basePackages = "com.example.rep", repositoryImplementationPostfix = "CustomImpl")
@RestController
@RequestMapping("/empresas")
public class DemoApplication {

	@Autowired
	private EmpresaService empresaService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	 @PostMapping
	    public ResponseEntity<Empresa> inserir(@RequestBody Empresa empresa) {
	        return new ResponseEntity<Empresa>(empresaService.inserir(empresa), new HttpHeaders(), HttpStatus.OK);
	    }

	@GetMapping
	public ResponseEntity<List<Empresa>> listarEmpresas() {
		return new ResponseEntity<List<Empresa>>(empresaService.getAll(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Empresa> deletar(@PathVariable Long id) {
        return new ResponseEntity<Empresa>(empresaService.deletar(id), new HttpHeaders(), HttpStatus.OK);
    }
	@GetMapping("/paginado")
	public ResponseEntity<List<Empresa>> listarEmpresas(
				@RequestParam(defaultValue = "0") Integer pageNo, 
	            @RequestParam(defaultValue = "10") Integer pageSize
			) {
		return new ResponseEntity<List<Empresa>>(empresaService.listarPaginado(pageNo, pageSize), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/filtro")
	public ResponseEntity<List<Empresa>> listarPorNomeOuCnpj(
				@RequestParam(defaultValue = "") String nome, 
	            @RequestParam(defaultValue = "") String cnpj
			) {
		return new ResponseEntity<List<Empresa>>(empresaService.listarPorNomeOuCnpj(nome, cnpj), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/filtroJPQL")
	public ResponseEntity<List<Empresa>> recuperarPorNomeOuEmailJPQL(
				@RequestParam(required = false) String nome, 
	            @RequestParam(required = false) String cnpj
			) {
		return new ResponseEntity<List<Empresa>>(empresaService.recuperarPorNomeOuEmailJPQL(nome, cnpj), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> recuperarPorId(@PathVariable("id") Long id) throws Exception {
		return new ResponseEntity<Empresa>(empresaService.getById(id), new HttpHeaders(), HttpStatus.OK);
	}

}
