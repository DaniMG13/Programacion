import tkinter as tk
import time
import threading

# Función para cambiar el estado de un semáforo
def cambiar_estado(semaforo, tiempo_rojo, tiempo_verde, tiempo_amarillo, estado_inicial):
    """if estado_inicial == 0:
        semaforo.itemconfig(luz_roja, fill="gray")
        semaforo.itemconfig(luz_amarilla, fill="gray")
        semaforo.itemconfig(luz_verde, fill="green")
        mensaje.set("Semáforo: Verde")
        root.update()
        time.sleep(tiempo_verde)
    else:
        semaforo.itemconfig(luz_roja, fill="red")
        semaforo.itemconfig(luz_amarilla, fill="gray")
        semaforo.itemconfig(luz_verde, fill="gray")
        mensaje.set("Semáforo: Rojo")
        root.update()
        time.sleep(tiempo_rojo)"""
    while True:
        semaforo.itemconfig(luz_roja, fill="gray")
        semaforo.itemconfig(luz_verde, fill="green")
        mensaje.set("Semáforo: Verde")
        root.update()
        time.sleep(tiempo_verde)
        
        semaforo.itemconfig(luz_verde, fill="gray")
        semaforo.itemconfig(luz_amarilla, fill="yellow")
        mensaje.set("Semáforo: Amarillo")
        root.update()
        time.sleep(tiempo_amarillo)

        semaforo.itemconfig(luz_roja, fill="red")
        semaforo.itemconfig(luz_amarilla, fill="gray")
        semaforo.itemconfig(luz_verde, fill="gray")
        mensaje.set("Semáforo: Rojo")
        root.update()
        time.sleep(tiempo_rojo)

def cambiar_estado2(semaforo, tiempo_rojo, tiempo_verde, tiempo_amarillo, estado_inicial):    
    while True:
        semaforo.itemconfig(luz_roja, fill="red")
        semaforo.itemconfig(luz_amarilla, fill="gray")
        semaforo.itemconfig(luz_verde, fill="gray")
        mensaje.set("Semáforo: Rojo")
        root.update()
        time.sleep(tiempo_rojo)

        semaforo.itemconfig(luz_roja, fill="gray")
        semaforo.itemconfig(luz_verde, fill="green")
        mensaje.set("Semáforo: Verde")
        root.update()
        time.sleep(tiempo_verde)
        
        semaforo.itemconfig(luz_verde, fill="gray")
        semaforo.itemconfig(luz_amarilla, fill="yellow")
        mensaje.set("Semáforo: Amarillo")
        root.update()
        time.sleep(tiempo_amarillo)

# Crear la ventana
root = tk.Tk()
root.title("Semáforos Peatones")

# Crear un título para los semáforos
titulo = tk.Label(root, text="Semáforos Peatones")
titulo.pack()

# Crear una variable de control para el mensaje
mensaje = tk.StringVar()
mensaje.set("Semáforo: Apagado")

# Crear etiqueta (label) para mostrar el mensaje
label = tk.Label(root, textvariable=mensaje)
label.pack()

# Crear un contenedor para los semáforos (frame vertical)
semaforos_container = tk.Frame(root)
semaforos_container.pack()

# Crear el lienzo (canvas) para el primer semáforo (vertical)
semaforoP = tk.Canvas(semaforos_container, width=100, height=300, bg="gray")
semaforoP.grid(row=0, column=0)
luz_roja = semaforoP.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla = semaforoP.create_oval(30, 110, 70, 150, fill="gray")
luz_verde = semaforoP.create_oval(30, 190, 70, 230, fill="gray")

# Crear el lienzo (canvas) para el segundo semáforo (vertical)
semaforoA = tk.Canvas(semaforos_container, width=100, height=300, bg="gray")
semaforoA.grid(row=0, column=1)
luz_roja2 = semaforoA.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla2 = semaforoA.create_oval(30, 110, 70, 150, fill="gray")
luz_verde2 = semaforoA.create_oval(30, 190, 70, 230, fill="gray")

# Crear el lienzo (canvas) para el tercer semáforo (vertical)
semaforoB = tk.Canvas(semaforos_container, width=100, height=300, bg="gray")
semaforoB.grid(row=0, column=2)
luz_roja3 = semaforoB.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla3 = semaforoB.create_oval(30, 110, 70, 150, fill="gray")
luz_verde3 = semaforoB.create_oval(30, 190, 70, 230, fill="gray")

thread1 = threading.Thread(target=cambiar_estado, args=(semaforoP, 21, 5, 1, 0))
thread2 = threading.Thread(target=cambiar_estado, args=(semaforoA, 17, 9, 1, 1))
thread3 = threading.Thread(target=cambiar_estado2, args=(semaforoB, 16, 10, 1, 1))

# Iniciar los hilos
thread1.start()
thread2.start()
thread3.start()

root.mainloop()