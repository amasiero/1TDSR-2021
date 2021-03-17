public class OperadoresLogicos {

  public static void main(String[] args) {

    // Comparações (Operações Lógicas)

    int a = 2;
    int b = 2;
    int c = 3;

    // Quando coloco o tipo em frente ao nome da variável.
    // Estou declarando-a pela primeira vez.
    boolean igual = a == b;
    boolean diferente = a != b;

    // Sem o tipo em frente ao nome da variável.
    // Estou reutilizando essa variável.
    igual = !diferente; // negação (invertendo um valor boolean)
    // Se true vira false. Se false vira true.

    boolean maior = a > b;
    boolean menor = a < b;

    boolean maiorOuIgual = a >= b;
    boolean menorOuIgual = a <= b;

    // Verificar se A é maior B e C é maior que A + B

    boolean primeiraCondicao = a > b;
    int somaAB = a + b;
    boolean segundaCondicao = c > somaAB;

    // Primeira tabela verdade

    // Condicao1 | Condicao2 | Resultado (AND (E))
    // True | True | True
    // True | False | False
    // False | True | False
    // False | False | False

    boolean resultado = primeiraCondicao & segundaCondicao;
    resultado = primeiraCondicao && segundaCondicao;

    // Segunda tabela verdade

    // Condicao1 | Condicao2 | Resultado (OR (OU))
    // True | True | True
    // True | False | True
    // False | True | True
    // False | False | False

    resultado = primeiraCondicao | segundaCondicao;
    resultado = primeiraCondicao || segundaCondicao;

    // Terceira tabela verdade

    // Condicao1 | Condicao2 | Resultado (XOR (OU Exclusivo))
    // True | True | False
    // True | False | True
    // False | True | True
    // False | False | False

    resultado = primeiraCondicao ^ segundaCondicao;

  }

}