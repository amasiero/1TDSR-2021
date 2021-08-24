public class OperadoresEspeciais {

  public static void main(String[] args) {

    double a = 1;
    System.out.println(a); // 1

    a += 5; // a = a + 1;
    System.out.println(a); // 2

    a -= 1; // a = a - 1;
    System.out.println(a);

    a *= 2; // a = a * 2;
    System.out.println(a);

    a /= 3; // a = a / 3;
    System.out.println(a);

    a %= 3; // a = a % 3;
    System.out.println(a);

    // Operadores Unários

    int b = 1;
    int c = 2;

    b++; // b = b + 1; // incrementar
    b--; // b = b - 1; // decrementar
    System.out.println(b); // 1

    b = b + 1; // ++ antes - somo antes de usar
    System.out.println(b == c); // usando a variável
    c = c + 1; // ++ depois - uso antes de somar

    System.out.println(b);
    System.out.println(c);

    System.out.println(b == c);

    // System.out.println(++b == c++); // true

    // System.out.println(b); // 2
    // System.out.println(c); // 3

    // System.out.println(b == c); // false

    // Operador Tenário

    double minhaAltura = 1.83;
    String conceitoAltura = minhaAltura > 1.80 ? "Alto" : "Baixo";
    System.out.println(conceitoAltura);
  }

}
