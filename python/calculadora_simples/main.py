from src import formulas

def main():

    print("======= Calculadora de Formulas Simples =========")
    print("Formulas Disponíveis:\n" \
    "Sair(0)\n" \
    "Baskara(1)\n" \
    "Velocidade(2)\n" \
    "Posição(3)\n" \
    "Velocidade com Aceleração(4)\n" \
    "Posição com Aceleração(5)\n" \
    "Força(6)\n" \
    "Peso(7)\n" \
    "Trabalho(8)\n" \
    "Energia Cinética(9)\n" \
    "Energia Gravitacional(10)")

    while True:
        operacao = int(input("Digite um Número Entre 0 e 10: \n"))
        if operacao == 0:
            print("\nAté Mais, Obrigado ;)")
            break

        if operacao not in range(0, 11):
            print("\nPor Favor me dê um Número Válido.(0 a 10)\n")

        if operacao == 1:
            print("==========BASKARA==========\n")

            a, b, c = float(input("Me Dê um Valor para A: ")), float(input("Me dê um Valor Para B: ")), float(input("Me dê um valor para C: "))
        
            print(f"Resultado: {formulas.baskara(a, b, c)} \n" )
        
        if operacao == 2:
            print("===========VELOCIDADE==========\n")

            s, t = float(input("Me fale o espaço percorrido(m): ")), float(input("Me fale o Tempo(s): "))

            print("A Velocidade é de: ", formulas.velocidade(s, t), "m/s \n" )

        if operacao == 3:
            print("==========POSIÇÃO DO OBJETO==========\n")

            s0, v, t = float(input("Me fale a Posição Inicial(m): ")), float(input("Me fale a Velocidade(m/s): ")), float(input("Me fale o tempo(s): "))

            print(f"O Objeto se encontra na posição: {formulas.posicao} m em realção ao referenacial.\n ")

        if operacao == 4:
            print("==========VELOCIADE COM ACELERAÇÃO==========\n")

            v0, a, t = float(input("Me fale a velocidade inicical(m/s): ")), float(input("Me fale a aceleração(m/s2): ")), float(input("Me fale o tempo(s): "))

            print(f"A velocidade final é de: {formulas.velocidade_a(v0, a, t)} m/s\n")
        
        if operacao == 5:
            print("=========POSIÇÃO DO OBJETO COM ACELERAÇÃO==========S\n")

            s0, v0, t, a = float(input("Me fale a Posição Inicial(m): ")), float(input("Me fale a velocidade Inical(m/s): ")), float(input("Me Fale o tempo(s): ")), float(input("Me fale a aceleração(m/s2): "))

            print(f"A posição final será: {formulas.posicao_a(s0, v0, t, a)} m \n")

        if operacao == 6:
            print("=========FORÇA==========\n")

            m, a = float(input("Me fale a Massa(kg): ")), float(input("Me fale aceleração(m/s2): "))

            print(f"A força Resultante é de: {formulas.forca(m, a)} N \n")

        if operacao == 7:
            print("==========PESO==========\n")

            m, a = float(input("Me fale a massa(kg): ")), float(input("Me fale a gravidade(m/s2): "))

            print(f"A força Peso Resultante é de: {formulas.peso(m, a)} N \n")

        if operacao == 8:
            print("==========TRABALHO==========\n")

            f, d, cos0 = float(input("Me fale e força(N): ")), float(input("Me fale a distância(m): ")), float(input("Me fale o Cosseno0: "))

            print(f"O trabalho resultante é de: {formulas.trabalho} W \n")

        if operacao == 9:
            print("==========ENERGIA CINÉTICA==========\n")

            m, v = float(input("Me de a massa(kg): ")), float(input("Me de a Velocidad(m/s): "))

            print(f"A energia cinética resultante é de: {formulas.cinetica(m, v)} Joules \n")

        if operacao == 10:
            print("==========ENERGIA GRAVITACIONAL==========\n")

            m, g, h = float(input("Me fale a massa(kg): ")), float(input("Me fale a gravidade(m/s2): ")), float(input("Me fale a altura: "))

            print(f"A enegergia gravitacional resultante é de: {formulas.gravitacional(m, g, h)} Joules \n")

if __name__== "__main__":
    main()
