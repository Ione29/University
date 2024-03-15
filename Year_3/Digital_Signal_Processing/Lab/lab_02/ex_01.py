import math
import numpy as npy

#write the ordered list of phasors with the largest distance between each succession two elements

angles = []   

phi = 0
n = int(input("Give the number of points: "))

angles.append(0)
n = n - 1

while n > 0:
    phi += math.pi / 2
    
    
    if phi >= 2 * math.pi:
        phi = phi - 2 * math.pi + (math.pi / 8)

    angles.append(phi)
    n -= 1

print(angles)

angles.sort()
for i in range (0, 15):
    print(str(i) + ". " + str(angles[i]))

