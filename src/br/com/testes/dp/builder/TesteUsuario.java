package br.com.testes.dp.builder;

public class TesteUsuario {

	public static void main(String[] args) {
		
		Usuario u = Usuario.builder()
				.nome("Claudia")
				.email("claudia.saft@gmail.com")
				.senha("pass")
				.buildUsuario();
		
		System.out.println(u);

		Usuario uErro = Usuario.builder()
				.nome("Claudia")
				.email("claudia.saft@gmail.com")
				.buildUsuario();
		
		System.out.println(uErro);
	}
}
