class Comprador:
	def __init__(self, nome, cpf, telefone):
		self.__nome = nome
		self.__cpf = cpf
		self.__telefone = telefone

	def get_cpf(self):
		return self.__cpf
	
