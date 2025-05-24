
public class VideoService {
	public void curtir(Video video) {
		video.likes++;
	}

	public void comentar(Video video, String comentario) {
		video.comentarios.add(comentario);
	}
}
