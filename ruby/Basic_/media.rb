puts("Digite a primeira nota: ")
nota1 = gets.to_f
puts("Digite a Segunda Nota: ")
nota2 = gets.to_f
puts("Digite a Terceira Nota: ")
nota3 = gets.to_f
puts('Digite a Quarta Nota: ')
nota4 = gets.to_f

media = (nota1 + nota2 + nota3 + nota4)/ 4

puts("Sua Média foi: #{media}")
if(media >= 6)
	puts("Você foi Aprovado!!!!")
else
	puts("Você foi Reprovado :(")
end