<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/mobile.css" media="(max-width: 939px)">  
	<link rel="stylesheet" type="text/css" href="../css/estilo.css">
	<link rel="stylesheet" type="text/css" href="../css/produto.css">
	<title>Mirror Fashion</title>
</head>

<body>
<!-- Inclusão do cabeçalho com php -->
	<?php include("cabecalho.php"); ?>

	<div class="container">
		<div class="produto">
			<h1>Fuzzy Cardigan</h1>
			<p>Por apenas R$ 129,00</p>

			<form action="checkout.php" method="POST">
<!--Inicio do fildeset -->
				<fieldset class="cores">
					<legend>Esolha a Cor: </legend>
					<input type="radio" name="cor" value="verde" id="verde" checked>
					<label for="verde">
						<img src="../assets/img/produtos/foto2-verde.png" alt="Verde">
					</label>

					<input type="radio" name="cor" value="rosa" id="rosa">
					<label for="rosa">
						<img src="../assets/img/produtos/foto2-rosa.png" alt="rosa">
					</label>

					<input type="radio" name="cor" value="azul" id="azul">
					<label for="azul">
						<img src="../assets/img/produtos/foto2-azul.png" alt="azul">
					</label>
				</fieldset>

				<fieldset class="tamanhos">
					<legend>Escolha o tamanho:</legend>
					<input type="range" min="36" max="46" value="42" step="2" name="tamanho" id="tamanho">
				</fieldset>
	<!--Fim do Fildset e bloco do Submit-->
				<input type="submit" class="comprar" value="Comprar">
				<input type="hidden" name="nome" value="Fuzzy Cardigan">
			</form>
		</div>
		<div class="detalhes"> 
			<h2>Detalhes dos Produtos</h2>
			<p>Esse é o melhor casaco de Cardigã que você já viu. Excelente
			material italiano com estampa desenhada pelos artesãos da
			comunidade de Krotor nas ilhas gregas. Compre já e receba hoje
			mesmo pela nossa entrega a jato.</p>
		</div>
		<table>
			<thead>
				<th>
					<th>Características</th>
					<th>Detalhes</th>
				</th>
				<tr>
					<td>Material</td>
					<td>Algodão e poliester</td>
				</tr>
				<tr>
					<td>Cores</td>
					<td>Azul, Rosa e Verde</td>
				</tr>
				<tr>
					<td>Lavagem</td>
					<td>Lavar a mão</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Modelo</td>
					<td>Cardigã 7845</td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- Inclusão do rodapé com php -->
	<?php include("rodape.php"); ?>

</body>