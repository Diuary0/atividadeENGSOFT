/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exemplo de teste parametrizado
*
*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
 
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteParametrizado {

  // teste parametrizado
  // parâmetros de cada chamada são informados explicitamente (@ValueSource)
  // ele será chamado 5 vezes pelo framework de teste
  // irá falhar para n = 1, 3, e 5
  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3, 4, 5 })
  void testaSeNumeroParParametrizado(int n) {
    assertTrue(Calculadora.par(n));
  }

  // teste não-parametrizado
  @Test
  void testaSeNumeroPar() {
    assertTrue(Calculadora.par(1));  

    // como o assert anterior vai falhar
    // os próximos assert não serão executados
    assertTrue(Calculadora.par(2));
    assertTrue(Calculadora.par(3));
    assertTrue(Calculadora.par(4));
    assertTrue(Calculadora.par(5));
  }
  
}