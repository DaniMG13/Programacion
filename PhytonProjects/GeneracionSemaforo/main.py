import random
import datetime
import time
class Genera:
    id = 1
    datosMin = 50
    datosMax = 210
    prioriMin = 1
    prioriMax = 3
    sleepPeatonal = 1
    sleepVehiculos = 4
    sleepCiclista = 4

    def Hora(self):
        horaactual = datetime.datetime.now()
        auxiliar = ""+str(horaactual.hour).zfill(2)+":"+str(horaactual.minute).zfill(2)+":"+str(horaactual.second).zfill(2)
        return auxiliar

    def Tipo(self,priori):
        if(priori==1):
             auxiliar = "PEATON   "
        else:
            if(priori==2):
                auxiliar = "CICLISTA "
            else:
                auxiliar = "AUTOMOVIL"
        return auxiliar

    def Main(self):
        datos = random.randint(self.datosMin,self.datosMax)
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivo.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|T_TRAFICO|\n")
            archivo.close()
        for n in range(datos):
            aux = "|"+str(self.id).zfill(3)+"|"
            aux = aux + str(self.Hora())+"|"
            priori = random.randint(self.prioriMin,self.prioriMax)
            aux = aux + str(priori).zfill(1)
            aux = aux + "|"+self.Tipo(priori)+"|\n"
            self.id = self.id+1
            with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivo.dat","a") as archivo:
                archivo.write(aux)
            archivo.close()
            time.sleep(random.randint(1,4))

genera = Genera()
genera.Main()