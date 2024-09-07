package schemas;

public class Filme implements Comparable<Filme> {
    private String nome;
    private int nota;
    private int ano;

    public Filme(String nome, int nota, int ano){
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }
    public int getAno(){
        return ano;
    }
    public int getNota(){
        return nota;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    @Override
    public int compareTo(Filme outro) {
        if (this.nota != outro.nota) {
            return Integer.compare(outro.nota, this.nota); 
        }
        else if (this.ano != outro.ano) {
            return Integer.compare(this.ano, outro.ano); 
        }
        else {
            return this.nome.compareTo(outro.nome); 
        }
    }

    @Override
    public String toString(){
        return
               nome + "("+ano+")" + "["+nota+"]";
    }
}   