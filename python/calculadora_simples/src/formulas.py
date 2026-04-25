#======Matemática=====================
def baskara(a, b, c):
    delta = (b**2) - 4 * a * c

    if delta < 0:
        return "Delta é Negativo, não exite solução nos Reais, Tente outros valores. \n"

    x1 = (-b + (delta**(1/2))) / (2 * a)
    x2 = (-b - (delta**(1/2))) / (2 * a)
    
    resultado = (x1, x2)

    return resultado 

#===MRU==============
def velocidade(s, t):
    operacao = s / t
    
    if operacao < 0:
        resultado = f"A velocidade foi de {operacao} m/s, estar no sentido contrario do referncial."
        return resultado

    return s / t

def posicao(s0, v, t):
    return s0 + v * t
#=======MRUA======
def velocidade_a(v0, a, t):
    return v0 + a * t

def posicao_a(s0, v0, t, a):
    return s0 + v0 * t + ((1/2)* a * t**2)

def forca(m, a):
    return m * a

def peso(m, g):
    return m *g

def trabalho(f, d, cos0):
    return f * d * cos0

#========Energia========
def cinetica(m, v):
    return (1/2) * m * v**2

def gravitacional(m, g, h):
    return m * g * h




