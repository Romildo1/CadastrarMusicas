
package acervo;

/**
 *
 * @author romildo
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Principal {
      public static void main(String[] args) {  
        menu();
    }
    
    public static void menu() {        
        String opcao = null;
        String nome, ANO, DURACAO, monitor = "", ID, NOTA;
        int ano, id = 0, nota;
        float duracao;
        ResultSet res;
        
        do {
            opcao = JOptionPane.showInputDialog(
                    " 1 - Inserir Genero \n" +
                    " 2 - Inserir Artista \n" +
                    " 3 - Inserir Album \n" +
                    " 4 - Inserir Musica \n" +
                    " 5 - Busca por Album \n" +
                    " 6 - Busca por Artista \n" +
                    " 7 - Busca por Genero \n" +
                    " 8 - Busca por Musica \n"+
                    " 9 - Emitindo Relatório \n" +
                    "10 - Sair \n\n");
            
           switch ( opcao) {  
               case "1":
                   nome = JOptionPane.showInputDialog("Informe Nome do Genero: ");
                   Genero g = new Genero(nome);
                   Conexao.inserirGenero(g);
               break;  
                   
               case "2":
                   nome = JOptionPane.showInputDialog("Informe Nome do Artista: ");
                   ANO = JOptionPane.showInputDialog("Tempo de carreira: ");
                   ano = Integer.parseInt(ANO);
                   
                   res = Conexao.relatorioGenero();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +".";
                            }
                            ID = JOptionPane.showInputDialog(null, "Informe id Referente Artista"+monitor);
                            id = Integer.parseInt(ID);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao dos registros do Artista!");
			}
                    } else {
			System.out.println(" Problema no retorno do registro!");
                    }
                   Artista a = new Artista(nome, ano);
                   Conexao.inserirArtista(a,id);
                   monitor = "";
               break;  
                   
               case "3":
                   nome = JOptionPane.showInputDialog("Informe Nome do Album: ");
                   ANO = JOptionPane.showInputDialog("Informe Ano de Lançamento do Album: ");
                   ano = Integer.parseInt(ANO); 
                   
                   res = Conexao.relatorioArtista();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Duracão de Carreira: "+res.getInt("Tempo de carreira")
                                +".";
                            }
                            ID = JOptionPane.showInputDialog(null, "Informe  ID Artista que faz Referencia ao Album"+monitor);
                            id = Integer.parseInt(ID);
			} catch (SQLException e) {
                            System.out.println(" Problema na  exibicao dos registros do Artista!");
			}
                    } else {
			System.out.println("Problema no retorno do registro!");
                    }
                   Album c = new Album(nome, ano);
                   Conexao.inserirAlbum(c, id);
                   monitor = "";
               break;  
                   
               case "4":
                   nome = JOptionPane.showInputDialog("Informe Nome da Musica: ");
                   DURACAO = JOptionPane.showInputDialog("Informe a Duracão: ");
                   NOTA = JOptionPane.showInputDialog("Informe a Nota: ");
                   duracao = Float.parseFloat(DURACAO); 
                   nota = Integer.parseInt(NOTA);
                   
                   res = Conexao.relatorioAlbum();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Ano: "+res.getInt("ano")
                                +".";
                            }
                            ID = JOptionPane.showInputDialog(null, "Digite o ID Do Album que Faz Referencia a Musica"+monitor);
                            id = Integer.parseInt(ID);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao dos registros do Artista!");
			}
                    } else {
			System.out.println("Problema no retorno do registro!");
                    }
                   Musica m = new Musica(nome,nota,duracao);
                   Conexao.inserirMusica(m, id);
                   monitor = "";
               break;  
                   
               case "5":
                   nome = JOptionPane.showInputDialog("Pesquisando por Album: ");
                   res = Conexao.buscarAlbum(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Ano: "+res.getInt("ano")
                                +"\n Artista: "+res.getInt("artista")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, monitor);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao dos registros do album!");
			}
                    } else {
			System.out.println("Problema no retorno do registro!");
                    }
                   monitor = "";
               break;
                   
               case "6":  
                   nome = JOptionPane.showInputDialog("Pesquisando por Artista: ");
                   res = Conexao.buscarArtista(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Duração da carreira: "+res.getInt("Duração_da_carreira")
                                +"\n genero: "+res.getInt("artista")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, monitor);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao dos registros do artista!");
			}
                    } else {
			System.out.println("Problema no retorno do registro!");
                    }
                   monitor = "";
               break;  
                   
               case "7":  
                   nome = JOptionPane.showInputDialog("Pesquisando por Genero: ");
                   res = Conexao.buscarGenero(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, monitor);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao  do genero!");
			}
                    } else {
			System.out.println("Problema no retorno do registro!");
                    }
                   monitor = "";
               break;
               
               case "8": 
                   nome = JOptionPane.showInputDialog("Pesquisando por Musica: ");
                   res = Conexao.buscarMusica(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Duração: "+res.getInt("duracao")
                                +"\n Album: "+res.getInt("album")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, monitor);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao dos registros da musica!");
			}
                    } else {
			System.out.println("Problema no retorno do pesquisa!!");
                    }
                   monitor = "";
               break;
               
               case "9":
                  JOptionPane.showMessageDialog(null, "Relatorio Completo do Banco");
                   res = Conexao.relatorio();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                monitor = monitor
                                +"\n Musica: "+res.getString("Musica")
                                +"\n Album: "+res.getString("Album")
                                +"\n Artista: "+res.getString("Artista")
                                +"\n Genero: "+res.getString("Genero")
                                +"\n Nota: "+res.getString("Nota")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, monitor);
			} catch (SQLException e) {
                            System.out.println("Problema na  exibicao dos registros!");
			}
                    } else {
			System.out.println("Problema no retorno do registro!");
                    }
                   monitor = "";
               break;
                   
               case "10":
                   JOptionPane.showMessageDialog(null, "Sair" );
               break;
                   
               default:
                   JOptionPane.showMessageDialog(null, "Error" );
           }
       } while ( !"10".equals(opcao) );  
        
   }
}

