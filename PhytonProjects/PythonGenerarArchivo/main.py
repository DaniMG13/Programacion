import random
import datetime
import time

def Hora():
    horaactual = datetime.datetime.now()
    auxiliar = ""+str(horaactual.hour).zfill(2)+":"+str(horaactual.minute).zfill(2)+":"+str(horaactual.second).zfill(2)
    return auxiliar

id = 1
proyeMin = 20
proyeMax = 100
prioriMin = 1
prioriMax = 5
sleepMin = 1
sleepMax = 4
proceMin = 1
proceMax = 4
proye = random.randint(proyeMin,proyeMax)
##print("Proyectos:"+str(proye))
ban = 0
for n in range(proye):
    aux = str(id).zfill(2)+"|"
    aux = aux + str(Hora())+"|"
    priori = random.randint(prioriMin,prioriMax)
    sleep = random.randint(sleepMin,sleepMax)
    procesa = random.randint(proceMin,proceMax)
    aux = aux + str(sleep).zfill(2)+"|"+str(priori).zfill(2)+"\n"
    id = id+1
    print(aux)
    time.sleep(sleep)    
    with open("archivo.dat","a") as archivo:
        archivo.write(aux)
        archivo.close()    