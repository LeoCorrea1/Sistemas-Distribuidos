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
Padrão único: Hardware, sistema operacional e linguagens de programação idênticos em todas as máquinas.
Super conectados: Fortemente acoplados fisicamente via TCP/IP (endereço de rede, porta lógica, máscara e protocolos de transporte).
Na prática: Estrutura típica de um *cluster* computacional.

**Arquitetura & Pilares:**
Comunicação: Direta, estilo ponto a ponto.
Resiliência: Tolerância a falhas reforçada para evitar quedas.
Proteção: Foco forte em segurança.
Suporte: Manutenção e atualizações simplificadas.

**Meta Principal:**
Compartilhar recursos pesados (processador e memória) para turbinar o desempenho.

# Sistemas Distribuídos
Características: Heterogêneos, fracamente acoplados via TCP/IP.
Arquiteturas: Cliente-Servidor, P2P e Híbrido.
Desafios: Tolerância a falhas, escalabilidade, segurança e sincronismo (relógios e exclusão mútua).

**Comunicação e Threads**
Sockets: Comunicação bloqueante (leitura/escrita).
Threads: Miniprocessos para garantir concorrência e liberar o fluxo bloqueante dos sockets.

**Tipos:**
Com compartilhamento: Exige controle manual de sincronismo (Runnable em Java, tratamento de race condition).
Sem compartilhamento: Execução independente (Classe Thread em Java).
