#!/bin/bash

# Loop para gerar as 200 linhas
for i in {1..200}; do
    # Define um tamanho aleatório para o array desta linha (entre 1 e 500)
    TAMANHO=$(( (RANDOM % 500) + 1 ))
    
    # Loop interno para gerar os números daquela linha
    for j in $(seq $TAMANHO); do
        # Imprime um número aleatório seguido de um espaço, sem pular linha
        echo -n "$RANDOM "
    done
    
    # Após terminar o array, imprime uma quebra de linha
    echo ""
done