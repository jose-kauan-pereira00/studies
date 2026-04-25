 library('ggplot2')

args <- commandArgs()
data = read.table(args[length(args)], header = T)
ggplot(data, aes(x = TamanhoEntrada, y = TempoMedio, colour = Algoritmo)) + geom_line()
 
 
 
