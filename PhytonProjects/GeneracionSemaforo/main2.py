class Procesar:
    def Leer(self):
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoPetaon.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|T_TRAFICO|\n")
        archivo.close()
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoCiclista.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|T_TRAFICO|\n")
        archivo.close()
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoAuto.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|T_TRAFICO|\n")
        archivo.close()
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivo.dat","r") as archivo:
            linea = archivo.__next__()
            for linea in archivo:
                array = linea.split("|")
                if(array[3]=="1"):
                    with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoPetaon.dat","a") as archivo:
                        archivo.write(linea)
                    archivo.close()
                if(array[3]=="2"):
                    with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoCiclista.dat","a") as archivo:
                        archivo.write(linea)
                    archivo.close()
                if(array[3]=="3"):
                    with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoAuto.dat","a") as archivo:
                        archivo.write(linea)
                    archivo.close()        
                    

procesa = Procesar()
procesa.Leer()