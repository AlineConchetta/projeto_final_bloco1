package petshop;

import java.io.IOException;
import java.util.Scanner;

public class menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0, idProduto, tipo;
		String nome, alimentos, higiene;
		float preco;

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

			opcao = leia.nextInt();

			switch (opcao) {
			case 1 -> {
				System.out.println("Cadastrar um produto");

				keyPress();
				break;
			}
			case 2 -> {
				System.out.println("Listar todos os produtos.");

				keyPress();
				break;
			}
			case 3 -> {
				System.out.println("Pesquisar produto por número/ID");

				keyPress();
				break;
			}

			case 4 -> {
				System.out.println("Atualizar produto");

				keyPress();
				break;
			}

			case 5 -> {
				System.out.println("Remover produto");

				keyPress();
				break;
			}
			case 6 -> {
				System.out.println("Encerrar atendimento");

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