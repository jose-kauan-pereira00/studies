""""Classe Reponsável por Criar um Usuário para o sistema """
class Usuario:
    def __init__(self, nome, CPF, telefone, chave_pix):
        self.__nome = nome
        self.__CPF = CPF
        self.__telefone = telefone
        self.__chave_pix = chave_pix
        self.__saldo = 0

    """" Métodos Setters e Getters, Útilizados Para pegar o definir novos valores, CPF é identificador Único"""
    def set_nome(self, novo_nome):
        self.__nome = novo_nome
    def set_telefone(self, novo_telefone):
        self.__telefone = novo_telefone
    def set_chave_pix(self, nova_chave):
        self.__chave_pix = nova_chave
    def soma_saldo(self, novo_saldo):
        self.__saldo += novo_saldo
    def sub_saldo(self, novo_saldo):
        self.__saldo -= novo_saldo

    def get_nome(self):
        return self.__nome
    def get_CPF(self):
        return self.__CPF
    def get_telefone(self):
        return self.__telefone
    def get_chave_pix(self):
        return self.__chave_pix
    def get_saldo(self):
        return self.__saldo



