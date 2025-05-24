
public abstract class User {
    int id;
    String nome;

    User(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    abstract void imprimeDados();
}
