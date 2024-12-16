# 1. Implement an application that is able to detect repetitive subsequences between 3-8 letters. Use a chromosome from homosapiens: chromosome 14. Your application must be able to show a list with the most frequent repetition and provide a bar chart with their relative frequencies. Also, the console must show the positions(start, end) of these repetitive regions across chromosome. The length of these repetitive regions should be of at least 20 repetitions in sequence. (ex: ATT, ATT, ATT .... ATT 20 times).

import matplotlib as plt
from Bio import SeqIO
import matplotlib.pyplot as plt
from collections import defaultdict

def read_fasta(file_path):
    with open(file_path, "r") as file:
        for record in SeqIO.parse(file, "fasta"):
            return str(record.seq)

chromosome_sequence = read_fasta("/home/ione/Documents/University/Year_4/Bioinformatics/Labs/lab_05/test.fna")

def find_repetitive_subsequences(sequence, min_length=3, max_length=8, min_repeats=20):
    repeats = defaultdict(list)
    
    for length in range(min_length, max_length + 1):
        for i in range(len(sequence) - length + 1):
            subseq = sequence[i:i + length]
            count = sequence.count(subseq)
            
            if count >= min_repeats:
                positions = []
                start = 0
                while start < len(sequence):
                    start = sequence.find(subseq, start)
                    
                    if start == -1:
                        break
                    
                    end = start + length
                    positions.append((start, end))
                    start += length

                if len(positions) >= min_repeats:
                    repeats[subseq].append((positions, len(positions)))
    
    return repeats

repetitive_subs = find_repetitive_subsequences(chromosome_sequence)

def print_repetitive_positions(repeats):
    for seq, occurrences in repeats.items():
        if occurrences:
            print(f"Sequence: {seq}")
            for positions, count in occurrences:
                print(f"Occurrences: {count}")
                print("Positions:", positions)

def plot_repeats(repeats):
    sequences = list(repeats.keys())
    counts = [len(vals) for vals in repeats.values()]
    
    plt.figure(figsize=(10, 6))
    plt.bar(sequences, counts)
    plt.xlabel('Sequences')
    plt.ylabel('Count')
    plt.title('Repetitive Subsequences')
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()

print_repetitive_positions(repetitive_subs)
plot_repeats(repetitive_subs)

# 2. Add a chart that is able to show the relative regions of these repetitions across the chromosome 14. Show all the regions from most repetitions to least repetitions.

def plot_relative_regions(repeats, sequence_length):
    # Create an array that represents the chromosome with zero values
    chromosome_map = [0] * sequence_length

    for subseqs, occurrences in repeats.items():
        for positions, count in occurrences:
            for start, end in positions:
                for i in range(start, end):
                    chromosome_map[i] += 1

    x_values = range(sequence_length)
    plt.figure(figsize=(12, 4))
    plt.plot(x_values, chromosome_map, label='Repetitive Density')
    plt.xlabel('Position on Chromosome')
    plt.ylabel('Density of Repetitions')
    plt.title('Density of Repetitive Regions Across Chromosome')
    plt.legend()
    plt.tight_layout()
    plt.show()

plot_relative_regions(repetitive_subs, len(chromosome_sequence))