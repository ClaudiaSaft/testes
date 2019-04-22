package br.com.testes.dp.builder;

public class TestePessoa {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		System.out.println(p);

		Pessoa p1 = new Pessoa.PessoaBuilder()
				.nome("Claudia")
				.sobrenome("Saft")
				.idade(28)
				.buildPessoa();
		System.out.println(p1);
	}
}
