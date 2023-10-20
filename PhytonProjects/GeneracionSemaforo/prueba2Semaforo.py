import time
import tkinter as tk

semaforo = [["red", 10], ["red", 8], ["red", 7]]

def cambiar_semaforo(focus_semaforo):
    semaforo[focus_semaforo][0] = "green"
    actualizar_interfaz()
    root.after(semaforo[focus_semaforo][1] * 1000, cambiar_a_amarillo, focus_semaforo)

def cambiar_a_amarillo(focus_semaforo):
    semaforo[focus_semaforo][0] = "yellow"
    actualizar_interfaz()
    root.after(2000, cambiar_a_rojo, focus_semaforo)

def cambiar_a_rojo(focus_semaforo):
    semaforo[focus_semaforo][0] = "red"
    actualizar_interfaz()
    siguiente_semaforo = (focus_semaforo + 1) % len(semaforo)
    root.after(2000, lambda: cambiar_semaforo(siguiente_semaforo))

def actualizar_interfaz():
    for i in range(3):
        color = semaforo[i][0]
        canvas.itemconfig(circulos[i], fill=color)

root = tk.Tk()
root.title("Simulación de Semáforos")

canvas = tk.Canvas(root, width=200, height=400)
canvas.pack()

circulos = []

for i in range(3):
    color = semaforo[i][0]
    circulo = canvas.create_oval(80, 40 + i * 120, 120, 80 + i * 120, fill=color)
    circulos.append(circulo)

cambiar_semaforo(0)

root.mainloop()