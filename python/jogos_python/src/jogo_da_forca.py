import pygame
from pygame.locals import *
from random import choice
from sys import exit

branco = (255, 255, 255)
preto = (0, 0, 0)
largura = 960
altura = 640
def desenho_erro(tela, erros):
    if erros >= 1:
        pygame.draw.circle(tela, preto, (170, 200), 30, 8)
    if erros >= 2:
        pygame.draw.line(tela, preto, (170, 230), (170, 300), 8)
    if erros >= 3:
        pygame.draw.line(tela, preto, (170, 230), (200, 280), 8)
    if erros >= 4:
        pygame.draw.line(tela, preto, (170, 230), (140, 280), 8)
    if erros >= 5:
        pygame.draw.line(tela, preto, (170, 300), (200, 350), 8)
    if erros == 6:
        pygame.draw.line(tela, preto, (170, 300), (140, 350), 8)

def alpha_verify(string):
    alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    if string in alphabet:
        return True
    return False

def jogo_da_forca():
    pygame.init()
    pygame.display.set_caption('Jogo da Forca')
    tela = pygame.display.set_mode((largura, altura))
    fonte = pygame.font.SysFont(None, 70, True, False)
    fonte_menor = pygame.font.SysFont(None, 40, True, False)
    fonte_smallest = pygame.font.SysFont(None, 30, True, False)
    clock = pygame.time.Clock()
    erros = 0

    palavras = [
    "ABACAXI",
    "GIRASSOL",
    "TARTARUGA",
    "ESFINGE",
    "PIRAMIDE",
    "CACHOEIRA",
    "LABIRINTO",
    "VASSOURA",
    "RELOGIO",
    "FOGUETE"
    ]

    palavra_escolhida = choice(palavras)
    palpites = ''
    fim = False

    while True:
        for event in pygame.event.get():
            if event.type == QUIT or pygame.key.get_pressed()[K_ESCAPE]:
                pygame.quit()
                exit()

            if event.type == KEYDOWN:
                letra = str(pygame.key.name(event.key)).upper()
                if fim:
                    if letra == 'R':
                        palavra_escolhida = choice(palavras)
                        erros = 0
                        palpites = ''
                        fim = False

                elif alpha_verify(letra) and letra not in palpites:
                    palpites += letra + ' '
                    if letra not in palavra_escolhida:
                        erros += 1

        display_palavra = ''
        for l in palavra_escolhida:
            if l in palpites:
                display_palavra += l + ' '
            else:
                display_palavra += '_ '

            if erros == 6 or display_palavra.split() == list(palavra_escolhida):
                fim = True
            
        display_palavra = fonte.render(display_palavra, True, preto)
        display_palpites = fonte_menor.render(f'Palpites:  {palpites}', True, preto)

        tela.fill(branco)
        pygame.draw.line(tela, preto, (70, 120), (70, 440), 10)
        pygame.draw.line(tela, preto, (30, 440), (110, 440), 10)
        pygame.draw.line(tela, preto, (70, 120), (170, 120), 10)
        pygame.draw.line(tela, preto, (170, 120), (170, 170), 10)
        desenho_erro(tela, erros)
        tela.blit(display_palavra, (280, 350))
        if len(palpites) > 0:
            tela.blit(display_palpites, (50, 40))
        if fim:
            display_fim = 'Pressione R para reiniciar'
            display_fim = fonte_smallest.render(display_fim, True, (0, 100, 200))
            display_fim_rect = display_fim.get_rect(center=(480, 520))
            tela.blit(display_fim, display_fim_rect)

        display_esc = 'Pressione ESC para voltar ao menu'
        display_esc = fonte_smallest.render(display_esc, True, (0, 100, 200))
        display_esc_rect = display_esc.get_rect(center=(480, 560))
        tela.blit(display_esc, display_esc_rect)

        clock.tick(60)
        pygame.display.update()
