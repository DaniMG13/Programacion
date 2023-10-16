import tkinter as tk
import time

# Función para cambiar el estado del semáforo
def cambiar_estado():
    canvas.itemconfig(luz_roja, fill="red")
    canvas.itemconfig(luz_amarilla, fill="gray")
    canvas.itemconfig(luz_verde, fill="gray")
    mensaje.set("Semáforo: Rojo")
    root.update()
    time.sleep(2)  # Espera 2 segundos
    canvas.itemconfig(luz_roja, fill="gray")
    canvas.itemconfig(luz_amarilla, fill="yellow")
    mensaje.set("Semáforo: Amarillo")
    root.update()
    time.sleep(1)  # Espera 1 segundo
    canvas.itemconfig(luz_amarilla, fill="gray")
    canvas.itemconfig(luz_verde, fill="green")
    mensaje.set("Semáforo: Verde")
    root.update()
    time.sleep(2)  # Espera 2 segundos
    canvas.itemconfig(luz_verde, fill="gray")
    canvas.itemconfig(luz_amarilla, fill="yellow")
    mensaje.set("Semáforo: Amarillo")
    root.update()
    time.sleep(1)  # Espera 1 segundo
    cambiar_estado()  # Llama recursivamente para hacer un ciclo

# Crear la ventana
root = tk.Tk()
root.title("Semáforo Peatones")

# Crear un título para el semáforo
titulo = tk.Label(root, text="Semáforo Peatones")
titulo.pack()

# Crear una variable de control para el mensaje
mensaje = tk.StringVar()
mensaje.set("Semáforo: Apagado")

# Crear el lienzo (canvas) para el semáforo
canvas = tk.Canvas(root, width=100, height=300)
canvas.pack()

# Dibujar las luces del semáforo
luz_roja = canvas.create_oval(30, 30, 70, 70, fill="gray")
luz_amarilla = canvas.create_oval(30, 110, 70, 150, fill="gray")
luz_verde = canvas.create_oval(30, 190, 70, 230, fill="gray")

# Crear etiqueta (label) para mostrar el mensaje
label = tk.Label(root, textvariable=mensaje)
label.pack()

# Iniciar el semáforo
cambiar_estado()

root.mainloop()
