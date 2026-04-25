teste = "Hello, Word!"

idade = 19

puts idade.class
puts teste.class

def soma(a, b) return a + b end

puts soma(78, 4)


class String
    def plural
        "#{self}s"
    end
end

puts "caneta".plural

espera = "#{sleep 1} 4 segundos depois ele execulda"

puts espera

if idade > 18
    puts "Voce é maior de idade"
end
