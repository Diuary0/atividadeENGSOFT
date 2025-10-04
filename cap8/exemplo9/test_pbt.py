from hypothesis import given, strategies as st

# função soma

def soma(x,y):
    return x + y

# teste de propriedades de "soma"

@given(x=st.integers())
def test_soma_zero(x):
    assert soma(x, 0) == x

@given(x=st.integers())
def test_soma_dobro(x):
    assert soma(x, x) == 2 * x

@given(x=st.integers(), y=st.integers())
def test_soma_comutativa(x, y):
    assert soma(x, y) == soma(y, x)


# teste de propriedades de reverso de listas, isto é, da função nativa "reverse" de Python

@given(x=st.lists(st.integers()))
def test_reverso_do_reverso(x):
    rev = x.copy()
    rev.reverse()
    rev.reverse()
    assert rev == x

@given(x=st.lists(st.integers()))
def test_tamanho_reverso(x):
    rev = x.copy()
    rev.reverse()
    assert len(rev) == len(x)    

# função de ordenação via quick sort

def qsort(list):
    if list == []: 
        return []
    pivot = list[0]
    l = qsort([x for x in list[1:] if x < pivot])
    u = qsort([x for x in list[1:] if x >= pivot])
    return l + [pivot] + u

# teste de propriedades de "qsort"
# considerando que existe uma imoplementação de referência (ou oráculo), representada pelo método sort() nativo de listas em Python

@given(x=st.lists(st.integers(), min_size=1))
def test_qsort(x):
    oraculo = x.copy()
    oraculo.sort()
    assert qsort(x) == oraculo  

# teste de uma função que tem um bug claro
# objetivo: mostrar um "falsifying example"
# gerado pelo Hyphotesis

# como o código tem um bug , ele está comentado
# para ver o bug e o teste falhando, remova os
# comentários abaixo

#def soma_com_bug(x,y):
#    if (x > 10000):    
#       return x - y    # bug
#    return x + y
#
#@given(x=st.integers(), y=st.integers())
#def test_soma_com_bug(x, y):
#    assert soma_com_bug(x, y) == soma_com_bug(y, x)
