
package acervo;

/**
 *
 * @author romildo
 */
public class Album {
      private String nome;
    private int ano;

    public Album(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public void ListaAlbum(){
        System.out.println("Nome "+nome);
        System.out.println("Ano "+ano);
    }
}

