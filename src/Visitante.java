
public class Visitante extends User {
	Visitante(int id, String nome) {
		super(id, nome);
	}

	void imprimeDados() {
		System.out.println("Visitante: " + nome);
	}
}
