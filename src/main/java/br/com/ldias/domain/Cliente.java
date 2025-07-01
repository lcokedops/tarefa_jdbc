package br.com.ldias.domain;

public class Cliente {
	
	private Long id;
	
	private String codigo;
	
	private String nome;
	
	public Cliente() {
		
	}
	
	public Cliente(Long id, String nome, String codigo) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
