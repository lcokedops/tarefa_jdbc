package br.com.ldias.dao.generic.jdbc.dao;

import java.util.List;

import br.com.ldias.domain.Produto;

public interface IProdutoDao {
	public Integer cadastrar(Produto produto) throws Exception;
	
	public Integer atualizar(Produto produto) throws Exception;
	
	public Produto buscar(String codigo) throws Exception;
	
	public List<Produto> buscarTodos() throws Exception;
	
	public Integer excluir(Produto produto) throws Exception;
}
