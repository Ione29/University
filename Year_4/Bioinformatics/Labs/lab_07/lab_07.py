import random

def ex_01():
    """
    Design a software implementation that is able to simulate the shotgun process:
    a) Design a module that generates a random than sequence of 100.000 nucleotides
    b) The output (the random DNA sequence) should be used by another module for collecting samples above the output DNA sequence that has been generated. These samples should be DNA segments between 1000 and 2000 nucleotides in length. The samples are taken randomly from the input sequences. At the end of this process you should have 200.000 samples stored line by line in a TXT file.
    """

    def generate_dna_sequence(length=100000):
        nucleotides = ['A', 'T', 'G', 'C']
        return ''.join(random.choices(nucleotides, k=length))

    def sample_dna_fragments(dna_sequence, num_samples=200000, min_length=1000, max_length=2000):
        fragments = []
        sequence_length = len(dna_sequence)
        for _ in range(num_samples):
            fragment_length = random.randint(min_length, max_length)
            start_pos = random.randint(0, sequence_length - fragment_length)
            fragment = dna_sequence[start_pos:start_pos + fragment_length]
            fragments.append(fragment)
        return fragments

    def save_fragments_to_file(fragments, file_name='dna_fragments.txt'):
        with open(file_name, 'w') as file:
            file.write('\n'.join(fragments))

    def simulate_shotgun_process():
        print("Generating random DNA sequence...")
        dna_sequence = generate_dna_sequence()
        print("Random DNA sequence generated.")

        print("Sampling DNA fragments...")
        fragments = sample_dna_fragments(dna_sequence)
        print(f"Generated {len(fragments)} DNA fragments.")

        print("Saving DNA fragments to file...")
        save_fragments_to_file(fragments)
        print("DNA fragments saved to 'dna_fragments.txt'.")

    simulate_shotgun_process()

ex_01()

def ex_02():
    """
    Design a software application that uses the sample file as an input. Find a method for this implementation that aligns the samples one by one in order to dcetect possible matches. Once a match is found between 2 samples, we consider that a small prediction from the original sequence is found. This repetitive comparison between samples will allow us to gradually build up the original sequence. In this assignment, you may consider that the original DNA sequence from the previous assignment isunknown. This current assignment presumes that the sample file is provided by the shotgun sequencing machine, this the thus our first assignment was able to emulate the results of the sequencing machine.
    """

    def load_samples(file_name='dna_fragments.txt'):
        """
        Load DNA fragments from a file.
        :param file_name: Name of the file containing the DNA fragments
        :return: List of DNA fragments
        """
        with open(file_name, 'r') as file:
            fragments = [line.strip() for line in file.readlines()]
        return fragments

    def find_max_overlap(frag1, frag2, min_overlap=20):
        """
        Find the maximum overlap between two DNA fragments.
        :param frag1: The first fragment
        :param frag2: The second fragment
        :param min_overlap: Minimum overlap length to consider
        :return: Tuple (overlap_length, merged_sequence)
        """
        max_overlap = 0
        merged_sequence = ""

        # Check suffix of frag1 with prefix of frag2
        for i in range(min_overlap, len(frag1)):
            if frag1[-i:] == frag2[:i]:
                if i > max_overlap:
                    max_overlap = i
                    merged_sequence = frag1 + frag2[i:]

        # Check prefix of frag1 with suffix of frag2
        for i in range(min_overlap, len(frag2)):
            if frag2[-i:] == frag1[:i]:
                if i > max_overlap:
                    max_overlap = i
                    merged_sequence = frag2 + frag1[i:]

        return max_overlap, merged_sequence

    def assemble_sequence(fragments, min_overlap=20):
        """
        Assemble the original sequence from DNA fragments using overlaps.
        :param fragments: List of DNA fragments
        :param min_overlap: Minimum overlap length to consider
        :return: Reconstructed sequence
        """
        while len(fragments) > 1:
            max_overlap = 0
            best_pair = (None, None)
            merged_sequence = ""

            # Find the pair of fragments with the maximum overlap
            for i in range(len(fragments)):
                for j in range(i + 1, len(fragments)):
                    overlap, merged = find_max_overlap(fragments[i], fragments[j], min_overlap)
                    if overlap > max_overlap:
                        max_overlap = overlap
                        best_pair = (i, j)
                        merged_sequence = merged

            # If no overlaps are found, break the loop
            if max_overlap == 0:
                break

            # Merge the best pair and update the fragments list
            i, j = best_pair
            fragments[i] = merged_sequence
            del fragments[j]  # Remove the second fragment from the list

        # Return the assembled sequence
        return fragments[0] if fragments else ""

    def save_reconstructed_sequence(sequence, file_name='reconstructed_dna.txt'):
        """
        Save the reconstructed DNA sequence to a file.
        :param sequence: The reconstructed DNA sequence
        :param file_name: Name of the output file
        """
        with open(file_name, 'w') as file:
            file.write(sequence)

    print("Loading DNA fragments...")
    fragments = load_samples()
    print(f"Loaded {len(fragments)} fragments.")

    print("Assembling DNA sequence...")
    reconstructed_sequence = assemble_sequence(fragments)
    print("DNA sequence assembled.")

    print("Saving reconstructed sequence to file...")
    save_reconstructed_sequence(reconstructed_sequence)
    print("Reconstructed sequence saved to 'reconstructed_dna.txt'.")

ex_02()