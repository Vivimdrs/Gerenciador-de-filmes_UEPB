package Atividade01pt1;
import java.util.ArrayList;
import java.util.List;

public class Busca implements Busca_IF{
    
    @Override
    public List<Filme> BuscaLinearIterativa(Filme[] filmes, int nota) throws NotaNegativaException{
        if(nota < 0){
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        List<Filme>filmesEncontrados = new ArrayList<>();
        for(Filme filme: filmes){
            if(filme.getNota() == nota){
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }
    @Override
    public List<Filme> BuscaLinearRecursiva(Filme[] filmes, int nota, int pos) throws NotaNegativaException{
        if(nota < 0){
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        List<Filme> filmesEncontrados = new ArrayList<>();
        if(pos>= filmes.length){
            return filmesEncontrados;
        }
        if(filmes[pos].getNota() == nota){
            filmesEncontrados.add(filmes[pos]);
        }
        filmesEncontrados.addAll(BuscaLinearRecursiva(filmes, nota, pos+1));
        return filmesEncontrados;
    }
    @Override
    public List<Filme> BuscaBinariaIterativa(Filme[] filmes, int nota) throws NotaNegativaException{
        if(nota < 0){
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        List<Filme> filmesEncontrados = new ArrayList<>();
        
    }
}
