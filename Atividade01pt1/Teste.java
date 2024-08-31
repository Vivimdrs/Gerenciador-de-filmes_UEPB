package Atividade01pt1;
import java.util.List;
import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        
        int quantidade = 50;
        Filme filmes [] = gerarFilmes(quantidade);
        
        //ALGORITMOS DE ORDENAÇÃO

        Ordenacao ordem = new Ordenacao();
        ordem.BubbleSort(filmes);
        //ordem.QuickSort(filmes, 0, 4);

        System.out.println("\nFilmes ordenados:");
        for (Filme filme : filmes) {
            System.out.println(filme);
        }

        //ALGORITMOS DE BUSCA

        int nota = 3;
        Busca busca = new Busca();
        List<Filme> notaBuscada;

        
		try {
			notaBuscada = busca.BuscaLinearIterativa(filmes, nota);
			//notaBuscada = busca.BuscaBinariaIterativa(filmes, nota);
			//notaBuscada = busca.BuscaLinearRecursiva(filmes, nota);
			//notaBuscada = busca.BuscaBinariaRecursiva(filmes, nota);
			if (notaBuscada != null) {
				System.out.println("\nFilmes encontrados com a nota desejada: ");
                for(Filme filme: notaBuscada){
                    System.out.println(filme);
                }
			} else {
				System.out.println("Filme não encontrado");
			}
		} catch (NotaNegativaException e) {
			System.err.println(e.getMessage());
		}
    }

    public static Filme[] gerarFilmes(int quantidade){
        Filme filmes [] = new Filme[quantidade];
        Random random = new Random();

        String [] nomesFilmes = {
            "A origem ", "O jogo ", "O fim ", "Jogo ","Batalha ", "A lenda ", "O mistério ", "O retorno ", "A aventura ", "A saga ", "O desafio ", "O enigma ", "A fuga "
        };
        String [] nomesFilmes2 = {
            "do planeta terra", "do nada", "dos perdidos", "dos macacos", "do dragão", "do faraó", "do guerreiro", "da montanha", "do espaço", "dos deuses", "da cidade perdida", "do tempo"
        };
        for(int i = 0; i<quantidade; i++){
            String nome = nomesFilmes[random.nextInt(nomesFilmes.length)] + nomesFilmes2[random.nextInt(nomesFilmes2.length)];
            int nota = random.nextInt(5) + 1;
            int ano = random.nextInt(2024 - 1990 + 1) - 1990;

            filmes[i] = new Filme(nome, nota, ano);
        }
        return filmes;
    }

}
