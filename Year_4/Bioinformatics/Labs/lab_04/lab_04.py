import math

def ex_01():
    """
    Exerciese 1:
    
    Implement an application that converts the coding region of a gene into an amino-acid sequence. In order to start, use the genetic code. Note that the translation process must start with an ATG codon, so the reading frame is based on a multiple of 3 letters until a stop codon is encountered (There are 3 versions of a stop codon, please see the table regarding the genetic code). The input of the app will be a DNA sequence and the output will be anm amino-acid sequence. Each amino-acid is represented with single letters. Please look on the internet for the amino-acid table showing single letter representations.
    """
    def translate_dna_to_protein(dna_sequence):
        
        # genetic codes translated to a python dictionary, _ means stop
        genetic_code = {
            'ATA':'I', 'ATC':'I', 'ATT':'I', 'ATG':'M',
            'ACA':'T', 'ACC':'T', 'ACG':'T', 'ACT':'T',
            'AAC':'N', 'AAT':'N', 'AAA':'K', 'AAG':'K',
            'AGC':'S', 'AGT':'S', 'AGA':'R', 'AGG':'R',
            'CTA':'L', 'CTC':'L', 'CTG':'L', 'CTT':'L',
            'CCA':'P', 'CCC':'P', 'CCG':'P', 'CCT':'P',
            'CAC':'H', 'CAT':'H', 'CAA':'Q', 'CAG':'Q',
            'CGA':'R', 'CGC':'R', 'CGG':'R', 'CGT':'R',
            'GTA':'V', 'GTC':'V', 'GTG':'V', 'GTT':'V',
            'GCA':'A', 'GCC':'A', 'GCG':'A', 'GCT':'A',
            'GAC':'D', 'GAT':'D', 'GAA':'E', 'GAG':'E',
            'GGA':'G', 'GGC':'G', 'GGG':'G', 'GGT':'G',
            'TCA':'S', 'TCC':'S', 'TCG':'S', 'TCT':'S',
            'TTC':'F', 'TTT':'F', 'TTA':'L', 'TTG':'L',
            'TAC':'Y', 'TAT':'Y', 'TAA':'_', 'TAG':'_',
            'TGC':'C', 'TGT':'C', 'TGA':'_', 'TGG':'W',
        }
        
        protein = ""
        start_codon_found = False
        
        for i in range(0, len(dna_sequence), 3):
            # analyze codons, each of them is made by 3 letters
            codon = dna_sequence[i:i+3]
            if codon == "ATG":
                start_codon_found = True
            if start_codon_found:
                amino_acid = genetic_code.get(codon, '')
                if amino_acid == '_':
                    break
                protein += amino_acid
        
        return protein

    "For the DNA sequence \"ATGCGTACTGAACTGATAG\" the result should be \"MRTELI\""

    print("Exercise 1")
    dna_sequence = input("Enter the DNA sequence: ")
    protein_sequence = translate_dna_to_protein(dna_sequence)
    print("The corresponding amino acid sequence is:", protein_sequence)

ex_01()

def ex_02():
    """
    The melting temperature (TM) is the temperature at which one-half of a particular DNA duplex will dissociate and become a single strand of DNA. Primer length and sequence are of critical importance in designing the parameters of a successful amplification. The melting temperature of a nucleic acid duplex increases both with its length, and with increasing GC content. A simple formula for calculation of the (Tm) is:  Tm = 4(G + C) + 2(A + T) °C. The actual TM is influenced by the concentration of Mg2+ , K+ , and cosolvents. An alternative formula is:

    TM = 81.5 + 16.6(log10([Na+])) + .41*(%GC) - 600/length

    Implement an application that calculates the melting temperature of a DNA sequence using one of these formulas or both.

    Input = a string of DNA
    Output = temperature in celsius
    """

    # na_concentration = 50 for the simple formula to work as well and not have to write 2 separate functions
    def calculate_tm(dna_sequence, formula_type, na_concentration=50):
        # make sure the DNA sequence is made only of upper characters
        dna_sequence = dna_sequence.upper()
        length = len(dna_sequence)
        
        # values necessary for the simple formula
        gc_count = dna_sequence.count('G') + dna_sequence.count('C')
        at_count = dna_sequence.count('A') + dna_sequence.count('T')
        
        # compute the result based on what formula was provided
        if formula_type == "simple":
            tm = 4 * gc_count + 2 * at_count
        elif formula_type == "alternative":
            gc_percentage = (gc_count / length) * 100
            tm = 81.5 + 16.6 * (math.log10(na_concentration)) + 0.41 * gc_percentage - 600 / length
        else:
            # fallback in case the formula_type is wrong
            raise ValueError("Invalid formula type. Use 'simple' or 'alternative'.")
        
        return tm

    print("\nExercise 2")
    dna_sequence = input("Enter the DNA sequence: ")
    na_concentration = float(input("Enter the Na+ concentration (mM): "))
    
    # call calculate_tm function in order to compute the melting points
    tm_simple = calculate_tm(dna_sequence, "simple")
    tm_alternative = calculate_tm(dna_sequence, "alternative", na_concentration)
    
    """
    For the DNA sequence \"ATGCGTACTGAACTGATAG\" we should get:

    The melting temperature (Tm) is:
    - By the simple formula: 54
    - By the alternative formula: 95.3871125982937
    """


    print("The melting temperature (Tm) is:\n- By the simple formula: {}\n- By the alternative formula: {}, with the concentration of {}% Na+".format(tm_simple, tm_alternative,na_concentration))

ex_02()