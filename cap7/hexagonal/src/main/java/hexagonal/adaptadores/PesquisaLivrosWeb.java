package hexagonal.adaptadores;

import io.javalin.Javalin;
import hexagonal.dominio.PesquisaLivros;

// Adaptador Web usando Javalin
public class PesquisaLivrosWeb {
    private PesquisaLivros pesq;

    public PesquisaLivrosWeb(PesquisaLivros pesq) {
        this.pesq = pesq;
    }

    public void start() {
        // criando e configurando o servidor javalin
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/static");
        }).start(4567);

        // rota principal
        app.get("/", ctx -> {
            ctx.redirect("/index.html");
        });

        // Rota de Pesquisa (API)
        app.get("/pesquisa", ctx -> {
            String autor = ctx.queryParam("autor");

            // Mantive a lógica original do Spark: chamar o toString() do objeto.
            // Se fosse pra produção, talvez fosse melhor usar ctx.json() aqui.
            Object resultado = pesq.pesquisaPorAutor(autor);
            // Javalin exige resposta explícita, não só retornar o objeto
            ctx.result(String.valueOf(resultado));
        });

        System.out.println("Javalin rodando em http://localhost:4567");
    }
}