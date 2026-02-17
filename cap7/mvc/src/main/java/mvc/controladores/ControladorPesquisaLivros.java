package mvc.controladores;

import io.javalin.Javalin; // Importação nova
import io.javalin.http.Context; // O objeto que substitui req e res
import mvc.modelo.*;
import mvc.visao.*;

public class ControladorPesquisaLivros {
    private ServicoPesquisaLivros pesq;
    private PaginaDadosLivro pagina;

    public ControladorPesquisaLivros(ServicoPesquisaLivros pesq, PaginaDadosLivro pagina) {
        this.pesq = pesq;
        this.pagina = pagina;
    }

    public void start() {
        // Migração para Javalin: Diferente do Spark, a config de estáticos
        // é feita na criação da instância, não globalmente.
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/static"); // Pasta de arquivos HTML/CSS/JS
        }).start(4567); // A porta vai aqui no final


        // No Spark era: get("/", (req, res) -> { ... });
        app.get("/", ctx -> {
            ctx.redirect("/index.html");
        });


        app.get("/pesquisa", ctx -> {
            // O Javalin unifica req e res no 'ctx' (Context).
            // Pegando o parâmetro da URL:
            String autor = ctx.queryParam("autor");

            Livro livro = pesq.pesquisaPorAutor(autor);

            // Lógica de proteção (caso não ache o livro)
            if (livro != null) {
                // Nota: O método não retorna String como no Spark.
                // Tenho que "empurrar" o HTML pro contexto usando .html()
                String htmlResultado = pagina.exibeLivro(livro.getTitulo(), livro.getAutor(), livro.getISBN());
                ctx.html(htmlResultado);
            } else {
                ctx.result("Livro não encontrado para o autor: " + autor);
            }
        });

        System.out.println("Javalin rodando em http://localhost:4567");
    }
}

//