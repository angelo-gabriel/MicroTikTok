
public class VideoViewer {
	public void exibir(Video video) {
		System.out.println("Título: " + video.titulo + " - Autor: " + video.autor.nome + " - Likes: " + video.likes);
		System.out.println("Comentários:");
		for (String c : video.comentarios) {
			System.out.println("- " + c);
		}
	}
}