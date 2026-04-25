class Carro:
	def __init__(self, cor, marca, modelo, ID):
		self.__cor = cor
		self.__marca = marca
		self.__modelo = modelo
		self.__ID = ID
		self.__status = "Não Vendido"

	def get_status(self):
		return self.__status
	def set_status(self, status):
		self.__status = status