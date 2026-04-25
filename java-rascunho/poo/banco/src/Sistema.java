package src;
import java.util.ArrayList;
import java.util.List;

public class Sistema{
	private List<Usuario> listaDeUsuarios;

	public Sistema(){
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}

	public void cadastrarUsuario(String nome, String CPF, String pix, String telefone){
		for(Usuario u : listaDeUsuarios){
			if(u.getCPF().equals(CPF)){
				throw new IllegalArgumentException("Não Foi Possivel fazer o caadastro. CPF já Em Uso :(");
			}
		}
		Usuario usuario = new Usuario(nome, CPF, pix, telefone);
		listaDeUsuarios.add(usuario);
	}
		

	public void mostraLista(){
		if(listaDeUsuarios == null){
			throw new IllegalArgumentException("Sem Usuários Ainda ;(");
		}else{
			for(Usuario usuario: listaDeUsuarios){
				System.out.println(usuario.toString());

			}
		}
	}

	public void realizarTrasferencia(String cpf, String pix, double valor){
		for(Usuario u : listaDeUsuarios){
			if(u.getCPF().equals(cpf)){
				if(u.getSaldo() >= valor){
					u.subSaldo(valor);
					for(Usuario a : listaDeUsuarios){
						if(a.getPix().equals(pix)){
							a.somaSaldo(valor);
							break;
						}
						break;
					}
					break;
				}else{
					throw new IllegalArgumentException("Você não Possui Saldo o Suficiente :(");
				}
			}
		}
	}
	public String buscarPessoa(String cpf){
		if(listaDeUsuarios != null){
			for(Usuario u : listaDeUsuarios){
				if(u.getCPF().equals(cpf)){
				return u.toString();
				}
			}
		}else{
			throw new IllegalArgumentException("Usuário Inexistente! :(");
		}
		
		return null;
	}

	public Usuario retornaUsu(String cpf){
		for(Usuario u : listaDeUsuarios){
			if(u.getCPF().equals(cpf)){
				return u;
			}
		}
		return null;
	}

		
}
	