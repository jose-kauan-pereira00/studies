import pygame
from pygame.locals import *
from sys import exit
from random import randint
from copy import deepcopy

largura = 960
altura = 640
largura_arena = 600
altura_arena = 400

branco = (255, 255, 255)
preto = (0, 0, 0)

def bloco_snake(tela, pos):
    blocos = []
    for i in range(len(pos)):
        blocos.append((pygame.draw.rect(tela, (0, 200, 50), (pos[i][0], pos[i][1], 5, 5))))
    return blocos

def snake():
    pygame.init()
    pygame.display.set_caption('Snake')
    tela = pygame.display.set_mode((largura, altura))
    clock = pygame.time.Clock()
    
    fonte_menor = pygame.font.SysFont(None, 25, True, False)
    fonte = pygame.font.SysFont(None, 30, True, True)
    fonte_maior = pygame.font.SysFont(None, 50, True, True)
    
    x_snake = 400
    y_snake = 400
    posicoes = [[400, 400], [405, 400], [410, 400], [415, 400],
                [420, 400], [425, 400], [430, 400]]
    posicoes_inicio = deepcopy(posicoes)

    cima = False
    baixo = False
    esquerda = False
    direita = True

    pontos = 0
    pontuou = True
    fim = False

    while True:
        tela.fill(preto)

        for event in pygame.event.get():
            if event.type == QUIT or pygame.key.get_pressed()[K_ESCAPE]:
                pygame.quit()
                exit()

            if not fim and event.type == KEYDOWN:
                if (event.key == pygame.K_w or event.key == pygame.K_UP) and not baixo:
                    cima = True
                    baixo = esquerda = direita = False
                elif (event.key == pygame.K_s or event.key == pygame.K_DOWN) and not cima:
                    baixo = True
                    cima = esquerda = direita = False
                elif (event.key == pygame.K_a or event.key == pygame.K_LEFT) and not direita:
                    esquerda = True
                    cima = baixo = direito = False
                elif (event.key == pygame.K_d or event.key == pygame.K_RIGHT) and not esquerda:
                    direita = True
                    cima = baixo = esquerda = False

        arena = pygame.Rect(0, 0, largura_arena, altura_arena)
        arena.center = (largura // 2, altura // 2)
        pygame.draw.rect(tela, branco, arena, 5)

        if not fim:
            if cima:
                y_snake -= 5
            elif baixo:
                y_snake += 5
            elif esquerda:
                x_snake -= 5
            elif direita:
                x_snake += 5
        
        if (x_snake <= arena.left + 5) or (x_snake >= arena.right - 10):
            fim = True
        if (y_snake <= arena.top + 5) or (y_snake >= arena.bottom - 10):
            fim = True

        if pontuou:
            x_comida = randint(arena.left + 20, arena.right - 20)
            y_comida = randint(arena.top + 20, arena.bottom - 20)
            pontuou = False

        comida = pygame.draw.rect(tela, (200, 30, 30), (x_comida, y_comida, 15, 15))
        blocos = bloco_snake(tela, posicoes)

        cabeca = blocos[-1]
        if cabeca.colliderect(comida):
            pontos += 1
            pontuou = True

        for i in range(len(blocos) - 1):
            if cabeca.colliderect(blocos[i]) and pontos > 0:
                fim = True

        posicoes.append([x_snake, y_snake])
        if not pontuou and not fim:
            posicoes.pop(0)

        pontos_display = f'Pontos: {pontos}'
        pontos_display = fonte.render(pontos_display, True, branco)
        tela.blit(pontos_display, (30, 40))

        esc_display = 'Pressione ESC para voltar ao menu'
        esc_display = fonte_menor.render(esc_display, True, (0, 100, 200))
        esc_display_rect = esc_display.get_rect(center=(480, 600))
        tela.blit(esc_display, esc_display_rect)

        if fim:
            fim_display = fonte_maior.render('GAME OVER', True, branco)
            fim_rect = fim_display.get_rect(center=(480, 70))
            tela.blit(fim_display, fim_rect)

            R_display = 'Pressione R para reiniciar'
            R_display = fonte_menor.render(R_display, True, (0, 100, 200))
            R_display_rect = R_display.get_rect(center=(480, 560))
            tela.blit(R_display, R_display_rect)

            if pygame.key.get_pressed()[K_r]:
                fim = False
                pontuou = True
                pontos = 0
                x_snake = y_snake = 400
                posicoes = deepcopy(posicoes_inicio)
                direita = True
                cima = baixo = esquerda = False

        clock.tick(60)
        pygame.display.update()

