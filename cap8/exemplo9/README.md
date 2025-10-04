# Exemplo 9: Property-Based Test

Exemplo de Property-Based Test, usando o framework [Hypothesis](https://hypothesis.works/).

Arquivo com o teste: [test_pbt.py](https://github.com/mtov/ESM-ExemplosCodigo/blob/master/cap8/exemplo9/test_pbt.py)

## Para instalar o Hypothesis e rodar o teste

Primeiro, instale o Hypothesis:

```bash
python3 -m venv venv

source venv/bin/activate   # On macOS/Linux
venv\Scripts\activate      # On Windows PowerShel

pip install hypothesis
pip install pytest
```

Para rodar os testes, use:

`pytest -v`
