# Blog JavaNetwork

Este projeto é um sistema desenvolvido em **Java** com integração ao banco de dados **MySQL**, com o objetivo de gerenciar perfis de usuários, postagens de mensagens e gerenciamento para administradores.  
Ele permite cadastrar perfis, registrar mensagens, controlar o fluxo de usuários e gerar relatórios de cadastros.

---

**Funcionalidades**:

Nosso blog não é apenas um espaço para leitura, ele foi pensado para ser dinâmico, organizado e prático, tanto para quem escreve quanto para quem acompanha os conteúdos. Confira algumas das principais 

**Publicação de mensagens**: É possível criar postagens longas mostrando autor, mensagem e data de publicação.

**Gerenciamento de Usuários** : O blog suporta múltiplos autores, cada um com sua própria conta. Podendo na hora da postagem alternar entre nome de usuario e nome de perfil.

**Configuração de perfil** : O possibilidade de atualizar, apagar, criar e visualizar o perfil conforme o gosto do usuario.

---

## 🛠️ Tecnologias Utilizadas

- **Java SE 17**  
- **Swing** para interface gráfica  
- **MySQL/MariaDB** para persistência de dados  
- **DAO/DTO Pattern** para organização do código  
- **Maven** para gerenciamento de dependências
- **JDBC package** para conexão entre banco e codigo java  

---

## 📂 Estrutura do Projeto  
  src/

├── CamadaDAO/ # Classes de acesso ao banco de dados

├── CamadaDTO/ # Objetos de transferência de dados

├── CamadaView/ # Interfaces gráficas (Swing)

├── img/ # Imagens gerais


---

## 📅 Histórico de Atualizações

- **v1.0.0** – (04/10/2025)  
  - Primeira versão estável para uso.  
  - Implementação de postagem de mensagens e ajustes de perfil.
  - Salvamento de perfil atual e mensagens postadas.

- **v0.3.0** – (15/09/2025)  
  - Preparação na implementação de abas de perfil e postagem de mensagens.  
  - Ajustes na interface gráfica de login e cadastro.
  - Adição de tela principal.

- **v0.2.0** – (08/09/2025)  
  - Implementação de sistema de cadastro e login.
  - Inicialização da tela inicial  

- **v0.1.0** – (01/09/2025)  
  - Estrutura inicial do projeto criada (DAO, DTO, VIEW).
  - Definição do objetivo do projeto.  

---

## 👨‍💻 Desenvolvedores

Este projeto foi idealizado e desenvolvido por:  
## William Meireles da Cunha Flores
## Vitor Fernando Dutra


---

## Informações sobre o Banco de Dados usado



---


## 📜 Licença

Este projeto está licenciado sob a licença **MIT** – veja o arquivo [LICENSE](LICENSE) para mais detalhes.
