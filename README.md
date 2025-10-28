Sistema de Integração de Mídias Sociais (Padrões Adapter e Factory)
1. Objetivo
Este projeto é uma implementação em Java de um sistema unificado para gerenciamento de redes sociais. O objetivo principal é demonstrar o uso dos padrões de projeto Adapter e Factory para lidar com a complexidade de integrar múltiplas APIs heterogêneas (Twitter, LinkedIn, TikTok, etc.) sob uma interface única e coesa.

O sistema permite que um GerenciadorMidiaSocial (o cliente) autentique, publique conteúdos e obtenha estatísticas de diferentes plataformas sem precisar conhecer os detalhes de implementação de cada API específica.

2. Padrões de Projeto Utilizados
2.1. Adapter (Adaptador)
Problema: As APIs de Twitter, LinkedIn e TikTok são incompatíveis. Elas têm métodos de autenticação diferentes (login, authorize, auth), modelos de dados distintos (tweet, LinkedInArticle, uploadVideo) e formatos de resposta variados.

Solução: O padrão Adapter é usado para "embrulhar" cada API em uma classe adaptadora (TwitterAdapter, LinkedInAdapter, TikTokAdapter). Todas essas classes implementam uma interface alvo comum (ISocialMediaAdapter).

Resultado: O cliente (GerenciadorMidiaSocial) programa apenas para a interface ISocialMediaAdapter, tratando todas as redes sociais da mesma forma. O adapter fica responsável por "traduzir" as chamadas unificadas (ex: postar(Conteudo c)) para as chamadas específicas da API que ele adapta (ex: api.tweet(c.getTexto())).

2.2. Simple Factory (Fábrica Simples)
Problema: O cliente (GerenciadorMidiaSocial) precisaria saber qual classe adaptadora concreta (TwitterAdapter, LinkedInAdapter...) instanciar para cada plataforma. Isso acoplaria o cliente às implementações concretas.

Solução: A classe SocialMediaFactory é utilizada para encapsular a lógica de criação. Ela possui um método estático createAdapter(Plataforma p) que recebe um enum e retorna a instância do adapter correto.

Resultado: O cliente é desacoplado. Para adicionar uma nova plataforma (ex: InstagramAdapter), basta modificarmos a SocialMediaFactory e criar o novo adapter; o GerenciadorMidiaSocial não sofre alteração.

4. Como Compilar e Executar
Este projeto usa pacotes, portanto, a compilação deve ser feita a partir do diretório raiz.

Pré-requisitos:

Java Development Kit (JDK) 11 ou superior.

Passo a passo:

Estrutura: Certifique-se de que todos os arquivos .java estão dentro de suas respectivas pastas de pacote (ex: TwitterAdapter.java deve estar dentro da pasta adapter/).

Compilar (do diretório raiz): Abra o terminal no diretório que contém Main.java e as pastas adapter/, apis/, etc.

Bash

# Compila todos os arquivos .java em todos os subdiretórios
javac */*.java *.java
Se estiver usando PowerShell, talvez seja necessário ser mais explícito:

PowerShell

javac model/*.java apis/*.java adapter/*.java factory/*.java *.java
Executar (do diretório raiz): Após a compilação, execute a classe Main (sem .java ou .class).

Bash

java Main

