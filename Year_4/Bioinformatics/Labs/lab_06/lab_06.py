import tkinter as tk
from tkinter import filedialog
import matplotlib.pyplot as plt
from Bio import SeqIO
from collections import defaultdict

def read_fasta(file_path):
    """
    Read a fasta file given as a parameter.
    """
    try:
        with open(file_path, "r") as file:
            for record in SeqIO.parse(file, "fasta"):
                return str(record.seq)
    except FileNotFoundError:
        print(f"File not found: {file_path}")
        return None
    except Exception as e:
        print(f"An error occurred while reading the file: {e}")
        return None

def find_restriction_sites(sequence, patterns):
    """
    Find restriction sites in the sequence for given patterns.
    """
    sites = []
    for pattern in patterns:
        start = 0
        while start < len(sequence):
            start = sequence.find(pattern, start)
            if start == -1:
                break
            sites.append((start, start + len(pattern)))
            start += len(pattern)
    return sorted(sites)

def simulate_digestion(sequence, sites):
    """
    Simulate DNA digestion and return the resulting segments.
    """
    segments = []
    prev_end = 0
    for start, end in sites:
        segments.append(sequence[prev_end:start])
        prev_end = end
    segments.append(sequence[prev_end:])
    return segments

def calculate_gc_content(segment):
    """
    Calculate the GC content of a DNA segment.
    """
    gc_count = segment.count('G') + segment.count('C')
    return (gc_count / len(segment)) * 100 if len(segment) > 0 else 0

def ex_01():
    """
    Design an app that is able to simulate a DNA digestion with the use of different restriction enzymes. Note that restriction enzymes are proteins that are able to cleavage (cut) the DNA sequence when they encounter via complementary a specific pattern. Use a viral genome at your choice as an input sequence. Your app must search for specific patterns from a list of patterns and cut the viral genome into their resulting pieces. The output in the console must show each resulting DNA segment, its length, GC content, and the start and stop position of the segment over the viral genome.
    """
    
    def find_restriction_sites(sequence, patterns):
        """
        Find restriction sites in the sequence for given patterns.
        """
        sites = []
        for pattern in patterns:
            start = 0
            while start < len(sequence):
                start = sequence.find(pattern, start)
                if start == -1:
                    break
                sites.append((start, start + len(pattern)))
                start += len(pattern)
        return sorted(sites)

    def simulate_digestion(sequence, sites):
        """
        Simulate DNA digestion and return the resulting segments.
        """
        segments = []
        prev_end = 0
        for start, end in sites:
            segments.append(sequence[prev_end:start])
            prev_end = end
        segments.append(sequence[prev_end:])
        return segments

    def calculate_gc_content(segment):
        """
        Calculate the GC content of a DNA segment.
        """
        gc_count = segment.count('G') + segment.count('C')
        return (gc_count / len(segment)) * 100 if len(segment) > 0 else 0

    # Read the viral genome sequence
    genome_sequence = read_fasta("/path/to/viral_genome.fna")

    if genome_sequence is None:
        print("Failed to read the viral genome sequence.")
        return

    # Define restriction enzyme patterns
    restriction_patterns = ["GAATTC", "GGATCC", "AAGCTT"]  # Example patterns

    # Find restriction sites
    restriction_sites = find_restriction_sites(genome_sequence, restriction_patterns)

    # Simulate DNA digestion
    segments = simulate_digestion(genome_sequence, restriction_sites)

    # Output results
    start = 0
    for segment in segments:
        end = start + len(segment)
        gc_content = calculate_gc_content(segment)
        print(f"Segment: {segment}")
        print(f"Length: {len(segment)}")
        print(f"GC Content: {gc_content:.2f}%")
        print(f"Start: {start}, End: {end}")
        print()
        start = end

# Call the function
ex_01()

def ex_02():
    """
    Make a GUI that simulates an electrophoresis gel based on our previous results taken from the shotgun sequence assignment and / or the restriction enzyme assignment. In order to simulate this type of electrophoresis gel the migration lines which represent the weight and length of DNA sequence must be calculated based on the length of the segments obtained in the shotgun sequence assignment. Note that the short segments travel faster on the gel due to less friction forces, while longer DNA segments will cover travel shorter distances because the friction forces are much higher and directly proportional with the length of the DNA segments.
    """
    def simulate_gel(segments):
        """
        Simulate the electrophoresis gel.
        """
        segment_lengths = [len(segment) for segment in segments]
        segment_lengths.sort(reverse=True)

        fig, ax = plt.subplots()
        for i, length in enumerate(segment_lengths):
            ax.plot([0, length], [i, i], marker='|', markersize=10, color='black')
        
        ax.set_xlabel('Length of DNA segments')
        ax.set_ylabel('Segments')
        ax.set_title('Electrophoresis Gel Simulation')
        plt.show()

    def load_and_simulate():
        """
        Load the genome sequence and simulate the gel.
        """
        segments = ex_01()
        if segments:
            simulate_gel(segments)

    # Create the GUI
    root = tk.Tk()
    root.title("Electrophoresis Gel Simulation")

    load_button = tk.Button(root, text="Load Genome and Simulate Gel", command=load_and_simulate)
    load_button.pack(pady=20)

    root.mainloop()

# Call the function
ex_02()