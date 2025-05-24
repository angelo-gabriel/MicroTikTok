public class Admin extends User {
    Admin(int id, String nome) {
        super(id, nome);
    }

    void imprimeDados() {
        System.out.println("Admin: " + nome);
    }
}
