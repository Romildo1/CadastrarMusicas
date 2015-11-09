
package acervo;

/**
 *
 * @author romildo
 */
public class Musica {
    private String nome;
    private int nota;
    private float duracao;

    public Musica(String nome, int nota, float duracao) {
        this.nome = nome;
        this.nota = nota;
        this.duracao = duracao;
    }

    
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getNota() {
        return nota;
    }

   
    public void setNota(int nota) {
        this.nota = nota;
    }

    
    public float getDuracao() {
        return duracao;
    }

    
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
    
    public void ListaMusica(){
        System.out.println("Nome "+nome);
        System.out.println("Tempo "+duracao);
    }

   
}
