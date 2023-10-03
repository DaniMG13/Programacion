class Prioridad:

    def __init__ (self):
        self.items = []

    def isEmpty(self):
        return self.items == []
    
    def Agregar(self,dato):
        if(self.isEmpty()):
            for n in self.items:
                if(n[3]<dato[3]):
                    self.items.add(dato,n)
        else:
            self.items.__add__(dato)
    
    def Imprimir(self):
        print("\nCola\n")
        for n in self.items:
            print(n)

veri = 0
priori = Prioridad()
array = []
with open("archivo.dat","r") as archivo:
    for line in archivo:
        if(veri==0):
            print("")
            veri = veri+1
        else:
            print(line)
            array.add(line)
            priori.Agregar(array)

priori.Imprimir()