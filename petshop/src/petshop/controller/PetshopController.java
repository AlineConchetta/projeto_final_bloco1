package petshop.controller;

import java.util.ArrayList;
import java.util.Optional;

import petshop.repository.Repository;
import produto.model.Produto;

public class PetshopController implements Repository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	@Override
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto adicionado!");

	}

	@Override
	public void listarProdutos() {
		for (var p : listaProdutos) {
			p.visualizar();
		}

	}

	@Override
	public void pesquisarPorNumero(int id) {

		Optional<Produto> produto = percorrerLista(id);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.println("Produto não localizado");
	}

	@Override
	public void atualizarProduto(Produto produto) {

		var buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);

			System.out.println("\nDados do produto atualizado!");

		} else
			System.out.println("\nProduto não foi encontrado!");
	}

	public Optional<Produto> buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
		}
		return Optional.empty();
	}

	@Override
	public void removerProduto(int id) {

		Optional<Produto> produto = percorrerLista(id);
		
		if (produto.isPresent()) {
			if(listaProdutos.remove(produto.get())) {
				System.out.println("O produto " + id + " foi removido");}
		}else {
			System.out.println("Produto não encontrado");
		}
	}

	public int gerarId() {
		int idProduto = 0;
		return ++idProduto;
	}

	public Optional<Produto> percorrerLista(int id) {

		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return Optional.of(produto);

			}
		}

		return Optional.empty();

	}
}