/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.projeto_produtos.gui;


import br.com.map.projeto_produtos.dao.ProdutoDao;
import br.com.map.projeto_produtos.model.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Samaronia
 */
public class AtividadeProdutos {

    public static void main(String[] args) throws SQLException {
            Scanner input = new Scanner(System.in);
            Produto p;
            String op;
            int codigo;
            ProdutoDao dao = new ProdutoDao();
            List<Produto> list;
            
            do{
                System.out.println("------------------ MENU -----------------------");
                System.out.println("(1)- CADASTRAR ");  
                System.out.println("(2)- EDITAR ");
                System.out.println("(3)- BUSCAR POR CODIGO");
                System.out.println("(4)- LISTAR TODOS PRODUTOS ");
                System.out.println("(5)- EXCLUIR ");
                System.out.println("(6)- SAIR");
                
                op= input.nextLine();
                System.out.println("opcao escolhida: "+ op);
                
                switch(op) {
                    case "1":
                        p = new Produto();
                        
                        System.out.println("---------------- CADASTRAR ----------------------");
                        System.out.println(" Nome produto:");
                        p.setNome_produto(input.nextLine());
                        
                        System.out.println("Preço :");
                        p.setPreco_produto(input.nextFloat());
                        input.nextLine();
                        
                        System.out.println("Marca:");
                        p.getEspecificacao().setMarca(input.nextLine());
                        
                        System.out.println("Sistema operacional: ");
                        p.getEspecificacao().setSistemaOpe(input.nextLine());
                        
                        System.out.println("Cor: ");
                        p.getEspecificacao().setCor(input.nextLine());
                        System.out.println("detalhes:");
                        p.getEspecificacao().setDetalhes(input.nextLine());
                        
                        dao.inserir(p);
                        break;
                        
                    case "2":
                        System.out.println("-------------- EDITAR ----------------------------");
                        System.out.println("Qual codigo do produto para edição:");
                        codigo = Integer.parseInt(input.nextLine());
                        
                        p = dao.buscarPorCodigo(codigo);
                        if(p != null)
                        {
                            System.out.println("Produto encontrado: "+ p);
                            System.out.println("novo nome: ");
                            p.setNome_produto(input.nextLine());
                            System.out.println("novo preço: ");
                            p.setPreco_produto(Float.parseFloat(input.nextLine()));
                            System.out.println("nova Marca:");
                            p.getEspecificacao().setMarca(input.nextLine());
                        
                            System.out.println("novo Sistema operacional: ");
                            p.getEspecificacao().setSistemaOpe(input.nextLine());
                        
                            System.out.println("nova Cor: ");
                            p.getEspecificacao().setCor(input.nextLine());
                            System.out.println("novo detalhes:");
                            p.getEspecificacao().setDetalhes(input.nextLine());
                            
                            
                            dao.editar(p);
                            System.out.println("Registro alterado com Sucesso!");
                        }
                        else
                            System.out.println("Registro não alterado ou não existe!");
                        break;
                    
                    case "3":
                        System.out.println("-------------BUSCAR POR CODIGO-------------------");
                        System.out.println("Qual Código quer consultar:");
                        codigo = Integer.parseInt(input.nextLine());
                        p = dao.buscarPorCodigo(codigo);
                        if(p!=null)
                            System.out.println(p);
                        else
                            System.out.println("Código de Produto não encontrado ou não existe!!!");
                        break;
                
                    case "4":
                        System.out.println("-------------LISTAR PRODUTOS-------------------");
                        list = dao.listar();
                        if(list!=null)
                        {
                            for (Produto pr : list)
                                System.out.println(pr);
                        }
                        else
                            System.out.println("Sem produtos para listar.....");
                        break;
                        
                    case "5":
                        System.out.println("-------------------EXCLUIR----------------------");
                        System.out.println("digite o codigo do produto que deseja excluir:");
                        codigo = Integer.parseInt(input.nextLine());
                        p = dao.buscarPorCodigo(codigo);
                        if(p != null){
                            dao.excluir(p);
                            System.out.println("produto "+p.getNome_produto()+" , excluido");
                        }
                        else
                            System.out.println("Produto nao existe ou nao excluido!!");
                        break;
                        
                    case "6":
                        System.out.println("saindo....");
                        break;
                    default:
                        System.out.println("    entrada inválida!");
                        
                }
                
            } while(!op.equals("6"));
        
    }
    
}
