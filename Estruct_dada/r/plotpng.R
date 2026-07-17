library('ggplot2')

args <- commandArgs(trailingOnly = TRUE)

if (length(args) == 0) {
  stop("Erro: Você precisa passar o caminho do arquivo de dados")
}

data = read.table(args[1], header = TRUE)

ggplot(data, aes(x = TamanhoEntrada, y = TempoMedio, colour = Algoritmo)) + 
  geom_line() +
  ggsave("grafico.png") 