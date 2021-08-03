# SEFAZ-Endereços

---
#### Descrição do problema:

Os estagiários da SEFAZ-Sinop são responsáveis pelo envio dos malotes para as demais agências fazendárias do estado, ao executar tal tarefa verifiquei que não existia padronização da mesma, muitos dos endereços estavam salvos em arquivos avulsos (world,excel, bloco de notas), cada estagiário possuía a sua forma de preparo do malote assim como a confecção da etiqueta do mesmo.

Tendo como base estes elementos, desenvolvi uma ferramenta com intuito de cadastrar os endereços utilizados e posteriormente facilitar a impressão das etiquetas dos malotes de forma padrão ( Destinatário, Remetente e Conteúdo do Malote).

---
#### Desenvolvido em:

- [x] Java 11
- [x] Gradle
- [x] NetBeans 12 

Obs: o projeto original foi desenvolvido com Java 6 e NetBeans 8.2, a atualização do mesmo com a utilização do Gradle teve como intuito o aprendizado e a consolidação de conhecimentos deste sistema de automação.

---
#### O projeto possui:

- [x] CRUD de endereço
- [x] Relatório "Emissão de etiquetas" - iReport 5.1.0
- [x]  Banco de dados SQLite

---
#### Compilando o projeto

Para facilitar a compilação do projeto foi criado no `build.gradle` a funcionalidade `cleanBuildPublish` que:

- Limpa o projeto
- Gera um fatJar
- Copia o relatório
- Copia o banco de dados

Estes 3 arquivos se encontram em `build\libs`  e são o projeto completo para distribuição.
