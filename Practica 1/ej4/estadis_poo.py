class Estadistica:
    def __init__(self,lis):
        self.__lis=lis
    def promedio(self):
        sum=0
        for i in range(0,len(self.__lis)):
            sum=sum+self.__lis[i]
        prom=sum/10
        return prom
    def desviacion(self):
        suma=0
        prom = self.promedio()
        for i in range(0,len(self.__lis)):
            suma=suma+((self.__lis[i]-prom)**2)
        des=(suma/(9))**0.5
        return des
    

lis=[]
for a in range(0,10):
    lis.append(float(input()))

estadis1=Estadistica(lis)
print('El promedio es ', estadis1.promedio())
print('La desviacion es: ', estadis1.desviacion())