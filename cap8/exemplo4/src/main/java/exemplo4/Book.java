/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de mocks - Seção 8.6
*
*/

public class Book {

  String titulo;

  public Book(String titulo) {
    this.titulo = titulo;
  }

  public String getTitulo() {
    return titulo;
  }
}