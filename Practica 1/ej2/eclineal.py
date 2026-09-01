class Eclineal:
    def __init__(self,a,b,c,d,e,f):
        self.__a = a
        self.__b = b
        self.__c = c
        self.__d = d
        self.__e = e
        self.__f = f
    def tieneSolucion(self):
        if (self.__a * self.__d) - (self.__b * self.__c) != 0:
            return True
        else:
            return False
    def getX(self):
        if self.tieneSolucion()==False:
            return "La ecuación no tiene solución."
        x = (self.__e * self.__d - self.__b * self.__f) / (self.__a * self.__d - self.__b * self.__c)
        return x
    def getY(self):
        if self.tieneSolucion()==False:
            return "La ecuación no tiene solución."
        y = (self.__a * self.__f - self.__e * self.__c) / (self.__a * self.__d - self.__b * self.__c)
        return y

a=int(input())
b=int(input())
c=int(input())
d=int(input())
e=int(input())
f=int(input())
ec=Eclineal(a,b,c,d,e,f)
print('x= ',ec.getX(),'y= ',ec.getY())



