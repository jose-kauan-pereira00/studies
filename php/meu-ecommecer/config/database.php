<?php

$host = 'localhost';
$db   = 'ecommerce';
$user = 'root';
$pass = '';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$db;charset=utf8", $user, $pass);
} catch (PDOException $e) {
    die("Erro ao conectar: " . $e->getMessage());
}