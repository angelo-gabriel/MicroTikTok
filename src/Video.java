import java.util.ArrayList;
import java.util.List;

public class Video {
	String titulo;
	User autor;
	int likes;
	List<String> comentarios;
	
	Video(String titulo, User autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.comentarios = new ArrayList<>();
	}
	
	void exibeVideo() {
		System.out.println("Vídeo: " + titulo + " Autor: " + autor.nome + "\nLikes: " + likes);
	}
}
