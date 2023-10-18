import tkinter as tk
import time
import threading

# Función para cambiar el estado de un semáforo
def cambiar_estado(semaforo, tiempo_rojo, tiempo_verde, tiempo_amarillo):
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
canvas1 = tk.Canvas(semaforos_container, width=100, height=300, bg="gray")
canvas1.grid(row=0, column=0)
luz_roja = canvas1.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla = canvas1.create_oval(30, 110, 70, 150, fill="gray")
luz_verde = canvas1.create_oval(30, 190, 70, 230, fill="gray")

# Crear el lienzo (canvas) para el segundo semáforo (vertical)
canvas2 = tk.Canvas(semaforos_container, width=100, height=300, bg="gray")
canvas2.grid(row=0, column=1)
luz_roja2 = canvas2.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla2 = canvas2.create_oval(30, 110, 70, 150, fill="gray")
luz_verde2 = canvas2.create_oval(30, 190, 70, 230, fill="gray")

# Crear el lienzo (canvas) para el tercer semáforo (vertical)
canvas3 = tk.Canvas(semaforos_container, width=100, height=300, bg="gray")
canvas3.grid(row=0, column=2)
luz_roja3 = canvas3.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla3 = canvas3.create_oval(30, 110, 70, 150, fill="gray")
luz_verde3 = canvas3.create_oval(30, 190, 70, 230, fill="gray")

thread1 = threading.Thread(target=cambiar_estado, args=(canvas1, 30, 33, 2))
thread2 = threading.Thread(target=cambiar_estado, args=(canvas2, 20, 25, 3))
thread3 = threading.Thread(target=cambiar_estado, args=(canvas3, 15, 35, 5))

# Iniciar los hilos
thread1.start()
thread2.start()
thread3.start()

root.mainloop()