# logus-agenda-consultorio
## Desafio proposto por LogusRetail

A proposta do desafio é a criação de uma API RESTful, para gerir a agenda de um consultório médico.
- [x] Cadastro de Médicos (Nome, CRM, Idade).
- [x] Consultório (Número)
- [x] Cadastro das consultas médicas
- [x] Consultas das consultas médicas cadastradas

Cada marcação de consulta deve conter obrigatoriamente as seguintes informações:
- [x] Nome do Paciente
- [x] Especialidade Médica
- [ ] Nome do Médico
- [x] CRM do Médico
- [ ] Data/Hora
- [x] Numero do consultorio

### API criada com Angular 10 e SpringBoot 2.5
#### Para executar é necessário ter o npm, e java 8, passos para rodar o projeto: 

** No backend 
* Importe o consultorio-back como projeto maven à sua IDE de preferência;
* No terminal, rode o mvn package para baixar as dependências;
* Execute o arquivo ConsultorioApplication.java

** No frontend
* Com o terminal acesse o diretório consultorio-front;
* execute a npm install
* em seguida caso não haja erros, execute npm start
