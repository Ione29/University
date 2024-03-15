import numpy as np
import matplotlib.pyplot as plt

def simulate_flash_adc(Vin, Vref, N):
    """Simulate a non-ideal N-bit Flash ADC operation."""
    step_size = Vref / (2**N)
    codes = np.arange(2**N)
    # For demonstration, let's introduce non-linearities by slightly altering the reference levels
    reference_levels = step_size * codes + np.sin(np.linspace(-np.pi, np.pi, 2**N)) * step_size * 0.1
    digital_output = np.digitize(Vin, reference_levels) - 1
    return np.clip(digital_output, 0, 2**N-1)

# Parameters
N = 5
Vref = 3.3
num_points = 1000
Vin = np.linspace(0, Vref, num_points)

# ADC Simulation
digital_output = simulate_flash_adc(Vin, Vref, N)

# Calculate ideal and actual transfer function
ideal_transfer_function = Vin / Vref * (2**N - 1)
actual_transfer_function = digital_output

# Calculate DNL and INL
ideal_code_values = np.arange(2**N) * Vref / (2**N - 1)
actual_code_values = [np.mean(Vin[digital_output == code]) for code in range(2**N)]
DNL = np.diff(actual_code_values, prepend=0) / (Vref / (2**N)) - 1
INL = np.cumsum(DNL)

# Plot DNL
plt.figure(figsize=(10, 4))
plt.stem(range(2**N), DNL, markerfmt=" ", basefmt="-b")
plt.title("Differential Non-Linearity (DNL)")
plt.xlabel("Code")
plt.ylabel("DNL (LSB)")
plt.grid(True)

# Plot INL
plt.figure(figsize=(10, 4))
plt.plot(range(2**N), INL, marker="o")
plt.title("Integral Non-Linearity (INL)")
plt.xlabel("Code")
plt.ylabel("INL (LSB)")
plt.grid(True)
plt.show()
