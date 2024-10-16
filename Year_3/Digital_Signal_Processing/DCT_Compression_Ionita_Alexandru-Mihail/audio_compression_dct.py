import numpy as np
from scipy.fftpack import dct, idct
import tkinter as tk
from tkinter import filedialog, messagebox, simpledialog
from pydub import AudioSegment
import matplotlib.pyplot as plt
from scipy.signal import spectrogram
import os

def select_files():
    # Create and hide the main Tkinter window
    root = tk.Tk()
    root.withdraw()

    # Prompt the user to select an input audio file
    input_file = filedialog.askopenfilename(
        title="Select Input Audio File",
        filetypes=[("Audio Files", "*.wav *.mp3 *.flac *.ogg *.m4a *.aac *.wma *.aiff *.aif *.aifc")]
    )
    # Check if a file was selected
    if not input_file:
        messagebox.showerror("Error", "Input file not selected")
        return
    
    # Prompt the user to specify the output file location and name
    output_file = filedialog.asksaveasfilename(
        title="Save Compressed Audio As",
        defaultextension=".wav",
        filetypes=[("Audio Files", "*.wav *.mp3 *.flac *.ogg *.m4a *.aac *.wma *.aiff *.aif *.aifc")]
    )
    # Check if a file location was specified
    if not output_file:
        messagebox.showerror("Error", "Output file not selected")
        return

    # Ask the user for the compression factor using a dialog box
    compression_factor = simpledialog.askfloat(
        "Compression Factor",
        "Enter compression factor (0 to 1):",
        minvalue=0.0,
        maxvalue=1.0
    )
    
    # Check if a valid compression factor was entered
    if compression_factor is None:
        messagebox.showerror("Error", "Invalid compression factor")
        return

    # Call the function to compress audio and handle the output
    compress_audio(input_file, output_file, compression_factor)

def compress_audio(input_file, output_file, compression_factor):
    try:
        # Load the input audio file
        audio = AudioSegment.from_file(input_file)
        sample_rate = int(audio.frame_rate)  # Get the sample rate of the audio
        
        # Convert audio data to a numpy array
        data = np.array(audio.get_array_of_samples())

        # If the audio is stereo, use only one channel
        if audio.channels > 1:
            data = data[::audio.channels]

        # Normalize audio data to the range [-1, 1]
        normalized_data = data / np.max(np.abs(data))
        
        # Apply Discrete Cosine Transform (DCT) to the normalized audio data
        dct_transformed = dct(normalized_data, norm='ortho')
        
        # Zero out a portion of the DCT coefficients based on the compression factor
        n = len(dct_transformed)
        compressed_dct = np.copy(dct_transformed)
        threshold = int(n * compression_factor)
        compressed_dct[threshold:] = 0
        
        # Apply Inverse Discrete Cosine Transform (IDCT) to reconstruct the compressed audio
        compressed_audio = idct(compressed_dct, norm='ortho')
        
        # Denormalize the compressed audio data back to its original scale
        compressed_audio = np.int16(compressed_audio * np.max(np.abs(data)))
        
        # Ensure the output directory exists
        output_dir = os.path.dirname(output_file)
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        
        # Convert the compressed audio data back to an AudioSegment
        compressed_audio_segment = AudioSegment(
            compressed_audio.tobytes(),
            frame_rate=sample_rate,
            sample_width=audio.sample_width,
            channels=1
        )
        
        # Save the compressed audio file
        compressed_audio_segment.export(output_file, format=output_file.split('.')[-1])
        messagebox.showinfo("Success", f"Compressed audio saved to {output_file}")
        
        # Plot and save the spectrograms and waveforms
        plot_spectrograms_and_waveforms(normalized_data, compressed_audio, sample_rate, output_dir, compression_factor)
    except Exception as e:
        # Display an error message if something goes wrong
        messagebox.showerror("Error", str(e))

def plot_spectrograms_and_waveforms(original_audio, compressed_audio, sample_rate, output_dir, compression_factor):
    # Compute the spectrogram for the original and compressed audio
    f1, t1, Sxx1 = spectrogram(original_audio, sample_rate)
    f2, t2, Sxx2 = spectrogram(compressed_audio, sample_rate)

    # Create a figure with 4 subplots (2 rows x 2 columns)
    plt.figure(figsize=(12, 12))

    # Plot the spectrogram of the original audio
    plt.subplot(2, 2, 1)
    plt.pcolormesh(t1, f1, 10 * np.log10(Sxx1), shading='gouraud')
    plt.title('Original Audio Spectrogram')
    plt.ylabel('Frequency [Hz]')
    plt.xlabel('Time [sec]')
    plt.colorbar(label='Intensity [dB]')

    # Plot the spectrogram of the compressed audio
    plt.subplot(2, 2, 2)
    plt.pcolormesh(t2, f2, 10 * np.log10(Sxx2), shading='gouraud')
    plt.title('Compressed Audio Spectrogram')
    plt.ylabel('Frequency [Hz]')
    plt.xlabel('Time [sec]')
    plt.colorbar(label='Intensity [dB]')

    # Plot the waveform of the original audio
    plt.subplot(2, 2, 3)
    plt.plot(np.arange(len(original_audio)) / sample_rate, original_audio, label='Original Audio')
    plt.title('Original Audio Waveform')
    plt.xlabel('Time [sec]')
    plt.ylabel('Amplitude')
    plt.grid()
    plt.legend()

    # Plot the waveform of the compressed audio
    plt.subplot(2, 2, 4)
    plt.plot(np.arange(len(compressed_audio)) / sample_rate, compressed_audio, label='Compressed Audio', color='orange')
    plt.title('Compressed Audio Waveform')
    plt.xlabel('Time [sec]')
    plt.ylabel('Amplitude')
    plt.grid()
    plt.legend()

    # Save the plot as a PNG file
    output_path = os.path.join(output_dir, f'spectrogram_waveform_{compression_factor}.png')
    plt.tight_layout()
    plt.savefig(output_path)
    print(f"Saved plot to {output_path}")

    # Display the plot
    plt.show()

if __name__ == "__main__":
    select_files()
