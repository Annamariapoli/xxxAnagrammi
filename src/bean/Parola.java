package bean;

public class Parola {
	
	private int id;
	private String nome;
	public Parola(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	


	public String toString(){
		String r ;
		r=nome+" \n";
		return r;
	}
}
