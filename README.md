# Processos Estocasticos (P2)

## Up and Running

**Requirements**
- JDK 11+
- Gradle (opcional)

**Building**

Para `buildar` o .jar do projeto, executar:
```
> git clone https://github.com/iobruno/senac-bcc-processos-estocasticos
> cd senac-bcc-processos-estocasticos
> ./gradlew build
```

O projeto gerará os arquivos `senac-bcc-proc-estocasticos-p2-1.0.jar` 
dentro da pasta `senac-bcc-proc-estocasticos/build/libs`


**Running**

Para execução do programa, execute:
```$xslt
java -jar build/libs/senac-bcc-proc-estocasticos-p2-1.0.jar
```

**Reports**

Os relatórios serão gerados dentro da pasta `senac-bcc-processos-estocasticos/reports`:
- `processos-estocasticos-p2-q5a.csv`
- `processos-estocasticos-p2-q5b.csv`

**Modifying**

A atualização dos dados de entrada pode ser feita através da 
classe `Application` contida no pacote `br.senac.sp.probabilidade` 
