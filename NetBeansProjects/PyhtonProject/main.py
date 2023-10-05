def random(self,min,max):
    return random.randint(min,max)

dtata = ["ID_TRABAJO|HORA_LLEGADA|TIEMPO_CPU|PRIORIDAD"]
pmin = 20
pmax = 100
p = random(pmin,pmax)
vsleep = 0
vmin = 1
vmax = 4
primin = 1
primax = 5
print(p)
#with open("datos.dat","w") as archivo:
