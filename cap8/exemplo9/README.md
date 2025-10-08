# Exemplo 9: Property-Based Test

Exemplo simples de Property-Based Test, usando o framework [Hypothesis](https://hypothesis.works/).

Arquivo com o teste: [test_pbt.py](./test_pbt.py)

## Como rodar o teste?

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
