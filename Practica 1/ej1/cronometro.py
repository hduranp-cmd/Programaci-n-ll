import time
import random

class Cronometro:
    def __init__(self):
        self.__inicia = time.time()
        self.__finaliza = 0

    def get_inicia(self):
        return self.__inicia

    def get_finaliza(self):
        return self.__finaliza

    def inicia(self):
        self.__inicia = time.time()
        self.__finaliza = 0

    def detener(self):
        self.__finaliza = time.time()

    def lapsoDeTiempo(self):
        return (self.__finaliza - self.__inicia) * 1000


def ordenacion_por_seleccion(lista):
    n = len(lista)
    for i in range(n):
        mini = i
        for j in range(i + 1, n):
            if lista[j] < lista[mini]:
                mini = j
        lista[i], lista[mini] = lista[mini], lista[i]

numeros = [random.randint(1, 100000) for _ in range(100000)]

reloj = Cronometro()
reloj.inicia()

ordenacion_por_seleccion(numeros)

reloj.detener()

print(reloj.lapsoDeTiempo())