package Atividade01pt1;

public class Busca implements Busca_IF{  

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes){
        for(int i = 0; i<filmes.length-1; i++){
            if(filmes[i].getNota() > filmes[i+1].getNota()){
                return true;
            }else if (filmes[i].getAno() < filmes[i+1].getAno()) {
                return true;
            }else if(filmes[i].getNome().compareTo(filmes[i+1].getNome()) < 0){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Filme BuscaLinearIterativa(Filme[] filmes, int nota) throws NotaNegativaException{
        if(nota < 0){
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        for(Filme filme: filmes){
            if(filme.getNota() == nota){
                return filme;
            }
        }
        return null;
    }
    @Override
    public Filme BuscaLinearRecursiva(Filme[] filmes, int nota, int pos) throws NotaNegativaException{
        if(nota < 0){
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        if(pos >= filmes.length){
            return null;
        }
        if(filmes[pos].getNota() == nota){
            return filmes[pos];
        }
        return BuscaLinearRecursiva(filmes, nota, pos+1);
    }
    @Override
    public Filme BuscaBinariaIterativa(Filme[] filmes, int nota) throws NotaNegativaException{
        if(nota < 0){
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        int ladoEsquerdo = 0;
        int ladoDireito = filmes.length -1;
        while (ladoEsquerdo <= ladoDireito) {
            int meio = ladoEsquerdo + (ladoDireito - ladoEsquerdo)/2;
            if(filmes[meio].getNota() == nota){
               return filmes[meio];
            }
            if (filmes[meio].getNota() < nota) {
                ladoEsquerdo = meio+1;
            }else{
                ladoDireito = meio-1;
            }

        }
        return null;

    }
    @Override
    public Filme BuscaBinariaRecursiva(Filme[] filmes, int nota) throws NotaNegativaException {
        if (nota < 0) {
            throw new NotaNegativaException("Nota não pode ser negativa");
        }
        return buscaBinariaRecursiva(filmes, nota, 0, filmes.length - 1);
    }
    private Filme buscaBinariaRecursiva(Filme[] filmes, int nota, int ladoEsquerdo, int ladoDireito) {
        if (ladoEsquerdo > ladoDireito) {
            return null;
        }
        
        int meio = ladoEsquerdo + (ladoDireito - ladoEsquerdo) / 2;
        
        if (filmes[meio].getNota() == nota) {
            return filmes[meio];
        } 
        
        if (filmes[meio].getNota() > nota) {
            return buscaBinariaRecursiva(filmes, nota, ladoEsquerdo, meio - 1);
        } else {
            return buscaBinariaRecursiva(filmes, nota, meio + 1, ladoDireito);
        }
    }

}
