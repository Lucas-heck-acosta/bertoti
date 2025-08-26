# Lucas Heck Acosta

## Introdução

Tecnólogo em Análise e Desenvolvimento de Sistemas pelo Seneca College (Toronto) e em Banco de Dados pela FATEC São José dos Campos. Possuo experiência profissional como desenvolvedor, atuando em automação de processos com Python e integrações entre sistemas utilizando SAP CPI.

Tenho experiência no design de arquitetura, implementação, testes e documentação de automações corporativas de grande escala, com foco em ambientes de alto volume de dados. Me interesso especialmente por segurança da informação, além de automação e otimização de processos como forma de aumentar a eficiência e confiabilidade dos sistemas.


## Contatos
* [GIT](https://github.com/Lucas-heck-acosta)
* [LinkedIn](https://www.linkedin.com/in/lucas-h-acosta/)

## Meus Principais Conhecimentos
Possuo domínio em:

- Programação em Python para automação de processos e manipulação de dados.
- Integração de sistemas com SAP CPI, incluindo design e implementação de fluxos complexos.
- Banco de Dados Relacionais (MySQL, PostgreSQL) com foco em modelagem, consultas SQL e otimização de desempenho.
- Versionamento de código com Git e GitHub.
- Desenvolvimento de scripts e APIs para comunicação entre sistemas corporativos.

Tenho interesse em aprofundar meus conhecimentos em:

- Segurança da Informação aplicada a integrações e proteção de dados sensíveis.
- Arquitetura de Sistemas voltada para escalabilidade e alta disponibilidade.
- Cloud Computing (AWS, Azure) para soluções de integração em nuvem.
- Machine Learning 

## Meus Projetos

### Em 2025-1
![Pontual Logo](https://raw.githubusercontent.com/Steam-Ducks/ps-client/0cd13c767816d3475be65af7730df31c632e8c2a/ps-client/src/assets/PontualLogo.png)

O Projeto **Pontual** foi desenvolvido pela equipe **STEAM DUCKS** com o objetivo de entregar uma aplicação web robusta para cadastrar, editar e organizar dados de empresas, colaboradores e seus registros de ponto (entradas e saídas). Além disso, o sistema fornece funcionalidades de gestão e visualização por meio de dashboards interativos e relatórios, facilitando o acompanhamento e a análise das informações.

A empresa parceira foi a **Altave**, que apresentou a necessidade de uma solução tecnológica para lidar com o armazenamento e gerenciamento dos registros de entrada e saída de funcionários. O desafio estava em centralizar essas informações, garantindo maior segurança, confiabilidade e eficiência na gestão dos dados.



[REPOSITÓRIO](https://github.com/Steam-Ducks/point-system)

#### Tecnologias Utilizadas
- **Java** → Linguagem principal utilizada para construir a lógica do backend do sistema e implementar as regras de negócio.  
- **Spring Boot** → Framework que facilitou a criação da API backend, garantindo rapidez no desenvolvimento e integração entre os módulos.  
- **PostgreSQL** → Banco de dados relacional escolhido para armazenar com segurança os registros de ponto, dados de empresas e funcionários.  
- **Supabase** → Suporte adicional ao banco de dados, oferecendo autenticação e serviços em nuvem que facilitaram o gerenciamento da aplicação.  
- **Vue.js** → Framework JavaScript usado no front-end para criar uma interface moderna, dinâmica e intuitiva para os usuários.  
- **Figma** → Utilizado na etapa de design para prototipagem e validação das telas.  
- **Git** → Ferramenta de controle de versão e colaboração em equipe, mantendo o histórico de alterações do código.  
- **GitHub** → Plataforma onde o repositório do projeto foi hospedado.

#### Contribuições Pessoais

- **Autenticação JWT**

    **Objetivo:** Garantir acesso seguro à aplicação por meio de autenticação stateless com **JSON Web Tokens (JWT)**, protegendo rotas e dados sensíveis e oferecendo uma experiência fluida (login, refresh de sessão, logout).
    - **Backend** (Java + Spring boot / Spring Security)
  
        Implementei toda a camada de autenticação e autorização utilizando um fluxo baseado em JWT. O **JwtAuthenticationFilter** foi configurado para liberar apenas os endpoints públicos de autenticação (/api/auth/) e a documentação Swagger, enquanto todo o restante da API permanece protegido. A classe JwtUtil atua como componente central para manipulação dos tokens, oferecendo geração de access tokens com claims personalizadas (como isAdmin), criação de refresh tokens para renovação segura da sessão, validação de integridade e expiração, além da extração de informações do usuário (e-mail, username). O AuthController concentra os endpoints de autenticação (/register e /login), delegando ao AuthenticationService o processamento das requisições e retornando respostas padronizadas, com tratamento apropriado de exceções. Durante o ciclo de requisições, o filtro de autenticação intercepta chamadas, extrai o token JWT do header Authorization, valida seus dados e carrega automaticamente o contexto de segurança, garantindo que apenas usuários autenticados tenham acesso aos recursos protegidos.
    - **FrontEnd** (Vue.js + Router)
  
        modelei a camada de autenticação utilizando Vue.js 3 em conjunto com o Vue Router, garantindo que a experiência do usuário fosse alinhada com as regras de segurança definidas no backend. O UserService centraliza toda a comunicação com a API de autenticação, oferecendo métodos padronizados para login, registro de usuários e validação de sessão. O token JWT e demais informações do usuário são armazenados de forma persistente no Local Storage, sendo automaticamente injetados nas chamadas subsequentes à API. Além disso, o sistema de rotas foi configurado com navigation guards, que verificam a validade do token antes de cada transição, bloqueando acessos não autorizados e redirecionando para a tela de login. Para melhorar a experiência, o histórico da navegação é preservado, permitindo que, após a autenticação, o usuário seja redirecionado para a página originalmente requisitada.


- **Dashboard**
![Print da dashboard](https://raw.githubusercontent.com/Lucas-heck-acosta/bertoti/refs/heads/main/metodologia/dashboard.png)

    **Objetivo:** Compilar os dados de maneira clara, centralizada e acessível, oferecendo uma visão consolidada das informações mais relevantes para o usuário. A Dashboard foi projetada para atuar como ponto inicial de navegação do sistema, reunindo métricas, gráficos e indicadores que refletem o estado atual do projeto e auxiliam na tomada de decisão.

    - **Backend** (Java + Spring Boot)
        
        Desenvolvi endpoints específicos voltados à agregação de dados, já aplicando filtros e cálculos em tempo real. Isso garante que a camada de visualização receba informações consistentes e otimizadas, mesmo em cenários com grande volume de registros.

        O DashboardController centraliza essa lógica no endpoint /api/dashboard, que processa requisições com parâmetros de período (startDate e endDate) e retorna métricas consolidadas de todas as empresas do sistema.

        Para lidar com alta demanda e grandes bases, implementei processamento paralelo usando CompletableFuture em conjunto com ExecutorService. Isso permite que o CompanyService calcule simultaneamente os resultados de múltiplas empresas, reduzindo significativamente o tempo de resposta.
    - **Frontend** (Vue.js + Chart.js + ApexCharts)

        Desenvolvi a interface da Dashboard utilizando Vue.js 3 com foco em responsividade e interatividade. O DashboardService faz apenas uma chamada de API (a cada mudança de data), enviando parâmetros de período (startDate e endDate) para filtrar dados de forma dinâmica. 
        
        A camada visual foi construída com componentes modulares (cards) que renderizam diferentes tipos de métricas: cartões informativos para dados consolidados (total de funcionários, empresas ativas, folha salarial), gráficos interativos usando Chart.js e ApexCharts para visualização de tendências temporais e distribuições.
        
        Implementei sistema de atualização automática dos dados, com loading states e tratamento de erros para garantir uma experiência fluida. O layout responsivo garante visualização otimizada em diferentes dispositivos, enquanto filtros de período permitem análises customizadas.

- **Relacionamento de Entidades**
  
  **Objetivo:** Estruturar as entidades e tabelas do banco de dados para permitir que um empregado, cargo e empresa se conectem unicamente a traves de uma tabela pivot. Esse esquema suporta que um funcionario tenha mais de um emprego em mais de uma empresa com salarios diferentes.

  O modelo foi desenhado com três entidades principais: Empregado, Cargo e Empresa. Cada uma delas é independente, possuindo sua própria chave primária. A ligação entre essas entidades acontece por meio de uma tabela de relacionamento (ou tabela pivot), que armazena as chaves estrangeiras referentes a cada uma delas.
  
  Essa tabela pivot, além de associar as entidades, também é responsável por guardar o salário. Com isso, é possível modelar cenários complexos em que, por exemplo, um mesmo empregado pode ocupar cargos diferentes em empresas distintas, recebendo valores de remuneração específicos para cada vínculo.
  
  Do ponto de vista da integridade, foram aplicadas restrições de chave estrangeira para garantir que os vínculos sempre estejam associados a registros válidos de empregado, cargo e empresa. Isso assegura a consistência do banco de dados e evita duplicidade ou perda de informações.

- **Geração de Relatórios**

  **Objetivo:** Permitir que o sistema exporte automaticamente dados em formato PDF e Excel, organizados em tabelas, oferecendo ao usuário informações consolidadas e de fácil análise.
  
  No backend, fui responsável pela implementação completa do sistema de relatórios, integrando o ReportService ao DashboardController. Esse módulo suporta quatro tipos principais de relatórios: listagem de empresas, funcionários vinculados a cada empresa, folhas de ponto individuais e consolidação de horas trabalhadas por empresa.
  
  Para a camada de geração, utilizei duas bibliotecas específicas: Apache POI para criação de planilhas Excel e iText PDF para documentos em PDF. No caso das planilhas, configurei estilização com CellStyle e Font personalizados, aplicando formatação em negrito nos cabeçalhos e autoajuste de colunas para melhorar a legibilidade. Cada conjunto de dados é organizado em abas (sheets) semanticamente nomeadas, facilitando a navegação.
  
  Já nos relatórios em PDF, utilizei PdfPTable com larguras proporcionais entre colunas, além de títulos centralizados e distinção visual entre cabeçalhos e conteúdo, o que garante clareza mesmo em arquivos extensos.
  
  O Frontend atua apenas na seleção dos filtros e no download dos arquivos gerados pelo backend.

- **Sistema de Conversão de Dados**

    **Objetivo:**: Implementar uma arquitetura robusta de separação entre camadas através de conversores, garantindo que as entidades não fossem expostas diretamente na API e que os dados trafegassem de forma controlada e segura entre as camadas de persistência, negócio e apresentação.

    Implementei um sistema padronizado de conversão baseado na interface genérica Converter<E, D>, responsável por definir um contrato para a transformação entre entidades  e Data Transfer Objects (DTOs). Esse contrato estabelece métodos para conversões individuais e também para listas, permitindo tanto operações unitárias quanto em lote.
    
    Como exemplo prático, desenvolvi o PositionConverter, que é injetado no PositionService através do mecanismo de injeção de dependência do Spring. Essa integração permitiu aplicar os conversores de forma consistente em todas as operações CRUD: na criação (createPosition), o DTO recebido é convertido em entity antes da persistência; nas consultas (getPositionById, getAllPositions), as entidades recuperadas do banco são transformadas em DTOs antes de chegar ao controller; nas atualizações (updatePositionById), os dados do DTO são aplicados seletivamente na entity existente.



#### Hard Skills

- **Java + Spring Boot** – Domínio no desenvolvimento de APIs seguras, incluindo autenticação JWT, controle de acesso e implementação de filtros personalizados. Isso me permitiu criar um backend confiável para lidar com dados sensíveis e proteger rotas da aplicação.

- **Vue.js 3** – Capacidade de estruturar aplicações frontend reativas, com roteamento protegido e design moderno e estiloso.

- **Chart.js + ApexCharts** – Habilidade em criar dashboards interativas e responsivas, transformando dados brutos em visualizações claras e dinâmicas para facilitar a análise dos usuários.

- **Banco de Dados Relacional + Supabase – Experiência em modelagem de entidades complexas, aplicando constraints de integridade e garantindo consistência dos dados. Assim como conectar o banco em uma plataforma cloud para deploy da aplicação.

- **Programação Concorrente em Java** – Conhecimento na otimização de processamento de grandes volumes de dados em paralelo, garantindo performance em operações de agregação de métricas para o dashboard.

#### Soft Skills

Trabalho em equipe – Atuei em conjunto com o time para dividir responsabilidades entre backend e frontend, garantindo integração coerente entre as partes. Essa habilidade foi crucial para alinhar entregas e evitar conflitos de implementação.

Comunicação técnica – Precisei traduzir conceitos mais complexos (como autenticação JWT, concorrência e modelagem relacional) para colegas de equipe com diferentes níveis de familiaridade. Isso facilitou decisões de arquitetura compartilhadas.

Organização e atenção a detalhes – Fundamental na geração de relatórios e no desenho das entidades, onde pequenos erros poderiam comprometer a integridade ou legibilidade das informações.

Resolução de problemas – Durante o desenvolvimento da dashboard e do sistema de autenticação, enfrentei desafios de performance e segurança que exigiram análise crítica e implementação de soluções robustas (como uso de threads em paralelo e refresh tokens).

Aprendizado contínuo – Desenvolvi novas competências técnicas (como concorrência em Java e bibliotecas de relatórios) ao longo do projeto, sempre pesquisando e testando alternativas para entregar soluções mais completas.

Pensamento orientado a usuário – Mesmo focado no backend, procurei desenhar endpoints e fluxos de autenticação pensando na experiência final de quem utiliza o sistema, garantindo simplicidade e clareza nos retornos da API.





