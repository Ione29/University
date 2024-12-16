import tkinter as tk
from tkinter import messagebox
import matplotlib.pyplot as plt
import random


def generate_random_dna(length):
    return ''.join(random.choice('ACGT') for _ in range(length))

def find_inverted_repeats(dna, repeat_length):
    repeats = []
    for i in range(len(dna) - repeat_length * 2 + 1):
        repeat = dna[i:i+repeat_length]
        inverted_repeat = dna[i+repeat_length:i+repeat_length*2][::-1]
        if repeat == inverted_repeat:
            repeats.append((i, i + repeat_length * 2))
    return repeats

def insert_transposable_elements(dna, repeats):
    elements = []
    for repeat in repeats:
        length = len(repeat)
        start = random.randint(0, len(dna) - length * 2)
        end = start + length * 2
        dna = dna[:start] + repeat + dna[start:start+length] + repeat[::-1] + dna[start+length:]
        elements.append((start, end))
    return dna, elements

def ex_01():
    """
    Make an artificial DNA sequence of 200-400 bases in length, in which to simulate 3-4 transposable elements.
    """

    def insert_transposable_elements(dna, num_elements):
        elements = []
        for _ in range(num_elements):
            length = random.randint(5, 10) 
            repeat = generate_random_dna(length)
            start = random.randint(0, len(dna) - length * 2)
            end = start + length * 2
            dna = dna[:start] + repeat + dna[start:start+length] + repeat[::-1] + dna[start+length:]
            elements.append((start, end))
        return dna, elements

    length = random.randint(200, 400)
    dna = generate_random_dna(length)
    dna, elements = insert_transposable_elements(dna, random.randint(3, 4))
    return dna, elements

def ex_02(dna):
    """
    Implement a software application that is able to detect the positions of these transposable elements (start, end) within the created DNA sequence. Note that a transposome is represented by 2 inverted repeats that enclose a region of DNA. Also, take into consideration the special cases such as transposome intersection or transposome engulfing.

    Note that you can invent the inverted repeats for the purpose of this assignment. Also the insertion of the inverted repeats into randomly generated DNA dictates the known positions of transposomes. To understand what inverted repeats are, use the presentation from moodle in relation to transposomes.
    """

    repeat_length = 5
    transposable_elements = find_inverted_repeats(dna, repeat_length)
    return transposable_elements

def ex_03():
    """
    Find on the internet inverted repeats and use this in order to simulate transposomes. Use these inverted repeats to find transposomes inside a plant genome, such as zea maize. Make a GUI that allows the user to copy-paste the inverted repeated, and that shows a chart with the positions of this transposomes over the corn genome.
    """

    def on_submit():
        repeat = entry.get()
        if not repeat:
            messagebox.showerror("Error", "Please enter an inverted repeat.")
            return
        
        with open('/path/to/zea_maize_genome.txt', 'r') as file:
            plant_genome = file.read().strip()
        plant_genome, elements = insert_transposable_elements(plant_genome, [repeat])
        
        detected_elements = find_inverted_repeats(plant_genome, len(repeat))
        
        positions = [start for start, end in detected_elements]
        plt.figure(figsize=(10, 2))
        plt.plot(positions, [1] * len(positions), 'ro')
        plt.title("Transposome Positions in Plant Genome")
        plt.xlabel("Position")
        plt.yticks([])
        plt.show()

    root = tk.Tk()
    root.title("Transposome Finder")

    tk.Label(root, text="Enter Inverted Repeat:").pack(pady=10)
    entry = tk.Entry(root, width=50)
    entry.pack(pady=5)
    
    tk.Button(root, text="Submit", command=on_submit).pack(pady=20)
    
    root.mainloop()

if __name__ == "__main__":
    dna_sequence, transposable_elements = ex_01()
    print("DNA Sequence:", dna_sequence)
    print("Transposable Elements:", transposable_elements)
    
    detected_elements = ex_02(dna_sequence)
    print("Detected Transposable Elements:", detected_elements)

    ex_03()