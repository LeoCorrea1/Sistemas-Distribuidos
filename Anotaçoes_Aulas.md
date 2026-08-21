# Aula 1 (27/07/2026) - Pedidos do Professor e Introduçao a Disciplina 

# Pedidos do Professor
- Todos os codigos devem ser orientado a objetos
- Todos os codigos devem seguir a IDEIA da arquitetura MVC ( organizaçao em model, controller, service , interface e etc ) 
- Todos os codigos devem ter Documentaçao, caso contrario , nao sera validado o codigo
- Nao tera Provas em si , serão trabalhos avaliativos com apresentaçao no quadro


# Introduçao da Disciplina
**Arquitetura de sistemas**
  1) Cliente-Servidor -> Modelo TCP/IP - Pratvico x Teorico OSI = 7 camadas
     Camadas = Aplicaçao,, Apresentacao , Sessao ,  Transporte , Rede , enlaçe , Fisica
  2) Ponto-a-Ponto -> Modelo TCP/IP
- Tolerância a falhas
- Escalabilidade
- Segurança
- Manutenção/atualização
     
         Computador A {porta ------------- porta} Computador B
- Computador A = Receber , recieve, read = DESSERIALIZAR 
- Computador B = enviar = send - whrite ( Bytes, String, Objetos ) = SERIALIZAR

**Objetivos e Introduçao**
- FrameWorks -> Boas Praticas , Reuso , Releases Constantes
- Um dos Objetivos da materia, seria coneseguir que um computador se comunique com outro, sem delay, como se fosse um "espelho" do outro, por meio de um servidor, claro, sendo programado a mão
  
**Threads**
Threads é Programaçao Concomitante =! Paralelo, Concomitante, pois as threads sempre estao competindo a mesma linha
São mini processos, que utilizam memoria + cpu, possuem tempo de vida, e seu criador ( PAI ) , se o processo do pai é cortado, o processo filho tambem, pois é dependente
Gerenciamento de uma Thread -> Declarar e envelopar , iniciar, pausar , reiniciar , finalizar ou matar
Threads que compartilham memoria devem ter tratamento de race condition ( condiçao de corrida, sessao critica ) tudo que a gente viu em sistemas operacionais

# Aula 2 (31/07/2026) - Resumo Sistemas Distribuidos e Sistemas Paralelos

# Sistemas Paralelos

**O que são :**
- Padrão único: Hardware, sistema operacional e linguagens de programação idênticos em todas as máquinas.
- Super conectados: Fortemente acoplados fisicamente via TCP/IP (endereço de rede, porta lógica, máscara e protocolos de transporte).
- Na prática: Estrutura típica de um *cluster* computacional.

**Arquitetura & Pilares:**
- Comunicação: Direta, estilo ponto a ponto.
- Resiliência: Tolerância a falhas reforçada para evitar quedas.
- Proteção: Foco forte em segurança.
- Suporte: Manutenção e atualizações simplificadas.

**Meta Principal:**
- Compartilhar recursos pesados (processador e memória) para turbinar o desempenho.

# Sistemas Distribuídos

**Características:** 
- Heterogêneos, fracamente acoplados via TCP/IP.

**Arquiteturas:**
- Cliente-Servidor, P2P e Híbrido.

**Desafios:** 
- Tolerância a falhas, escalabilidade, segurança e sincronismo (relógios e exclusão mútua).

**Comunicação e Threads**
- Sockets: Comunicação bloqueante (leitura/escrita).
- Threads: Miniprocessos para garantir concorrência e liberar o fluxo bloqueante dos sockets.

**Tipos:**
- Com compartilhamento: Exige controle manual de sincronismo (Runnable em Java, tratamento de race condition).
- Sem compartilhamento: Execução independente (Classe Thread em Java).

# Aula 3 (03/08/2026) - Não pude Comparecer - Exame Pessoal

-Professor Iniciou a demonstrar na pratica oque foi apresentado nas aulas passadas ( codigo em python )

# Aula 4 (07/08/2026) - Continuação Threads Python

**Cliente-Servidor:** 
- Existe um "centralizador". É aquele esquema tradicional em que o seu computador só pede as coisas e um servidor principal responde e entrega.
- É super fácil de organizar e controlar, mas tem um detalhe: se esse servidor cair, todo mundo fica na mão e o serviço para.

**Ponto-a-Ponto (P2P):**
- Não existe um chefe. Todo mundo na rede conversa direto entre si, funcionando ao mesmo tempo como quem pede e quem entrega a informação tipo no BitTorrent. 
- A grande vantagem é que, se o computador de alguém desligar, a rede continua funcionando normalmente e aguenta muito mais gente conectada ao mesmo tempo.

**Comunicação** : 
- É a forma como as máquinas trocam mensagens pela rede para conseguir cooperar. O desafio é que a rede falha, a mensagem pode se perder ou atrasar, e sem essa troca eficiente o sistema nem existe.
  
**Sincronismo** : 
- É a coordenação para colocar ordem na casa, garantindo que as ações aconteçam no momento certo e sem conflitos (como evitar que dois nós alterem o mesmo dado ao mesmo tempo).
- É a parte mais complexa porque não existe um relógio global perfeito por isso, dependem de relógios lógicos e algoritmos de consenso (como Raft) para manter tudo alinhado e consistente.

# Aula 7 (17/08/2026) - Primeiro trabalho

**Exercício 1: Caixas de Evento (Com Compartilhamento de Memória)**
Objetivo: 5 threads somam 1.000 vendas de R$ 10,00 cada na variável saldo_central.

Resultado esperado: R$ 50.000,00.

Avalia: Sincronização e controle de condição de corrida (Lock / synchronized).

**Exercício 2: Relatório de Filiais (Sem Compartilhamento de Memória)**
Objetivo: 4 threads calculam a soma local de 4 listas isoladas (vendas de filiais).

Resultado esperado: Thread principal aguarda todas (join) e realiza a soma final.

Avalia: Padrão Fork-Join e isolamento de escopo (sem variáveis globais).



