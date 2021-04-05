/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.dominio;

import br.newtonpaiva.PersistenceService;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author caioa
 */
public class ProdutoTest {
    public ProdutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //Executado uma única vez antes de todos os testes.
        EntityManager em = PersistenceService.getEntityManager();
        em.getTransaction().begin();
        
        Produto p1 = new Produto();
        p1.setNome("Teclado");
        p1.setPreco(143.99);
        Produto p2 = new Produto();
        p2.setNome("Placa Mãe");
        p2.setPreco(500.00);
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // 1 - Consultar disponibilidade do produto em estoque.
    //Produto não existente no estoque
    //Produto existente no estoque
    
    
    // 2- Consultar o produto a partir do Nome.
    //Produto não encontrado
    //Produto encontrado
    
    @Test
    public void testNaoEncontrarProdutoPorNome() {
        List<Produto> produtos = Produto.findByNome("Nome inexistente na base");
        Assert.assertTrue(produtos == null || produtos.isEmpty());
    }
    
    @Test
    public void testEncontrarProdutoPorNome() {
        List<Produto> produtos = Produto.findByNome("Teclado");
        Assert.assertTrue(produtos != null && !produtos.isEmpty());
    }
    
    // 5 - Criar testes para validar o método obterTotal()
    //Cenário de Sucesso conforme a regra onde o total é igual a soma do preço dos itens do pedido, somando o frete mais o icms.
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}