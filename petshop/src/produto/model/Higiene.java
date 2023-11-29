package produto.model;

public class Higiene extends Produto {

	private String sabonete;

	public Higiene(int tipo, int id, String nome, float preco, String sabonete) {
		super(tipo, id, nome, preco);
		this.sabonete = sabonete;
	}

	public String getSabonete() {
		return sabonete;
	}

	public void setSabonete(String sabonete) {
		this.sabonete = sabonete;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(" Sabonete: " + this.getSabonete());
	}

}
