package produto.model;

public class Alimentos extends Produto{
	
	public String racao;

	public Alimentos(int tipo, int id, String nome, float preco, String racao) {
		super(tipo, id, nome, preco);
		this.racao = racao;
	}

	public String getRacao() {
		return racao;
	}

	public void setRacao(String racao) {
		this.racao = racao;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(" Racao: " + this.getRacao());
	}

}
	
