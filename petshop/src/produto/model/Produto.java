package produto.model;

public abstract class Produto {
	
	private int tipo;
	private int id;
	private String nome;
	private float preco;
	
	
	public Produto(int tipo, int id, String nome, float preco) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch (this.tipo) {
		
		case 1 -> tipo = "Alimentos";
		case 2 -> tipo = "Higiene";
		}
		
		System.out.println("\n\n***********************************");
		System.out.println("           Dados do produto            ");
		System.out.println("***************************************");
		System.out.println(" ID do produto: " + this.id);
		System.out.println(" Nome do produto: " + this.nome);
		System.out.println(" Tipo do produto: " + tipo);
		System.out.printf(" Preço do produto: R$%.2f \n", this.preco);
	}

}
