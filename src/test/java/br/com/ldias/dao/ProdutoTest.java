package br.com.ldias.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.ldias.dao.generic.jdbc.dao.ClienteDao;
import br.com.ldias.dao.generic.jdbc.dao.IProdutoDao;
import br.com.ldias.dao.generic.jdbc.dao.ProdutoDao;
import br.com.ldias.domain.Cliente;
import br.com.ldias.domain.Produto;

public class ProdutoTest {
	private IProdutoDao produtoDao;
	
	@Test
	public void cadastrarTest() throws Exception {
		produtoDao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setNome("TV");
		produto.setCodigo("1");
		
		Integer countCad = produtoDao.cadastrar(produto);
		Assert.assertTrue(countCad == 1);
		
		Produto produtoBd = produtoDao.buscar("1");
		Assert.assertNotNull(produtoBd);
		Assert.assertEquals(produto.getNome(), produtoBd.getNome());
		Assert.assertEquals(produto.getCodigo(), produtoBd.getCodigo());
		
		Integer countDel = produtoDao.excluir(produtoBd);
		Assert.assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTest() throws Exception {
		produtoDao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("TV");
		Integer countCad = produtoDao.cadastrar(produto);
		Assert.assertTrue(countCad == 1);
		
		Produto produtoBd = produtoDao.buscar("1");
		Assert.assertNotNull(produtoBd);
		Assert.assertEquals(produto.getCodigo(), produtoBd.getCodigo());
		Assert.assertEquals(produto.getNome(), produtoBd.getNome());
		
		Integer countDel = produtoDao.excluir(produtoBd);
		Assert.assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest() throws Exception {
		produtoDao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("TV");
		Integer countCad = produtoDao.cadastrar(produto);
		Assert.assertTrue(countCad == 1);
		
		Produto produtoBd = produtoDao.buscar("1");
		Assert.assertNotNull(produtoBd);
		Assert.assertEquals(produto.getCodigo(), produtoBd.getCodigo());
		Assert.assertEquals(produto.getNome(), produtoBd.getNome());
		
		Integer countDel = produtoDao.excluir(produtoBd);
		Assert.assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		produtoDao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("TV");
		Integer countCad = produtoDao.cadastrar(produto);
		Assert.assertTrue(countCad == 1);
		
		Produto produto2 = new Produto();
		produto2.setCodigo("2");
		produto2.setNome("Celular");
		Integer countCad2 = produtoDao.cadastrar(produto2);
		Assert.assertTrue(countCad2 == 1);
		
		List<Produto> list = produtoDao.buscarTodos();
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		
		int countDel = 0;
		for (Produto prod : list) {
			produtoDao.excluir(prod);
			countDel++;
		}
		Assert.assertEquals(list.size(), countDel);
		
		list = produtoDao.buscarTodos();
		Assert.assertEquals(list.size(), 0);
		
	}
	
	@Test
	public void atualizarTest() throws Exception {
		produtoDao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("TV");
		Integer countCad = produtoDao.cadastrar(produto);
		Assert.assertTrue(countCad == 1);
		
		Produto produtoBd = produtoDao.buscar("1");
		Assert.assertNotNull(produtoBd);
		Assert.assertEquals(produto.getCodigo(), produtoBd.getCodigo());
		Assert.assertEquals(produto.getNome(), produtoBd.getNome());
		
		produtoBd.setCodigo("10");
		produtoBd.setNome("Nome Novo");
		Integer countUpdate = produtoDao.atualizar(produtoBd);
		Assert.assertTrue(countUpdate == 1);
		
		Produto produtoBd2 = produtoDao.buscar("100");
		Assert.assertNull(produtoBd2);
		
		Produto produtoBd3 = produtoDao.buscar("10");
		Assert.assertNotNull(produtoBd3);
		Assert.assertEquals(produtoBd.getId(), produtoBd3.getId());
		Assert.assertEquals(produtoBd.getCodigo(), produtoBd3.getCodigo());
		Assert.assertEquals(produtoBd.getNome(), produtoBd3.getNome());
		
		List<Produto> list = produtoDao.buscarTodos();
		for (Produto prod : list) {
			produtoDao.excluir(prod);
		}
	}
}
