<?php
session_start();

function adicionarAoCarrinho($id) {
    if(!isset($_SESSION['carrinho'])) {
        $_SESSION['carrinho'] = [];
    }
    
    // Se o produto já está lá, aumenta a quantidade
    if(isset($_SESSION['carrinho'][$id])) {
        $_SESSION['carrinho'][$id]++;
    } else {
        $_SESSION['carrinho'][$id] = 1;
    }
}