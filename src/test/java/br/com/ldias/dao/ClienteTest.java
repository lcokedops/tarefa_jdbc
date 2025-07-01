package br.com.ldias.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.ldias.dao.generic.jdbc.dao.ClienteDao;
import br.com.ldias.dao.generic.jdbc.dao.IClienteDao;
import br.com.ldias.domain.Cliente;

public class ClienteTest {
	private IClienteDao clienteDao;
	
	@Test
	public void cadastrarTest() throws Exception {
		clienteDao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Leonardo Dias");
		Integer countCad = clienteDao.cadastrar(cliente);
		Assert.assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDao.buscar("10");
		Assert.assertNotNull(clienteBD);
		Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDao.excluir(clienteBD);
		Assert.assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTest() throws Exception {
		clienteDao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Leonardo Dias");
		Integer countCad = clienteDao.cadastrar(cliente);
		Assert.assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDao.buscar("10");
		Assert.assertNotNull(clienteBD);
		Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDao.excluir(clienteBD);
		Assert.assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest() throws Exception {
		clienteDao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Leonardo Dias");
		Integer countCad = clienteDao.cadastrar(cliente);
		Assert.assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDao.buscar("10");
		Assert.assertNotNull(clienteBD);
		Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDao.excluir(clienteBD);
		Assert.assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		clienteDao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Leonardo Dias");
		Integer countCad = clienteDao.cadastrar(cliente);
		Assert.assertTrue(countCad == 1);
		
		Cliente clientes = new Cliente();
		clientes.setCodigo("20");
		clientes.setNome("Nome Teste");
		Integer countCad2 = clienteDao.cadastrar(clientes);
		Assert.assertTrue(countCad2 == 1);
		
		List<Cliente> list = clienteDao.buscarTodos();
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		
		int countDel = 0;
		for (Cliente cli : list) {
			clienteDao.excluir(cli);
			countDel++;
		}
		Assert.assertEquals(list.size(), countDel);
		
		list = clienteDao.buscarTodos();
		Assert.assertEquals(list.size(), 0);
		
	}
	
	@Test
	public void atualizarTest() throws Exception {
		clienteDao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Leonardo Dias");
		Integer countCad = clienteDao.cadastrar(cliente);
		Assert.assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDao.buscar("10");
		Assert.assertNotNull(clienteBD);
		Assert.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assert.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		clienteBD.setCodigo("20");
		clienteBD.setNome("Nome 2");
		Integer countUpdate = clienteDao.atualizar(clienteBD);
		Assert.assertTrue(countUpdate == 1);
		
		Cliente clienteBD1 = clienteDao.buscar("10");
		Assert.assertNull(clienteBD1);
		
		Cliente clienteBD2 = clienteDao.buscar("20");
		Assert.assertNotNull(clienteBD2);
		Assert.assertEquals(clienteBD.getId(), clienteBD2.getId());
		Assert.assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
		Assert.assertEquals(clienteBD.getNome(), clienteBD2.getNome());
		
		List<Cliente> list = clienteDao.buscarTodos();
		for (Cliente cli : list) {
			clienteDao.excluir(cli);
		}
	}
	
}
