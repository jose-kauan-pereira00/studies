puts("Insira a Base: ")
base = gets

puts("Insira a altura: ")
altura = gets

area = base.to_f * altura.to_f

puts("A área do Trinagulo é: #{area}")

puts("Digite O valor do angulo que voce deseja saber o seno e o cosseno: ")
angulo = gets
sen =  Math.sin(angulo.to_f * Math::PI / 180 )
cos =  Math.cos(angulo.to_f * Math::PI / 180 )

puts("Seno #{sen} e cosseno: #{cos}")
