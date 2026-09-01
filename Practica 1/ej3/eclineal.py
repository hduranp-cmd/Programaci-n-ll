class EcuacionLineal:
    def __init__(self,a,b,c):
        self.__a=a
        self.__b=b
        self.__c=c
    def getDiscriminante(self):
        dis=self.__b**2-4*self.__a*self.__c
        return dis
    def getRaiz1(self):
        return((-self.__b+(self.__b**2-4*self.__a*self.__c)**0.5)/(2*self.__a))
        
    def getRaiz2(self):
        return((-self.__b-(self.__b**2-4*self.__a*self.__c)**0.5)/(2*self.__a))
        

ec1=EcuacionLineal(float(input()),float(input()),float(input()))
if ec1.getDiscriminante()>0:
    print('Las dos raices son: ')
    print(ec1.getRaiz1())
    print(ec1.getRaiz2())
elif ec1.getDiscriminante()==0:
    print('La unica raiz es: ')
    print(ec1.getRaiz1())
elif ec1.getDiscriminante()<0:
    print('la ecuacion no tiene soluciones')


