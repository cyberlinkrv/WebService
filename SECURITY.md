# Auditoria de segurança — WebService

## Correções nesta branch

- Removidas as credenciais de banco em texto claro do conector JDBC e da configuração JPA. A conexão agora exige `DB_URL`, `DB_USER` e `DB_PASSWORD` no ambiente; a aplicação falha explicitamente se alguma estiver ausente.
- O login deixou de aceitar credenciais no caminho de uma URL. A nova rota é `POST /serviceMobile/Login`, recebe JSON no corpo (`{"login":"...","senha":"..."}`), rejeita dados vazios e retorna `401` em falha de autenticação.
- A consulta de login agora recusa contas marcadas como inativas (`inativo = 1`), mantendo compatibilidade com registros ativos que tenham esse campo nulo.
- As operações que alteram dados (`AddProdutoNaListaOrcamento`, `ExcluirTmpList`, `deletaItemTmp`, `GravarOrcamento` e `GravarEditado`) agora usam POST em vez de GET.

## Ações operacionais urgentes

1. **Rotacionar as credenciais do banco.** Segredos que já foram versionados continuam acessíveis no histórico Git mesmo após sua remoção do estado atual. Troque imediatamente as credenciais expostas; substitua o usuário `root` por um usuário da aplicação com privilégios mínimos. Não reutilize os valores anteriores.
2. Configure `DB_URL`, `DB_USER` e `DB_PASSWORD` no serviço de execução, fora do repositório. Exemplo de formato para URL: `jdbc:mysql://<host>:3306/<database>?useSSL=true` (ajuste TLS e parâmetros conforme o servidor MySQL). Nunca grave os valores em arquivos commitados ou logs.
3. Atualize o aplicativo cliente: login agora é POST para `/Login` com JSON no corpo. As cinco operações mutáveis também devem ser chamadas com POST. O aplicativo antigo usa GET para esses caminhos e perderá compatibilidade até ser atualizado.
4. Implante somente atrás de HTTPS/TLS e valide a conexão TLS entre o serviço e o banco conforme a infraestrutura real.

## Riscos ainda abertos

- A maioria dos endpoints continua sem autenticação/autorização. Consultas de clientes, produtos e orçamentos podem expor dados; operações de escrita também precisam exigir uma identidade e validar que o usuário tem permissão para o recurso. Não foi inventado um esquema de autenticação improvisado sem suporte correspondente no app.
- As respostas ainda enviam `Access-Control-Allow-Origin: *`. CORS não substitui autenticação, mas deve ser limitado a origens conhecidas quando houver clientes web; a origem correta dos clientes Cordova precisa ser confirmada antes de restringir.
- O esquema legado compara senha diretamente no banco. Migrar para hash forte (Argon2id/bcrypt/PBKDF2 com salt) exige atualização coordenada dos registros existentes, não apenas mudança de código.
- Vários parâmetros de operações mutáveis ainda estão no caminho da URL; a próxima versão deve mover esses dados para corpos JSON e usar DTOs validados.
- O repositório distribui bibliotecas Java/JAR antigas e não contém manifesto moderno de dependências. É necessária análise de CVEs e atualização controlada do servidor, Jersey, EclipseLink, Gson e driver MySQL.

## Validação

A configuração foi revisada estaticamente. Não foi possível executar o build Ant: `ant` não está instalado neste ambiente. O contrato alterado requer teste de integração com banco de homologação e atualização do app antes do deploy. A senha presente no histórico também requer rotação; remover texto do último commit não apaga seu histórico Git.
