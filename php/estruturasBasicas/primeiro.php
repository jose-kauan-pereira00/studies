<?php

class Teste{
	function Nada(){
		echo "Nada aqui";
	}
}
echo "Hello World!!\n";
$cores = array(1 => "vermelho", 2 => "verde", "teste" => 1);
echo $cores[1];

$obj = new Teste;

$obj -> nada();


for($i = 0; $i > 15; $i++){
	echo $i;
}

?>
