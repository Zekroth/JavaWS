package bottleExcercise;

public class Bottle {
	public int quantita;
	public String contenuto;
	
	public Bottle(int q, String name) {
		this.quantita = q;
		this.contenuto = name;
	}
	
	public Bottle Togli(int n) {
		this.quantita = quantita - n;
		return this;
	}
	public Bottle Metti(int n){
		this.quantita = quantita + n;
		return this;
	}
	public Bottle Metti(int n, String nome) throws Exception {
		if(this.quantita == 0 ) {
			this.quantita = n;
			this.contenuto = nome;
		}else {
			throw new Exception("Non puoi mettere un liquido diverso da quello già presente nella bottiglia");
		}
		return this;
	}
}
