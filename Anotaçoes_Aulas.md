# Aula 1 (27/07/2026) - Introduçao a Disciplina e Pedidos do Professor

# Pedidos do Professor
- Todos os codigos devem ser orientado a objetos
- Todos os codigos devem seguir a IDEIA da arquitetura MVC ( organizaçao em model, controller, service , interface e etc ) 
- Todos os codigos devem ter Documentaçao, caso contrario , nao sera validado o codigo
- Nao tera Provas em si , serão trabalhos avaliativos com apresentaçao no quadro


# Introduçao da Disciplina
Arquitetura de sistemas
  1) Cliente-Servidor -> Modelo TCP/IP - Pratvico x Teorico OSI = 7 camadas
     Camadas = Aplicaçao,, Apresentacao , Sessao ,  Transporte , Rede , enlaçe , Fisica
  2) Ponto-a-Ponto -> Modelo TCP/IP

Objetivos e Introduçao
 FrameWorks -> Boas Praticas , Reuso , Releases Constantes
 Um dos Objetivos da materia, seria coneseguir que um computador se comunique com outro, sem delay, como se fosse um "espelho" do outro, por meio de um servidor, claro, sendo programado a mão

                            Computador A {porta 10 ------------- porta 10}  Computador B
Computador A = Receber , recieve, read = DESSERIALIZAR 
Computador B = enviar = send - whrite ( Bytes, String, Objetos ) = SERIALIZAR
