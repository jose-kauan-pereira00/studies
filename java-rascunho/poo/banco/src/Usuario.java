package src;
/**
 * @author José Kauan Pereira
*/
public class Usuario{
	private String nome;
	private final String CPF;
	private double saldo;
	private String pix;
	private String telefone;

	public Usuario(String nome, String CPF, String pix, String telefone){
		this.nome = nome;
		this.CPF = CPF;
		this.pix = pix;
		this.telefone = telefone;
		this.saldo = 0;
	}

	/**
	 * Métodos Setters
	 * */
	public void setNome(String nome){
		this.nome = nome;
	}
	public void somaSaldo(double saldo){
		this.saldo += saldo;
	}
	public void subSaldo(double saldo){
		this.saldo -= saldo;
	}
	public void setPix(String pix){
		this.pix = pix;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	/**
	 * Métodos Getters
	 * */
	 public String getNome(){
	 	return this.nome;
	 }
	 public String getCPF(){
	 	return this.CPF;
	 }
	 public double getSaldo(){
	 	return this.saldo;
	 }
	 public String getPix(){
	 	return this.pix;
	 }
	 public String getTelefone(){
	 	return this.telefone;
	 }

	 @Override
	 public boolean equals(Object obj){
	 	if(this == obj){
	 		return true;
	 	}
	 	if(obj == null || this.getClass() != obj.getClass()){
	 		return false;
	 	}
	 	Usuario usu = (Usuario) obj;
	 	return  this.getCPF().equals(usu.getCPF());
	 }

	 @Override
	 public int hashCode(){
	 	return this.getCPF().hashCode();
	 }

	 @Override
	 public String toString(){
	 	return "Nome: " + nome + " \nCPF: " + CPF + "\ntelefone: " + telefone + "\nChave Pix: " + pix + "\nsaldo: " + saldo +" R$\n";
	 }
}	
