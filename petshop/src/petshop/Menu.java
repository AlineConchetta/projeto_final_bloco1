package petshop;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import petshop.controller.PetshopController;
import produto.model.Alimentos;
import produto.model.Higiene;
import produto.model.Produto;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0, idProduto, tipo;
		String nome, racao, sabonete;
		float preco;
		
		PetshopController produtos = new PetshopController();
		
		while (true) {
			System.out.println("-------------------------------------");
			System.out.println("               PetShop               ");
			System.out.println("-------------------------------------");
			System.out.println("       1 - Cadastrar produto         ");
			System.out.println("        2 - Listar produtos          ");
			System.out.println("     3 - Pesquisar produto por Id    ");
			System.out.println("       4 - Atualizar produto         ");
			System.out.println("        5 - Remover produto          ");
			System.out.println("              6 - Sair               ");
			System.out.println("-------------------------------------");
			System.out.println("Insira opção desejada:               ");

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException e) {
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("Cadastrar um produto");
				System.out.print("Digite o nome do produto");
				leia.skip("\\R");
				nome = leia.nextLine();

				System.out.print("Digite o tipo do produto: 1 Alimentos | 2 Higiene");

				do {
					tipo = leia.nextInt();
				} while (tipo < 1 || tipo > 2);

				System.out.print("Digite o valor do produto: ");
				preco = leia.nextFloat();

				leia.nextLine();
				
				switch (tipo) {

				case 1 -> {

					System.out.print("Digite o sabor: ");
					racao = leia.nextLine();
					produtos.cadastrarProduto(new Alimentos(produtos.gerarId(), tipo, nome, preco, racao));

				}
				case 2 -> {

					System.out.print("Digite o nome do sabonete: ");
					sabonete = leia.nextLine();
					produtos.cadastrarProduto(new Higiene(produtos.gerarId(), tipo, nome, preco, sabonete));
				}
				}

				keyPress();
				break;
			}
			case 2 -> {
				System.out.println("Listar todos os produtos.");
				
				produtos.listarProdutos();

				keyPress();
				break;
			}
			case 3 -> {
				System.out.println("Pesquisar produto por número/ID");

				System.out.print("Digite o id do produto: ");
				idProduto = leia.nextInt();
				produtos.pesquisarPorNumero(idProduto);
				
				keyPress();
				break;
			}

			case 4 -> {
				System.out.println("Atualizar produto");
				
				System.out.print("Digite o código do produto: ");
				idProduto = leia.nextInt();
				
				Optional<Produto> produto = produtos.percorrerLista(idProduto);
				
				if(produto.isPresent()) {
					
					System.out.print("Digite o nome do produto: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					tipo = produto.get().getTipo();

					switch (tipo) {
					case 1 ->{ System.out.print("Digite o valor do produto: ");
					preco = leia.nextFloat();
					
					System.out.print("Digite o nome da ração: ");
					leia.skip("\\R");
					racao = leia.nextLine();
					
					produtos.atualizarProduto(new Alimentos(idProduto, tipo, nome, preco, racao));
					
					}
					case 2 -> { System.out.print("Digite o valor do produto: ");
					preco = leia.nextFloat();
					
					System.out.print("Digite o nome do sabonete: ");
					sabonete = leia.nextLine();
					
					produtos.atualizarProduto(new Higiene(idProduto, tipo, nome, preco, sabonete));
					}
					}					
			
				}else
					System.out.println("Produto não encontrado");
				

				keyPress();
				break;
			}

			case 5 -> {
				System.out.println("Remover produto");
				
				System.out.print("Digite o Id do produto: ");
				idProduto = leia.nextInt();
				produtos.removerProduto(idProduto);

				keyPress();
				break;
			}
			case 6 -> {
				System.out.println("Encerrar atendimento");

				
				sobre();
				System.exit(0);
				keyPress();
				break;
			}

			default -> {
				System.out.println("Opção inválida.");

				keyPress();
				break;
			}
			}
		}
	}

	public static void sobre() {

		System.out.println("                                                        ");
		System.out.println("********************************************************");
		System.out.println(" Projeto Petshop desenvolvido por: Aline Conchetta      ");
		System.out.println(" Aline Conchetta - alineconchetta@gmail.com             ");
		System.out.println(" GitHub: github.com/AlineConchetta                      ");
		System.out.println("********************************************************");

	}

	public static void keyPress() {

		try {
			System.out.println("\n\n  ***  Pressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!!");
		}
	}

}