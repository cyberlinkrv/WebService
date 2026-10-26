# Atualização de dependências — WebService

**Escopo:** dependências vendorizadas no projeto NetBeans/Ant, cuja aplicação está fixada em Java 8 e usa APIs `javax.*`. As versões abaixo foram verificadas em 26/10/2026. “Compatível” não significa que a aplicação foi validada em produção; o Tomcat e o banco reais não estão declarados no repositório.

## Atualizações aplicadas

| Componente | Antes | Agora | Observações |
|---|---:|---:|---|
| Jersey / Jersey HK2 | 2.5.1 e módulos sem versão no nome | 2.48 em todos os módulos | Mantida a linha Jersey 2 / `javax`; JAX-RS atualizado de 2.0 para 2.1.6. A API 2.1.6 usa um nome de artefato iniciado por `jakarta`, mas contém as classes `javax.ws.rs` esperadas pelo código. A verificação dos JARs mostrou classes base com bytecode Java 8 (major 52). Jersey 2.48 incorpora a correção disponibilizada na linha 2.x para CVE-2025-12383 (corrigida a partir de 2.46). |
| EclipseLink / JPA | EclipseLink 2.5.2, JPA 2.1 | EclipseLink 2.7.16, JPA 2.2 | Mantida a linha `javax.persistence` compatível com Java 8. O descritor JPA permanece em 2.1 para não ativar recursos novos sem necessidade. As fontes consultadas não estabelecem compromisso formal de suporte de segurança para a linha 2.7; esta atualização não equivale a uma garantia de ausência de CVEs. |
| Gson | 2.3.1 | 2.15.0 | Compatível com Java 8. A versão atual está acima da correção 2.8.9 para CVE-2022-25647. |
| JUnit | 4.12 | 4.13.2 | Mantida a API JUnit 4 existente; a correção para CVE-2020-15250 foi publicada na linha 4.13.1. |
| Hamcrest | 1.3 | 3.0 | Compatível com Java 8; removido o JAR 1.3 transitivo para evitar classes duplicadas. |
| APIs e transitivos Jersey/HK2/MOXy | Versões antigas de Jersey, HK2, JAXB, injeção, validação e OSGi locator | Conjunto resolvido para Jersey 2.48 e EclipseLink 2.7.16 | Atualizados em conjunto via dependências Maven; Servlet API 3.1.0 está somente no classpath de compilação, não no WAR, pois deve ser fornecida pelo container. |
| PostgreSQL JDBC | 9.2 | Removido | Não há referências ao driver, URL PostgreSQL ou pacotes `org.postgresql` no código/configuração da aplicação; a persistência e o conector existentes são MySQL. Se houver uso por reflexão/configuração externa não versionada, a dependência precisará ser reintroduzida. |

## Pendências que dependem do ambiente

- **MySQL Connector/J:** permanece em 5.1.39 por enquanto. O código precisa de um driver MySQL, mas não há versão do MySQL Server nem ambiente de homologação disponível. O release pesquisado mais recente, Connector/J 26.10.0, declara MySQL Server 8.4+ como mínimo; a documentação de compatibilidade Java 8 consultada descreve 26.7, não especificamente 26.10.0. Não foi escolhido esse upgrade sem confirmação, para evitar incompatibilidade de servidor/driver. Antes de migrar, confirme a versão do MySQL e teste autenticação, TLS, fuso horário, pool, transações e o nome do driver (`com.mysql.cj.jdbc.Driver`).
- **Tomcat:** a versão implantada não é declarada de forma confiável como runtime no projeto; a configuração contém caminhos locais de NetBeans. Tomcat 9 é a linha compatível com Java 8 e `javax`, mas a configuração da aplicação ainda declara a plataforma Java EE 7 e a implantação real não foi testada. A Apache anunciou o fim de suporte do Tomcat 9 para 31/03/2027. O container deve ser atualizado/confirmado fora deste repositório; Tomcat 10+ envolve migração `javax` → `jakarta` e não é um upgrade direto.
- **PostgreSQL removido:** confirme que nenhuma rotina externa ou instalação utiliza esse JAR sem referências no repositório.

## Validação executada

- `ant -q clean dist`: **sucesso** com JDK 21; o projeto continua compilando para source/target 8. Foi desativado o annotation processor JPA nesse build (`-proc:none`) porque o metamodelo `mvVendas_` já está versionado e o processor tentava gerar novamente a mesma classe.
- Compilação separada do código e dos testes com `javac --release 8`: **sucesso**.
- Os testes JUnit **não foram executados**: os testes existentes chamam operações DAO e podem alterar dados reais, além de não estarem isolados de um banco de homologação.
- Não foi feito deploy nem teste de integração com o MySQL/Tomcat reais. A versão do driver MySQL e a configuração do servidor permanecem condicionadas às informações pendentes.

## Fontes

- Jersey: [registro oficial 2.48](https://projects.eclipse.org/projects/ee4j.jersey/releases/2.48), [roadmap do projeto](https://github.com/eclipse-ee4j/jersey/wiki/Road-Map), [advisory CVE-2025-12383](https://github.com/advisories/GHSA-7p63-w6x9-6gr7) e [NVD](https://nvd.nist.gov/vuln/detail/CVE-2025-12383).
- EclipseLink: [índice oficial de releases](https://eclipse.dev/eclipselink/releases/index.php), [documentação da linha 2.7](https://eclipse.dev/eclipselink/releases/2.7.html) e [notas 2.7.16](https://github.com/eclipse-ee4j/eclipselink/releases/tag/2.7.16).
- Gson: [releases oficiais](https://github.com/google/gson/releases), [README oficial sobre Java mínimo e manutenção](https://github.com/google/gson) e [advisory CVE-2022-25647](https://github.com/advisories/GHSA-4jrv-ppp4-jm57).
- JUnit/Hamcrest: [JUnit 4](https://junit.org/junit4/), [release notes 4.13.2](https://github.com/junit-team/junit4/blob/main/doc/ReleaseNotes4.13.2.md), [NVD CVE-2020-15250](https://nvd.nist.gov/vuln/detail/CVE-2020-15250), [Hamcrest 3.0](https://github.com/hamcrest/JavaHamcrest/releases/tag/v3.0).
- MySQL: [notas Connector/J 26.10.0](https://dev.mysql.com/doc/relnotes/connector-j/en/news-26-10-0.html), [matriz de compatibilidade](https://dev.mysql.com/doc/connector-j/en/connector-j-versions.html), [guia de upgrade](https://dev.mysql.com/doc/connector-j/en/connector-j-upgrading-to-8.0.html) e [Oracle CPU de outubro de 2026](https://www.oracle.com/security-alerts/cpuoct2026.html).
- Tomcat: [matriz de versões suportadas](https://tomcat.apache.org/whichversion.html), [advisories de segurança Tomcat 9](https://tomcat.apache.org/security-9.html), [aviso de fim de suporte Tomcat 9](https://tomcat.apache.org/tomcat-9.0.x-eos.html) e [guia de migração para Tomcat 10](https://tomcat.apache.org/migration-10.html).
