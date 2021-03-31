
public class Application {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();

		aluno.setNome("Maurício Amyr");
		aluno.setProva1(4.0);
		aluno.setProva2(7.0);
		aluno.setTrabalho(5.0);

		double notaParaAprovacao = aluno.calculaNotaNecessariaParaAprovacao();
		
		String mensagem = String.format(
				"O aluno %s ficou com média %.1f e precisa de %.1f pontos na avaliação final. [%s]",
				aluno.getNome(),
				aluno.calculaMedia(),
				notaParaAprovacao,
				notaParaAprovacao != 0 ? "EXAME" : "APROVADO"
		);
		
		System.out.println(mensagem);

	}

}
