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
     
         Computador A {porta ------------- porta} Computador B
- Computador A = Receber , recieve, read = DESSERIALIZAR 
- Computador B = enviar = send - whrite ( Bytes, String, Objetos ) = SERIALIZAR

**Objetivos e Introduçao**
- FrameWorks -> Boas Praticas , Reuso , Releases Constantes
- Um dos Objetivos da materia, seria coneseguir que um computador se comunique com outro, sem delay, como se fosse um "espelho" do outro, por meio de um servidor, claro, sendo programado a mão
  
**Threads**
- Threads é Programaçao Concomitante =! Paralelo, Concomitante, pois as threads sempre estao competindo a mesma linha
- São mini processos, que utilizam memoria + cpu, possuem tempo de vida, e seu criador ( PAI ) , se o processo do pai é cortado, o processo filho tambem, pois é dependente
- Gerenciamento de uma Thread -> Declarar e envelopar , iniciar, pausar , reiniciar , finalizar ou matar
- Threads que compartilham memoria devem ter tratamento de race condition ( condiçao de corrida, sessao critica ) tudo que a gente viu em sistemas operacionais

# Aula 2 (31/07/2026) - Resumo Sistemas Distribuidos e Sistemas Paralelos

## **Sistemas Paralelos**

- Padrão único: Hardware, sistema operacional e linguagens de programação exatamente iguais em todas as máquinas.
- Super conectados: Fortemente acoplados no mesmo ambiente físico por meio dos protocolos TCP/IP (endereço de rede, porta lógica, máscara e protocolos de transporte).
- Exemplo prático: A boa e velha estrutura de um cluster computacional.

**Arquitetura e Pilares**

- Comunicação: Ligação direta ponto a ponto entre os componentes.
- Resiliência: Alta capacidade de tolerância a falhas para evitar quedas bruscas.
- Crescimento: Escalabilidade pensada para expansão contínua.
- Proteção: Foco total em segurança da informação.
- Suporte: Processos simplificados de manutenção e atualização.

**O Grande Objetivo**
Compartilhar recursos de hardware pesados, especialmente processador e memória, para otimizar o desempenho.
