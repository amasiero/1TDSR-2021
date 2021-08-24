
import java.util.Scanner;

class Exercicio01 {

  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in); // Scanner entrada = new Scanner

    // Hora e minuto de entrada (Ponto de entrada)
    System.out.print("Digite a hora de entrada: ");
    int horaEntrada = entrada.nextInt();
    System.out.print("Digite o minuto de entrada: ");
    int minutoEntrada = entrada.nextInt();

    // Hora e minuto de saída (Ponto de saída)
    System.out.print("Digite a hora de saída: ");
    int horaSaida = entrada.nextInt();
    System.out.print("Digite o minuto de saída: ");
    int minutoSaida = entrada.nextInt();

    // Valor da hora de trabalho (Quantos reais ele recebe por hora)
    System.out.print("Digite o valor da hora de trabalho: R$ ");
    double valorHoraTrabalho = entrada.nextDouble();

    entrada.close();

    // Diferença entre a hora de saída e entrada
    int intervaloHoraTrabalho = horaSaida - horaEntrada;
    int intervaloMinutoTrabalho = minutoSaida - minutoEntrada;

    // Verificar se ultrapassou 8 horas
    int restoIntervalo = intervaloHoraTrabalho - 8;
    double valorDiaria = restoIntervalo >= 0 ? 8 * valorHoraTrabalho : (8 + restoIntervalo) * valorHoraTrabalho;

    // Verificar se ultrapassou 10 horas (2 horas extras)
    int excedeuHoraExtra = restoIntervalo > 0 ? restoIntervalo - 2 : 0;
    valorDiaria += excedeuHoraExtra >= 0 ? (valorHoraTrabalho * 1.55) * 2 : (valorHoraTrabalho * 1.55) * restoIntervalo;

    // Calcular o valor da diária
    valorDiaria += excedeuHoraExtra > 0 ? (valorHoraTrabalho * 1.60) * excedeuHoraExtra : 0;
    valorDiaria += intervaloMinutoTrabalho > 0 ? valorHoraTrabalho : 0;

    // Exibir o valor da diária
    System.out.println("O valor da diária é R$ " + valorDiaria);

  }

}