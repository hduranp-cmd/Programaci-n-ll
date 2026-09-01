def promedio(lis):
    sum=0
    for i in range(0,len(lis)):
        sum=sum+lis[i]
    prom=sum/10
    return prom
def desviacion(lis,prom):
    suma=0
    for i in range(0,len(lis)):
        suma=suma+((lis[i]-prom)**2)
    des=(suma/(9))**0.5
    return des


lis=[]
for a in range(0,10):
    lis.append(float(input()))

print('El promedio es: ', promedio(lis))
print('La desviacion estandar es: ', desviacion(lis,promedio(lis)))


