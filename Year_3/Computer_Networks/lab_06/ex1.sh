#!/bin/bash

echo "Enter a number:"
read num

if [ "$num" -lt 2 ]; then
    echo "$num is not a prime number."
    exit 1
fi

for ((i = 2; i <= num / 2; i++)); do
    if [ $(($num % $i)) -eq 0 ]; then
        echo "$num is not a prime number."
        exit 1
    fi
done

echo "$num is a prime number."