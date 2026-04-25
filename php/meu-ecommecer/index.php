<?php
// 1. INÍCIO DA SESSÃO (Essencial para o carrinho de compras)
session_start();

// 2. CONEXÃO COM O BANCO DE DADOS
$host = 'localhost';
$user = 'root';
$pass = '';
$db   = 'loja_virtual';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$db", $user, $pass);
} catch (PDOException $e) {
    die("Erro ao conectar: " . $e->getMessage());
}

// 3. LÓGICA DO CARRINHO (Adicionar itens)
if (isset($_GET['adicionar'])) {
    $id_produto = (int)$_GET['adicionar'];
    
    // Se não existe o carrinho, cria um array vazio
    if (!isset($_SESSION['carrinho'])) {
        $_SESSION['carrinho'] = [];
    }

    // Adiciona o produto ou aumenta a quantidade
    if (isset($_SESSION['carrinho'][$id_produto])) {
        $_SESSION['carrinho'][$id_produto]++;
    } else {
        $_SESSION['carrinho'][$id_produto] = 1;
    }
    
    // Redireciona para limpar a URL
    header("Location: index.php");
    exit;
}

// 4. BUSCAR PRODUTOS NO BANCO
$stmt = $pdo->query("SELECT * FROM produtos");
$produtos = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Minha Loja PHP</title>
    <style>
        body { font-family: sans-serif; display: flex; gap: 20px; padding: 20px; }
        .vitrine { display: flex; gap: 10px; flex: 3; }
        .produto { border: 1px solid #ccc; padding: 10px; text-align: center; }
        .carrinho { border: 2px solid #333; padding: 15px; flex: 1; background: #f9f9f9; }
        button { background: green; color: white; border: none; padding: 5px 10px; cursor: pointer; }
    </style>
</head>
<body>

    <div class="vitrine">
        <?php foreach($produtos as $p): ?>
            <div class="produto">
                <img src="<?= $p['imagem'] ?>" alt="<?= $p['nome'] ?>">
                <h3><?= $p['nome'] ?></h3>
                <p>R$ <?= number_format($p['preco'], 2, ',', '.') ?></p>
                <a href="?adicionar=<?= $p['id'] ?>"><button>Adicionar ao Carrinho</button></a>
            </div>
        <?php endforeach; ?>
    </div>

    <div class="carrinho">
        <h2>Seu Carrinho</h2>
        <?php if (empty($_SESSION['carrinho'])): ?>
            <p>O carrinho está vazio.</p>
        <?php else: ?>
            <ul>
                <?php 
                $total = 0;
                foreach($_SESSION['carrinho'] as $id => $qtd): 
                    // Para cada item no carrinho, buscamos o nome e preço
                    $st = $pdo->prepare("SELECT nome, preco FROM produtos WHERE id = ?");
                    $st->execute([$id]);
                    $item = $st->fetch();
                    $subtotal = $item['preco'] * $qtd;
                    $total += $subtotal;
                ?>
                    <li>
                        <strong><?= $item['nome'] ?></strong> (<?= $qtd ?>x) <br>
                        Subtotal: R$ <?= number_format($subtotal, 2, ',', '.') ?>
                    </li>
                    <hr>
                <?php endforeach; ?>
            </ul>
            <h3>Total: R$ <?= number_format($total, 2, ',', '.') ?></h3>
            <a href="limpar.php"><button style="background: red;">Esvaziar Carrinho</button></a>
        <?php endif; ?>
    </div>

</body>
</html>