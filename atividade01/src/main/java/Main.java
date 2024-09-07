import java.util.Random;

import exceptions.NotaNegativaException;
import schemas.Filme;
import utils.*;

public class Main {
    public static void main(String[] args) {
        
        int quantidade = 50;
        Filme[] filmes = gerarFilmes(quantidade);
        
        // ALGORITMOS DE ORDENAÇÃO
        Ordenacao ordem = new Ordenacao();
        ordem.BubbleSort(filmes);
        ordem.MergeSort(filmes, 0, filmes.length - 1);
        ordem.QuickSort(filmes, 0, filmes.length - 1);

        System.out.println("\nFilmes encontrados:");
        for (Filme filme : filmes) {
            System.out.println(filme);
        }

        // ALGORITMOS DE BUSCA
        int nota = 3;
        Busca busca = new Busca();
        boolean res = busca.checaVetorOrdenado(filmes);
        System.out.println("Vetor ordenado: " + res);
        Filme filmeProcurado;

        try {
            filmeProcurado = busca.BuscaLinearIterativa(filmes, nota);
            // filmeProcurado = busca.BuscaLinearRecursiva(filmes, nota, 0);
            // filmeProcurado = busca.BuscaBinariaIterativa(filmes, nota);
            // filmeProcurado = busca.BuscaBinariaRecursiva(filmes, nota);
            if (filmeProcurado != null) {
                System.out.println("Filme com a nota desejada: ");
                System.out.println(filmeProcurado);
            } else {
                System.out.println("Filme não encontrado");
            }
        } catch (NotaNegativaException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Filme[] gerarFilmes(int quantidade) {
        Filme[] filmes = new Filme[quantidade];
        Random random = new Random();

        String[] nomesFilmes = {
            "A origem ", "O jogo ", "O fim ", "Jogo ", "Batalha ", "A lenda ", "O mistério ", "O retorno ", "A aventura ", "A saga ", "O desafio ", "O enigma ", "A fuga "
        };
        String[] nomesFilmes2 = {
            "do planeta terra", "do nada", "dos perdidos", "dos macacos", "do dragão", "do faraó", "do guerreiro", "da montanha", "do espaço", "dos deuses", "da cidade perdida", "do tempo"
        };

        for (int i = 0; i < quantidade; i++) {
            String nome = nomesFilmes[random.nextInt(nomesFilmes.length)] + nomesFilmes2[random.nextInt(nomesFilmes2.length)];
            int nota = random.nextInt(5) + 1;
            int ano = random.nextInt(2024 - 1930) + 1930;

            filmes[i] = new Filme(nome, nota, ano);
        }
        return filmes;
    }
}
