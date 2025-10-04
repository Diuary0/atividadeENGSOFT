# Exemplo 8: Cobertura de Comandos e de Branches

Este exemplo ilustra os conceitos de cobertura de comandos e de branches, tratados no [Capítulo 8](https://engsoftmoderna.info/cap8.html#cobertura-de-testes) do Livro Engenharia de Software Moderna.

O exemplo está implementado em Python e usa:

* [unittest](https://docs.python.org/3/library/unittest.html):  framework de testes.

* [Coverage.py](https://coverage.readthedocs.io/): ferramenta para cálculo de cobertura de testes.

### Tarefa 1: Função que será testada

Estude o código da função `valor_abs`, implementada no arquivo [sistema.py](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo8/sistema.py). Ela calcula o valor absoluto de um número.

Estude o teste desta função, implementado em [teste.py](cap8/exemplo8/teste.py)

### Tarefa 2: Rodando o teste

Para rodar o teste, digite:

 `python -m unittest`

### Tarefa 3: Cobertura de Comandos

Primeiro instale a ferramenta que calcula a cobertura de testes:

```bash
python3 -m venv venv

source venv/bin/activate   # On macOS/Linux
venv\Scripts\activate      # On Windows PowerShell

pip install coverage
```

Para rodar os testes, mas agora também calculando a cobertura, digite:

`coverage run -m unittest`

Por fim, gere o relatório de cobertura de comandos:

`coverage report -m sistema.py`

Você vai ver que a cobertura de comandos é de 75%, pois a linha 3 do arquivo `sistema.py` não está sendo executada pelo teste.

Ou seja, cobertura de comandos = (número de comandos executados pelo teste) / (número de comandos do programa) = 3 / 4 = 75%.

Para aumentar a cobertura de comandos para 100%, você pode mudar o `assert` do teste para:

`self.assertEqual(10, valor_abs(-10))`

Agora a função `valor_abs` será testada com o valor -10.

Execute de novo `coverage run` e `coverage report` e verifique que a cobertura de comandos aumentou para 100%.

### Tarefa 4: Cobertura de Branches

Para calcular também a cobertura de branches, use agora:

`coverage run --branch -m unittest`.

E depois:

`coverage report -m sistema.py`.

A saída é uma tabela com as seguintes colunas:

* `Branch`: o nosso programa tem dois branches, pois um `if` sempre gera dois branches, sendo uma ramificação para o caso `true` e outra ramificação para o caso `false`.

*  `BrPart`: a sigla signfica *partial branch*, isto é, existe um branch no programa que não foi executado.

* `Missing`: o branch parcial é aquele que leva da linha 2 para a linha 4 (`2 -> 4`), isto é, não testamos o caso no qual o comando `if` da linha 2 é falso.

### Exercício 1

Modifique o teste — implementando mais um comando `assert` — de forma que a cobertura de branches também seja de 100%.

### Exercício 2

Copie para o arquivo `sistema.py` o código da função abaixo. Em seguida, em `teste.py`, implemente um teste para essa função que garanta uma cobertura de comandos e uma cobertura de branches de 100%.

```
def conceito(nota):
  if nota >= 90:
     return "A"
  if nota >= 80:
     return "B"
  if nota >= 70:
     return "C"
  if nota >= 60:
     return "D"
  return "R"
```  

### Exercício 2

Copie para o arquivo `sistema.py` o código da função abaixo. Em seguida, em `teste.py`, implemente um teste para essa função que garanta uma cobertura de comandos e uma cobertura de branches de 100%.

```
def desconto(idade, premium):
  desconto = 0
  if idade >= 60:
     desconto = 10
  if premium:
     if idade >= 60:
        desconto = 20 
     else:
        desconto = 15  
  return desconto
```
