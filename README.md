# IndustrySystem
Teste prático para vaga de Desenvolvedor PL/SQL e Java

# Requisitos para rodar o projeto

- Java JDK 17

# Requisitos 
- [x] Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

- [x] Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

- [x] Deve conter uma classe Principal para executar as seguintes ações:

- [x] Inserir todos os funcionários, na mesma ordem e informações da tabela acima.

- [x] Remover o funcionário “João” da lista.

- [x] Imprimir todos os funcionários com todas suas informações, sendo que:

- informação de data deve ser exibido no formato dd/mm/aaaa;

- informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.

- [x] Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.

- [x] Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.

- [x] Imprimir os funcionários, agrupados por função.

- [x] Imprimir os funcionários que fazem aniversário no mês 10 e 12.

- [x] Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.

- [x] Imprimir a lista de funcionários por ordem alfabética.

- [x] Imprimir o total dos salários dos funcionários.

- [x] Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

# Como rodar o projeto

- Se você não tiver instalado o Java na sua máquina:
[Tutorial: Como instalar o java](https://www.java.com/pt-BR/download/help/download_options_pt-br.html)

- Após copiar o projeto para o seu computador, instale todas as dependências:
  
``` shell
  ./mvnw  install
```

- Para rodar o projeto:

``` shell
    java -jar target/IndustrySystem-1.0-SNAPSHOT.jar
```

