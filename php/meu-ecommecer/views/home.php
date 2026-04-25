<?php foreach($produtos as $p): ?>
    <div class="produto-card">
        <img src="<?= $p['imagem'] ?>">
        <h3><?= $p['nome'] ?></h3>
        <p>R$ <?= number_format($p['preco'], 2, ',', '.') ?></p>
        <a href="carrinho.php?add=<?= $p['id'] ?>">Comprar</a>
    </div>
<?php endforeach; ?>