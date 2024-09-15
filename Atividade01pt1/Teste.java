package Atividade01pt1;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Teste {
    public static void main(String[] args) throws NotaNegativaException {
        
        final int quantidade = 1000;
        Filme filmes [] = gerarFilmes(quantidade);

        
        //ALGORITMOS DE ORDENAÇÃO
        int nota = 3;
        Ordenacao ordem = new Ordenacao();
        //ALGORITMOS DE BUSCA
        Busca busca = new Busca();
        Filme filmeProcurado;

        try{
            long tempoInicial = System.nanoTime();
            //filmeProcurado = busca.BuscaLinearIterativa(filmes, nota);
            //filmeProcurado = busca.BuscaLinearRecursiva(filmes, nota, 0);
            //filmeProcurado = busca.BuscaBinariaIterativa(filmes, nota);
            filmeProcurado = busca.BuscaBinariaRecursiva(filmes, nota);
            long tempoFinal = System.nanoTime();
            double duracao = (tempoFinal - tempoInicial) /1000000000.0; // Converte para milissegundos
            System.out.println(duracao);
            if(filmeProcurado != null){
                System.out.println("Filme com a nota desejada: ");
                System.out.println(filmeProcurado);
            }else{
                System.out.println("Filme não encontrado");
            }
        } catch (NotaNegativaException e){
            System.err.println(e.getMessage());
        }
        // long tempoInicial = System.nanoTime();
        // Arrays.sort(filmes);
        // busca.BuscaBinariaIterativa(filmes, nota);
        // //ordem.BubbleSort(filmes);
        // //ordem.BubbleSort(filmes);
        
        // long tempoFinal = System.nanoTime();
        
        // double duracao = (tempoFinal - tempoInicial) /1000000000.0; // Converte para milissegundos
        // System.out.println("Tempo de execução: " + duracao + " ms");

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
            int ano = random.nextInt(1930, 2024);

            filmes[i] = new Filme(nome, nota, ano);
        }
        return filmes;
    }
    
}
