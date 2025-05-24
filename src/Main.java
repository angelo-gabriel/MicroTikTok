import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserService();
		VideoService videoService = new VideoService();
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		int autorId = 1;
		List<Video> listaVideos = new ArrayList<>();

		do {
			exibeMenu();
			System.out.println("Escolha uma opção");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				User admin = new Admin(autorId, "admin");
				userService.imprimeDados(admin);
				autorId++;
				break;
			case 2:
				String videoTitulo;
				String videoAutor;

				System.out.println("Insira o titulo do vídeo: ");
				videoTitulo = sc.nextLine();
				System.out.println("Insira o nome do autor: ");
				videoAutor = sc.nextLine();

				Video novoVideo = new Video(videoTitulo, new Visitante(autorId, videoAutor));
				listaVideos.add(novoVideo);
				autorId++;
				break;
			case 3:
				System.out.println("Lista de vídeos publicados: ");
				for (Video v : listaVideos) {
					v.exibeVideo();
				}
				break;
			case 4:
				if (listaVideos.isEmpty()) {
					System.out.println("Nenhum vídeo disponível.");
					break;
				}
				System.out.println("Escolha o número do vídeo para curtir:");
				for (int i = 0; i < listaVideos.size(); i++) {
					System.out.println(i + ": " + listaVideos.get(i).titulo);
				}
				int idxCurtir = sc.nextInt();
				sc.nextLine();
				if (idxCurtir >= 0 && idxCurtir < listaVideos.size()) {
					Video videoSelecionado = listaVideos.get(idxCurtir);
					videoService.curtir(videoSelecionado);
					System.out.println("Vídeo curtido!");
				} else {
					System.out.println("Índice inválido.");
				}
				break;

			case 5:
				if (listaVideos.isEmpty()) {
					System.out.println("Nenhum vídeo disponível.");
					break;
				}
				
				System.out.println("Escolha o número do vídeo para comentar:");
				for (int i = 0; i < listaVideos.size(); i++) {
					System.out.println(i + ": " + listaVideos.get(i).titulo);
				}
				int idxComentario = sc.nextInt();
				
				sc.nextLine();
				
				if (idxComentario >= 0 && idxComentario < listaVideos.size()) {
					System.out.println("Digite seu comentário:");
					String comentario = sc.nextLine();
					
					listaVideos.get(idxComentario).comentarios.add(comentario);
					System.out.println("Comentário adicionado!");
				} else {
					System.out.println("Índice inválido.");
				}
				break;
			case 6:
				System.out.println("Encerrando.....");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 6);

		sc.close();
	}

	public static void exibeMenu() {
		System.out.println("\nHOMEPAGE:");
		System.out.println("1: criar usuario");
		System.out.println("2: adicionar video");
		System.out.println("3: visualizar vídeos");
		System.out.println("4: curtir video");
		System.out.println("5: comentar");
		System.out.println("6: sair");
	}

}
