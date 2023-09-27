class Canciones:
    canciones=[]
    def _init_(self):
        self.canciones=[]

    def agregar(self, song):
        self.canciones.append(song)

    def eliminar(self):
        self.canciones.pop()
        self.escribirPop()

    def contenido(self):
        for n in self.canciones:
            print(n)
                
    def leer(self):
        with open("historial.dat","r") as archivo:
            for linea in archivo:
                self.agre(linea.strip())

    def escribir(self):
        with open("historial.dat","a") as archivo:
            for n in self.canciones:
                archivo.write("\n"+n)

    def escribirPop(self):
        self.limpiarArchivo()
        with open("historial.dat","w") as archivo:
            for n in self.canciones:
                archivo.write(n+"\n")   

    def limpiarArchivo(self):
        with open("historial.dat","w") as archivo:
            archivo.write("")                    

historial = Historial()
historial.contenido()
historial.leer()
print("\nContenido del archivo original")
historial.contenido()
historial.visitar("https://www.postgresql.org")
historial.visitar("https://celayatecnm.mx")
historial.visitar("https://sii.itcelaya.edu")
historial.visitar("https://www.gmail.com")
print("\nContenido agregando paginas")
historial.contenido()
historial.escribir()
historial.retroceder()
print("\nContenido despues del pop")
historial.contenido()
