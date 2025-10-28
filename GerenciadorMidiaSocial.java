import adapter.ISocialMediaAdapter;
import factory.Plataforma;
import factory.SocialMediaFactory;
import java.util.HashMap;
import java.util.Map;
import model.Conteudo;
import model.Credenciais;
import model.RespostaEstatisticas;
import model.RespostaPublicacao;

/**
 * Classe Cliente Principal
 * Utiliza a Factory para criar e o Adapter para interagir com as APIs.
 * O Gerenciador SÓ conhece a interface ISocialMediaAdapter.
 */
public class GerenciadorMidiaSocial {
    // Mapeia a plataforma ao seu adapter já autenticado
    private Map<Plataforma, ISocialMediaAdapter> adaptadores = new HashMap<>();

    /**
     * Configura dinamicamente uma nova plataforma usando a Factory.
     */
    public void configurarPlataforma(Plataforma p, Credenciais c) {
        try {
            System.out.println("Configurando " + p + "...");
            // Tarefa 3: Usa a Factory para criar o adapter
            ISocialMediaAdapter adapter = SocialMediaFactory.createAdapter(p);
            
            // Tarefa 1: Usa a interface unificada do adapter
            adapter.autenticar(c);
            
            adaptadores.put(p, adapter);
            System.out.println(p + " configurado com sucesso.");
        } catch (Exception e) {
            System.err.println("Falha ao configurar " + p + ": " + e.getMessage());
        }
    }

    /**
     * Publica o mesmo conteúdo em todas as plataformas configuradas.
     * Os adapters individuais tratarão da compatibilidade do conteúdo.
     */
    public void publicarEmTudo(Conteudo content) {
        System.out.printf("%n--- TENTANDO PUBLICAR CONTEÚDO TIPO: %s EM TUDO ---%n", content.getTipo());
        if (adaptadores.isEmpty()) {
            System.out.println("Nenhuma plataforma configurada.");
            return;
        }

        for (Map.Entry<Plataforma, ISocialMediaAdapter> entry : adaptadores.entrySet()) {
            Plataforma p = entry.getKey();
            ISocialMediaAdapter adapter = entry.getValue();
            
            System.out.print("[" + p + "] ");
            // Tarefa 2: Recebe uma Resposta Unificada
            RespostaPublicacao resposta = adapter.postar(content);
            System.out.println(resposta);
        }
    }
    
    public void verificarEstatisticas(Plataforma p, String postId) {
        System.out.printf("%n--- VERIFICANDO ESTATÍSTICAS DE %s (ID: %s) ---%n", p, postId);
        ISocialMediaAdapter adapter = adaptadores.get(p);
        if (adapter != null) {
            RespostaEstatisticas stats = adapter.obterEstatisticas(postId);
            System.out.println(stats);
        } else {
            System.out.println("Plataforma " + p + " não configurada.");
        }
    }
}