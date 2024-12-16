from collections import Counter

def generate_combinations(alphabet, length):
    """
    This function brute-forces each combination from the given "alphabet" of the size "length"
    """
    combinations = []
    
    def generate_combinations_recursive(current_combination, length):
        if length == 0:
            combinations.append(current_combination)
            return
        for letter in alphabet:
            # recursively call the function in order to find the next combination
            generate_combinations_recursive(current_combination + letter, length - 1)
    
    generate_combinations_recursive('', length)
    return combinations

def calculate_percentage(sequence, combinations):
    """
    Compute the percentage of each combination given in the "combinations" object in the sequence given    
    """
    sequence_length = len(sequence)
    counts = Counter()
    
    # get the length of the first combination
    comb_length = len(combinations[0])
    
    # go through the entire eqeuence in order to find the 
    for i in range(sequence_length - comb_length + 1):
        # get the next combination we're analyzing
        comb = sequence[i:i + comb_length]
        
        # log the combination that we've found found
        counts[comb] += 1
    
    percentages = {}

    # go through each combination given in order to check if it is present in the file
    for combination in combinations:
        # the counts object holds every combination that we have found in the given sequence
        if combination in counts:
            # if the combination was found, compute it's percentage
            percentages[combination] = (counts[combination] / sequence_length) * 100
        else:
            # if it is not in counts, then we did not find that sequence
            percentages[combination] = 0.0

    return percentages


def get_first_sequence(file_path):
    """
    Get the first sequence from a FASTA file, by combiningining all the lines of the first genome.
    """
    with open(file_path, 'r') as file:
        sequence = []
        for line in file:
            if line.startswith('>'):
                if sequence:
                    # execution is going to reach here only when it finished reading the first sequence
                    break
            else:
                sequence.append(line.strip())
                # add the line to the sequence

    # return the sequence    
    return ''.join(sequence)

def ex_01():
    """
    Exercise 1:
    Design a brute force engine that generates all the combinations of 2 and 3 letters based on an alphabet of a sequence of 4 letters, namely A, T, C, G.
    Calculate the percentage of each combination over a sequence of S, where S can be taken from a fasta file (a genome, a gene, etc)
    """

    alphabet = ['A', 'T', 'C', 'G']
    sequence = get_first_sequence('influenza.fna')
    
    # brute force all the 2-letter & 3-letter combinations from the given alphabet
    combinations_2 = generate_combinations(alphabet, 2)
    combinations_3 = generate_combinations(alphabet, 3)
    
    # compute the percentages for 2-letter & 3-letter combinations for the first sequence from the FASTA file
    percentages_2 = calculate_percentage(sequence, combinations_2)
    
    percentages_3 = calculate_percentage(sequence, combinations_3)
    

    # output the results by writing them in both the terminal and saving them in a text file
    with open('output.txt', 'w') as output_file:
        output_file.write("2-letter combinations percentages:\n")
        print("2-letter combinations percentages:")
        for comb, perc in percentages_2.items():
            line = f"{comb}: {perc:.2f}%\n"
            print(line.strip())
            output_file.write(line)
        
        sum_percentages_2 = sum(percentages_2.values())
        sum_percentages_3 = sum(percentages_3.values())

        print("\nTotal sum of 2-letter combination percentages: ", sum_percentages_2)
        output_file.write("\nTotal sum of 2-letter combination percentages: ")
        output_file.write(str(sum_percentages_2))

        output_file.write("\n3-letter combinations percentages:\n")
        print("\n3-letter combinations percentages:")
        for comb, perc in percentages_3.items():
            line = f"{comb}: {perc:.2f}%\n"
            print(line.strip())
            output_file.write(line)

        print("Total sum of 3-letter combination percentages: ", sum_percentages_3)
        output_file.write("Total sum of 3-letter combination percentages: ")
        output_file.write(str(sum_percentages_3))

ex_01()

import matplotlib.pyplot as plt

def sliding_window(sequence, window_size):
    """
    Helper function for the second exercise.
    Generate sliding windows of a given size over the sequence.
    """
    for start in range(len(sequence) - window_size + 1):
        window = sequence[start:start + window_size]
        # we use yield so we can iterate over the result in the "calculate_relative_frequencies" function
        yield window

def calculate_relative_frequencies(sequence, combinations, window_size):
    """
    Helper function for the second exercise.
    Calculate the relative frequencies of each combination over the sequence using a sliding window.
    """

    frequencies = {combination: [] for combination in combinations}
    total_windows = len(sequence) - window_size + 1

    # iterate over the window
    for window in sliding_window(sequence, window_size):
        window_counts = Counter()
        
        # count occurrences of each combination in the current window
        for comb in combinations:
            comb_length = len(comb)
            for i in range(window_size - comb_length + 1):
                sub_seq = window[i:i + comb_length]
                window_counts[sub_seq] += 1
        
        # calculate relative frequency for each combination
        for comb in combinations:
            frequencies[comb].append(window_counts[comb] / window_size)

    return frequencies

def plot_relative_frequencies(frequencies, length):
    """
    Helper function for the second exercise.
    Plot the relative frequencies of each combination over the sequence.
    """

    # here we just plot the frequencies of the combinations
    for comb, freqs in frequencies.items():
        plt.plot(freqs, label=comb)
    
    plt.xlabel('Window Position')
    plt.ylabel('Relative Frequency')
    plt.title('Relative Frequencies of Combinations Over Sequence (length = {})'.format(length))
    plt.legend()
    plt.show()

def ex_02():
    """
    Exercise 2:
    Use the sliding window technique to measure the relative frequencies over the input sequence (the sequence found in the fasta file)
    The output of this step should be a line chart that contains a line for each output from the brute-force engine.
    """
    
    # same variables as the first exercise
    alphabet = ['A', 'T', 'C', 'G']
    sequence = get_first_sequence('influenza.fna')
    
    combinations_2 = generate_combinations(alphabet, 2)
    combinations_3 = generate_combinations(alphabet, 3)
    
    # we can adjust the size of the window by modifying this variable   
    window_size = 50 
    
    frequencies_2 = calculate_relative_frequencies(sequence, combinations_2, window_size)
    frequencies_3 = calculate_relative_frequencies(sequence, combinations_3, window_size)
    
    plot_relative_frequencies(frequencies_2, length = 2)
    plot_relative_frequencies(frequencies_3, length = 3)

#ex_02()

def ex_03():
    """
    Exercise 3:
    Detect the peaks for each combination over the main sequence. 
    
    Two results are needed in this case:
    1. A marker that shows the position of each peak over the sequence in the main chart (can be a geometrical shape)
    2. A sequence in the console that shows the combination and the position of the peak inside the sequence
    """

ex_03()