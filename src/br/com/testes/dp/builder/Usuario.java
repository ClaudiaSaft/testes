package br.com.testes.dp.builder;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	
	public static UsuarioBuilder builder() {
		return new UsuarioBuilder();
	}
	
	public static class UsuarioBuilder {
		private Usuario usuario;
		
		public UsuarioBuilder() {
			usuario = new Usuario();
		}
		
		public UsuarioBuilder nome(String nome) {
			this.usuario.nome = nome;
			return this;
		}
		public UsuarioBuilder email(String email) {
			this.usuario.email = email;
			return this;
		}
		public UsuarioBuilder senha(String senha) {
			this.usuario.senha = senha;
			return this;
		}
		
		public Usuario buildUsuario() {
			validarCamposObrigatorios();
			return this.usuario;
		}

		private void validarCamposObrigatorios() {
			if(this.usuario.senha == null || this.usuario.senha.isEmpty()) {
				throw new RuntimeException("Campo senha é obrigatorio");
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
}
