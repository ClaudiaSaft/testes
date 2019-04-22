package br.com.testes.dp.builder;

public class Pessoa {

	private String nome;
	private String sobrenome;
	private Integer idade;
	
	public Pessoa() {
	}
	
	private Pessoa(String nome, String sobrenome, Integer idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
	}

	public static class PessoaBuilder {
		private String nome;
		private String sobrenome;
		private Integer idade;
		
		public PessoaBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}
		public PessoaBuilder sobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
			return this;
		}
		public PessoaBuilder idade(Integer idade) {
			this.idade = idade;
			return this;
		}
		
		public Pessoa buildPessoa() {
			return new Pessoa(nome, sobrenome, idade);
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public Integer getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + "]";
	}
	
}
