"""Testes Para o Sistema com a biblioteca pytest"""
import pytest
from src.sistema_bancario import SistemaBancario

def testar_cadastro():
    sis = SistemaBancario()
    sis.cadastrar_usuario("jose", "123.456.789-11", "99 999999", "chave1")

    assert sis.pegar_usuario("1132421241") == "\nUsuario não encontrado."

def testar_cadastro_valido():
    sis = SistemaBancario()
    sis.cadastrar_usuario("jose", "123.456.789-11", "99 999999", "chave1")
    usuario = sis.pegar_usuario("123.456.789-11")
    assert usuario.get_CPF() == "123.456.789-11"

def testar_saldo_inicial():
    sis = SistemaBancario()
    sis.cadastrar_usuario("jose", "123.456.789-11", "99 999999", "chave1")
    usuario = sis.pegar_usuario("123.456.789-11")
    assert usuario.get_saldo() == 0

def testar_saldo_alterado():
    sis = SistemaBancario()
    sis.cadastrar_usuario("jose", "123.456.789-11", "99 999999", "chave1")
    usuario = sis.pegar_usuario("123.456.789-11")
    usuario.soma_saldo(20)
    assert usuario.get_saldo() == 20
