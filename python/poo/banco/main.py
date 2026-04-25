"""Programa Principal ultilizado como interface de interação com o sistema"""
from src.sistema_bancario import SistemaBancario

def main():

    sistema = SistemaBancario()
    sistema.cadastrar_usuario("Jose", "123.456.789-11", "83 9999-888", "chave")
    usuario_admim = sistema.pegar_usuario("123.456.789-11")
    usuario_admim.soma_saldo(1_000_000_000_000)

    while True:
        print("""================ Bem Vindo ao SistemaBancario - JK ==================================""")
        print("------------------------------------------------------------------------------------\n")
        print("Para Prosseguir faça uma escolha da alteração que você deseja fazer no sistema: ")
        print("-----")
        print("1 - Cadastrar Usuário no SistemaBancario.")
        print("2 - Consustar Usuários Cadastrado No sistema.")
        print("3 - Consustar Extrato De algum Usuário.")
        print("4 - Fazer Uma Transferência.")
        print("0 - Sair do SistemaBancario")

        escolha = int(input("\nO que Você deseja fazer? "))

        if escolha == 0:
            print("Até Logo! Obrigado!!")
            break

        elif escolha == 1:
            nome = input("Me fale o nome do Usuário: ")
            cpf = input("Me fale o CPF do Usuário: ")
            telefone = input("Me fale seu telefone: ")
            chave = input("Me fale sua chave Pix: ")
            print(sistema.cadastrar_usuario(nome, cpf, telefone, chave))
        elif escolha == 2:
            sistema.exibir_usuarios_cadastrados()
        elif escolha == 3:
            cpf = input("Me informe o CPF Que você deseja ver o Extrato: ")
            print(sistema.extrato(cpf))
        elif escolha == 4:
            cfp = input("Me fale o CPF de quem está trasferindo: ")
            chave = input("Me fale a chave pix para qual você deseja tranferir: ")
            valor = float(input("Me fale o valor: "))
            print(sistema.trasferir(cpf, chave, valor))

if __name__ == "__main__":
    main()
