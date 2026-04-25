import pygame
import sys
import math
import random

from src.adivinhacao import jogar_adivinhacao
from src.jogo_da_forca import jogo_da_forca
from src.labirinto import jogar_labirinto
from src.pac_man import jogar_pacman
from src.snake import snake
from src.space_shooter import space_shooter

pygame.init()

LARGURA = 1000
ALTURA = 700
tela = pygame.display.set_mode((LARGURA, ALTURA))
pygame.display.set_caption("🎮 Hub de Jogos - Mapa de Aventura")

"""Montando o cenário com base no padrão RGB """
AZUL_CEU = (135, 206, 235)
VERDE_GRAMA = (34, 139, 34)
MARROM_TERRA = (139, 69, 19)
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
BRANCO = (255, 255, 255)
PRETO = (0, 0, 0)
AZUL = (0, 100, 255)
VERDE = (0, 255, 0)
ROXO = (128, 0, 128)
LARANJA = (255, 165, 0)
ROSA = (255, 192, 203)
CINZA = (128, 128, 128)


fonte_grande = pygame.font.Font(None, 36)
fonte_media = pygame.font.Font(None, 28)
fonte_pequena = pygame.font.Font(None, 24)

class Nuvem:
    def __init__(self, x, y, velocidade):
        self.x = x
        self.y = y
        self.velocidade = velocidade
        
    def mover(self):
        self.x += self.velocidade
        if self.x > LARGURA + 100:
            self.x = -100
            
    def desenhar(self, tela):
        # Desenhar nuvem simples
        pygame.draw.circle(tela, BRANCO, (int(self.x), int(self.y)), 30)
        pygame.draw.circle(tela, BRANCO, (int(self.x + 25), int(self.y)), 35)
        pygame.draw.circle(tela, BRANCO, (int(self.x + 50), int(self.y)), 30)
        pygame.draw.circle(tela, BRANCO, (int(self.x + 25), int(self.y - 20)), 25)

class Avatar:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.tamanho = 20
        self.velocidade = 3
        self.animacao = 0
        
    def mover(self, dx, dy):
        nova_x = self.x + dx * self.velocidade
        nova_y = self.y + dy * self.velocidade
        
        # Manter dentro da tela
        if 50 <= nova_x <= LARGURA - 50:
            self.x = nova_x
        if 50 <= nova_y <= ALTURA - 50:
            self.y = nova_y
            
        if dx != 0 or dy != 0:
            self.animacao += 0.3
    
    def desenhar(self, tela):
        # Corpo do personagem (círculo azul)
        bounce = math.sin(self.animacao) * 2
        pygame.draw.circle(tela, AZUL, (int(self.x), int(self.y + bounce)), self.tamanho)
        
        # Olhos
        pygame.draw.circle(tela, BRANCO, (int(self.x - 8), int(self.y - 5 + bounce)), 4)
        pygame.draw.circle(tela, BRANCO, (int(self.x + 8), int(self.y - 5 + bounce)), 4)
        pygame.draw.circle(tela, PRETO, (int(self.x - 8), int(self.y - 5 + bounce)), 2)
        pygame.draw.circle(tela, PRETO, (int(self.x + 8), int(self.y - 5 + bounce)), 2)
        
        # Sorriso
        pygame.draw.arc(tela, PRETO, (self.x - 10, self.y - 2 + bounce, 20, 15), 0, math.pi, 2)

class PontoJogo:
    def __init__(self, x, y, nome, funcao, cor, emoji):
        self.x = x
        self.y = y
        self.nome = nome
        self.funcao = funcao
        self.cor = cor
        self.emoji = emoji
        self.raio = 25
        self.brilho = 0
        self.pulsacao = 0
        
    def esta_proximo(self, avatar):
        distancia = math.sqrt((self.x - avatar.x)**2 + (self.y - avatar.y)**2)
        return distancia < 40
    
    def desenhar(self, tela, proximo=False):
        self.pulsacao += 0.1
        
        if proximo:
            self.brilho = min(self.brilho + 5, 50)
            # Efeito de brilho
            for i in range(3):
                pygame.draw.circle(tela, (*self.cor, 100), (int(self.x), int(self.y)), 
                                 self.raio + 10 + i * 5)
        else:
            self.brilho = max(self.brilho - 5, 0)
        
        # Pulsação
        raio_atual = self.raio + math.sin(self.pulsacao) * 3
        
        # Círculo principal
        pygame.draw.circle(tela, self.cor, (int(self.x), int(self.y)), int(raio_atual))
        pygame.draw.circle(tela, BRANCO, (int(self.x), int(self.y)), int(raio_atual), 3)
        
        # Emoji/Símbolo no centro
        texto_emoji = fonte_media.render(self.emoji, True, BRANCO)
        rect_emoji = texto_emoji.get_rect(center=(self.x, self.y))
        tela.blit(texto_emoji, rect_emoji)

def desenhar_cenario(tela, nuvens):
    # Céu
    tela.fill(AZUL_CEU)
    
    # Nuvens
    for nuvem in nuvens:
        nuvem.mover()
        nuvem.desenhar(tela)
    
    # Montanhas no fundo
    pontos_montanha1 = [(0, 400), (150, 300), (300, 350), (450, 280), (600, 320), (LARGURA, 380), (LARGURA, ALTURA), (0, ALTURA)]
    pygame.draw.polygon(tela, (100, 100, 100), pontos_montanha1)
    
    pontos_montanha2 = [(200, 450), (350, 350), (500, 400), (650, 330), (800, 380), (LARGURA, 420), (LARGURA, ALTURA), (200, ALTURA)]
    pygame.draw.polygon(tela, (120, 120, 120), pontos_montanha2)
    
    # Grama
    pygame.draw.rect(tela, VERDE_GRAMA, (0, ALTURA - 100, LARGURA, 100))
    
    # Árvores decorativas
    arvores = [(100, ALTURA - 100), (300, ALTURA - 100), (700, ALTURA - 100), (900, ALTURA - 100)]
    for x, y in arvores:
        # Tronco
        pygame.draw.rect(tela, MARROM_TERRA, (x - 10, y - 50, 20, 50))
        # Copa
        pygame.draw.circle(tela, (0, 100, 0), (x, y - 60), 30)
    
    # Caminhos conectando os pontos
    caminhos = [
        (150, 500, 300, 400),  # Adivinhação -> Forca
        (300, 400, 500, 300),  # Forca -> Labirinto
        (500, 300, 700, 200),  # Labirinto -> Pac-Man
        (700, 200, 850, 300),  # Pac-Man -> Snake
        (850, 300, 750, 450),  # Snake -> Space Shooter
        (750, 450, 900, 550),  # Space Shooter -> Sair
    ]
    
    for x1, y1, x2, y2 in caminhos:
        pygame.draw.line(tela, MARROM_TERRA, (x1, y1), (x2, y2), 8)
        pygame.draw.line(tela, AMARELO, (x1, y1), (x2, y2), 4)

def main():
    clock = pygame.time.Clock()
    
    global tela
    
    # Criar avatar
    avatar = Avatar(150, 500)
    
    # Criar nuvens
    nuvens = [
        Nuvem(100, 80, 0.5),
        Nuvem(400, 120, 0.3),
        Nuvem(700, 60, 0.7),
    ]
    
    # Criar pontos dos jogos
    pontos = [
        PontoJogo(150, 500, "Jogo da Adivinhação", jogar_adivinhacao, VERDE, "🎯"),
        PontoJogo(300, 400, "Jogo da Forca", jogo_da_forca, ROXO, "🔤"),
        PontoJogo(500, 300, "Labirinto", jogar_labirinto, LARANJA, "🌀"),
        PontoJogo(700, 200, "Pac-Man", jogar_pacman, AMARELO, "👻"),
        PontoJogo(850, 300, "Snake", snake, VERDE, "🐍"),
        PontoJogo(750, 450, "Space Shooter", space_shooter, AZUL, "🚀"),
        PontoJogo(900, 550, "Sair", None, VERMELHO, "❌"),
    ]
    
    ponto_proximo = None
    
    rodando = True
    while rodando:
        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                rodando = False
            
            elif evento.type == pygame.KEYDOWN:
                if evento.key == pygame.K_RETURN and ponto_proximo:
                    if ponto_proximo.nome == "Sair":
                        rodando = False
                    else:
                        # Executar o jogo
                        try:
                            pygame.quit()
                            ponto_proximo.funcao()
                            # Reinicializar pygame após o jogo
                            pygame.init()
                            tela = pygame.display.set_mode((LARGURA, ALTURA))
                            pygame.display.set_caption("🎮 Hub de Jogos - Mapa de Aventura")
                        except Exception as e:
                            print(f"Erro ao executar {ponto_proximo.nome}: {e}")
                            pygame.init()
                            tela = pygame.display.set_mode((LARGURA, ALTURA))
                            pygame.display.set_caption("🎮 Hub de Jogos - Mapa de Aventura")
        
        # Controles do avatar
        teclas = pygame.key.get_pressed()
        dx = dy = 0
        if teclas[pygame.K_LEFT] or teclas[pygame.K_a]:
            dx = -1
        if teclas[pygame.K_RIGHT] or teclas[pygame.K_d]:
            dx = 1
        if teclas[pygame.K_UP] or teclas[pygame.K_w]:
            dy = -1
        if teclas[pygame.K_DOWN] or teclas[pygame.K_s]:
            dy = 1
        
        avatar.mover(dx, dy)
        
        # Verificar proximidade com pontos
        ponto_proximo = None
        for ponto in pontos:
            if ponto.esta_proximo(avatar):
                ponto_proximo = ponto
                break
        
        # Desenhar tudo
        desenhar_cenario(tela, nuvens)
        
        # Desenhar pontos
        for ponto in pontos:
            ponto.desenhar(tela, ponto == ponto_proximo)
        
        # Desenhar avatar
        avatar.desenhar(tela)
        
        # Interface
        if ponto_proximo:
            # Mostrar nome do jogo
            texto = fonte_grande.render(ponto_proximo.nome, True, BRANCO)
            rect_texto = texto.get_rect(center=(LARGURA // 2, 50))
            pygame.draw.rect(tela, PRETO, rect_texto.inflate(20, 10))
            tela.blit(texto, rect_texto)
            
            # Instrução
            instrucao = fonte_media.render("Pressione ENTER para jogar", True, BRANCO)
            rect_instrucao = instrucao.get_rect(center=(LARGURA // 2, 80))
            tela.blit(instrucao, rect_instrucao)
        
        # Controles
        controles = fonte_pequena.render("Use WASD ou setas para mover", True, BRANCO)
        tela.blit(controles, (10, ALTURA - 30))
        
        pygame.display.flip()
        clock.tick(60)
    
    pygame.quit()
    sys.exit()

if __name__ == "__main__":
    main()
