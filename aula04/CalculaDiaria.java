import java.util.Scanner;

public class CalculaDiaria {
  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    // Criar um objeto do tipo JornadaTrabalho
    Funcionario funcionario = new Funcionario();
    funcionario.jornada = new JornadaTrabalho();

    // Hora e minuto de entrada (Ponto de entrada)
    System.out.print("Digite a hora de entrada: ");
    funcionario.jornada.horaEntrada = entrada.nextInt();
    System.out.print("Digite o minuto de entrada: ");
    funcionario.jornada.minutoEntrada = entrada.nextInt();

    // Hora e minuto de saída (Ponto de saída)
    System.out.print("Digite a hora de saída: ");
    funcionario.jornada.horaSaida = entrada.nextInt();
    System.out.print("Digite o minuto de saída: ");
    funcionario.jornada.minutoSaida = entrada.nextInt();

    // Valor da hora de trabalho (Quantos reais ele recebe por hora)
    System.out.print("Digite o valor da hora de trabalho: R$ ");
    funcionario.valorHoraTrabalho = entrada.nextDouble();

    entrada.close();

    // Diferença entre a hora de saída e entrada
    int intervaloHoraTrabalho = funcionario.jornada.horaSaida - funcionario.jornada.horaEntrada;
    int intervaloMinutoTrabalho = funcionario.jornada.minutoSaida - funcionario.jornada.minutoEntrada;

    // Verificar se ultrapassou 8 horas
    int restoIntervalo = intervaloHoraTrabalho - 8;
    double valorDiaria = restoIntervalo >= 0 ? 8 * funcionario.valorHoraTrabalho
        : (8 + restoIntervalo) * funcionario.valorHoraTrabalho;

    // Verificar se ultrapassou 10 horas (2 horas extras)
    int excedeuHoraExtra = restoIntervalo > 0 ? restoIntervalo - 2 : 0;
    valorDiaria += excedeuHoraExtra >= 0 ? (funcionario.valorHoraTrabalho * 1.55) * 2
        : (funcionario.valorHoraTrabalho * 1.55) * restoIntervalo;

    // Calcular o valor da diária
    valorDiaria += excedeuHoraExtra > 0 ? (funcionario.valorHoraTrabalho * 1.60) * excedeuHoraExtra : 0;
    valorDiaria += intervaloMinutoTrabalho > 0 ? funcionario.valorHoraTrabalho : 0;

    // Exibir o valor da diária
    System.out.println("O valor da diária é R$ " + valorDiaria);

  }
}
