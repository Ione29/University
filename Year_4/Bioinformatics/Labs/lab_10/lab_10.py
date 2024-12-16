import matplotlib.pyplot as plt

# Step 1: Define the DNA sequence and sliding window length
S = "CGGACTGATCTATCTAAAAAAAAAAAAAAAAAAAAAAAAAAACGTAGCATCTATCGATCTATCTAGCGATCTATCTACTACG"
window_length = 30

# Step 2: Build a function to compute the C+G content
def compute_cg_content(sequence):
    cg_count = sequence.count('C') + sequence.count('G')
    cg_percentage = (cg_count / len(sequence)) * 100
    return cg_percentage

# Step 3: Build a function to compute the Kappa Index of Coincidence
def compute_kappa_index(sequence):
    n = len(sequence)
    freqs = {base: sequence.count(base) for base in 'ACGT'}
    ic = sum(freq * (freq - 1) for freq in freqs.values()) / (n * (n - 1)) * 100
    return ic

# Step 4: Plot the pattern on a chart
cg_values = []
ic_values = []
for i in range(len(S) - window_length + 1):
    window = S[i:i + window_length]
    cg_values.append(compute_cg_content(window))
    ic_values.append(compute_kappa_index(window))

plt.figure(figsize=(12, 6))
plt.subplot(2, 1, 1)
plt.plot(cg_values, label='C+G%')
plt.ylabel('C+G%')
plt.legend()

plt.subplot(2, 1, 2)
plt.plot(ic_values, label='Kappa Index of Coincidence', color='orange')
plt.ylabel('Kappa Index of Coincidence')
plt.legend()

plt.xlabel('Sliding Window Position')
plt.show()

# Step 5: Calculate the center of weight of the pattern
def calculate_center_of_weight(values):
    total_weight = sum(values)
    weighted_sum = sum(i * value for i, value in enumerate(values))
    center_of_weight = weighted_sum / total_weight
    return center_of_weight

cg_center_of_weight = calculate_center_of_weight(cg_values)
ic_center_of_weight = calculate_center_of_weight(ic_values)

# Step 6: Plot the center of each pattern on a second chart
plt.figure(figsize=(6, 6))
plt.plot(cg_center_of_weight, 'bo', label='C+G% Center of Weight')
plt.plot(ic_center_of_weight, 'ro', label='IC Center of Weight')
plt.ylabel('Center of Weight')
plt.legend()
plt.show()

# Step 7: Generate a pattern from a promoter DNA sequence and compare it with PromKappa
# This step requires the PromKappa tool, which is not implemented here.


def ex_02():
    """
    Downlaod the FASTA files containing the gene promoters found in "the eucariotic promoter database".
    1. From this database, we are interested in two species, namely homosapiens and galus galus. Use these .ja files to generate a pattern for each promotor and the center weight of each pattern on a second plot.
    2. Calculate the weight of weights to show 1 final point of each species on the final plot.
    """