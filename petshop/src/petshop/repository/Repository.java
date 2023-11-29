package petshop.repository;

import produto.model.Produto;

public interface Repository {
	
	//CRUD
		public void cadastrarProduto(Produto produto);
		public void listarProdutos();
		public void pesquisarPorNumero(int id);
		public void atualizarProduto(Produto produto);
		public void removerProduto(int in);	

	}
