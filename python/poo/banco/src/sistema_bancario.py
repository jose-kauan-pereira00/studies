"""Classe Reponsável pela criação e a Simulação back-end do sistema"""
from src.usuario import Usuario

"""Classe do sistema"""
class SistemaBancario:

    """Inicia Automaticamente uma lista de usuários """
    def __init__(self):
        self.__lista_de_usuarios = []

    """Métodos Gettes e Setters"""
    def get_lista_usuario(self):
        return self.__lista_de_usuarios

    """Cadastra um usuario no sistema, desde que não já esteja Cadastrado"""
    def cadastrar_usuario(self, nome, CPF, telefone, chave_pix):
        for usuario in self.__lista_de_usuarios:
            if usuario.get_CPF() == CPF:
                return "\nUsuário com CPF já Cadastrado."

        novo_usuario = Usuario(nome ,CPF ,telefone ,chave_pix)
        self.__lista_de_usuarios.append(novo_usuario)

        return "\nUsuário Cadastrado com Sucesso."

    """Tranferência apartir de um Usuario(CPF) para outro atraves da chave Pix"""
    def tranferir(self, CPF, chave_pix, valor_trasferencia):

        for usuario in self.__lista_de_usuarios:
            if usuario.get_CPF() == CPF:
                if usuario.get_saldo() >= valor_trasferencia:

                    for usuario_recebe in self.__lista_de_usuarios:
                        if usuario_recebe.get_chave_pix() == chave_pix:
                            usuario.sub_saldo(valor_trasferencia)
                            usuario_recebe.soma_saldo(valor_trasferencia)
                            return "\nValor Traferido com Sucesso."
                        else:
                            return "\nUsuario não encontrado."
                else:
                    return "\nEsse Usuario não Possui Saldo Suficiente para essa Operação. "
            else:
                return "\nUsuario não Encontrado. "

    """Exibe o extrato do usuário apartir do CPF"""
    def extrato(self, cpf):
        for usuario in self.__lista_de_usuarios:
            if usuario.get_CPF == cpf:
                return f"O saldo disponível desse usuario é: {usuario.get_saldo()} R$."
        return "\nUsuario não encontrado. "

    """Exibe os usuarios do sistema caso exista"""
    def exibir_usuarios_cadastrados(self):
        if not self.__lista_de_usuarios:
            print("\nNo sistema ainda não Possue Usuarios cadastrados. ")
        else:
            for usuario in self.__lista_de_usuarios:
                print(f"Usuário: {usuario.get_nome()} CPF: {usuario.get_CPF()} Telefone: {usuario.get_telefone()} \n Saldo disponível: {usuario.get_saldo()} \n")

    """Pega um Usuario apartir do seu Cpf"""
    def pegar_usuario(self, cpf):
        for usuario in self.__lista_de_usuarios:
            if usuario.get_CPF() == cpf:
                return usuario
        return "\nUsuario não encontrado."
