import argparse
import pandas as pd

def ex1():
    print("Ex. 1:")
    par = argparse.ArgumentParser()
    par.add_argument('--nr1', type=int, required=True, help='first argument')
    par.add_argument('--nr2', type=int, required=True, help='second argument')
    numbers= par.parse_args()

    s = numbers.nr1 + numbers.nr2
    d = numbers.nr1 - numbers.nr2
    m = numbers.nr1 * numbers.nr2
    d = numbers.nr1 / numbers.nr2
    median = s / 2

    print("The sum of the two numbers is: ", s)
    print("The difference of the two numbers is: ", d)
    print("The multiplication of the two numbers is: ", m)
    print("The division of the two numbers is: ", d)
    print("The mean of the two numbers is: ", median)

def ex2():
    print("Ex. 2:")
    par = argparse.ArgumentParser()
    par.add_argument('--nr1', type=int, required=True, help='first argument')
    par.add_argument('--nr2', type=int, required=True, help='second argument')
    par.add_argument('--function', type=str, required=True, help='math_func')

    args = par.parse_args()

    if args.function == '+':
        s = args.nr1 + args.nr2
        print("The sum of the two numbers is: ", s)
    if args.function == '-':
        d = args.nr1 - args.nr2
        print("The difference of the two numbers is: ", d)
    if args.function == '*':
        mu = args.nr1 * args.nr2
        print("The multiplication of the two numbers is: ", mu)
    if args.function == '/':
        div = args.nr1 / args.nr2
        print("The division of the two numbers is: ", div)
    if args.function == '//':
        mn = (args.nr1 + args.nr2) / 2
        print("The median value of the two numbers is: ", mn)

def ex3():
    print("Ex. 3:")
    data = pd.read_csv('Lab7.csv')

    emails = data['Email'].tolist()
    first_names = data['FirstName'].tolist()

    with open('ex3.html', 'w') as f:
        f.write('<html>\n')
        f.write('<body style="background-color:blue;">\n')

        f.write('<ol style="color:red;">\n')
        for email in emails:
            f.write(f'<li>{email}</li>\n')
        f.write('</ol>\n')

        f.write('<ul style="color:green;">\n')
        for first_name in first_names:
            f.write(f'<li>{first_name}</li>\n')
        f.write('</ul>\n')

        f.write('</body>\n')
        f.write('</html>\n')

    print("HTML file \"ex3.html\" has been created succesfully.")

def ex4():
    print("Ex. 4:")
    names = ["Alex" "Emma", "Kate", "Ryan", "Lily"]
    ages = [21, 25, 36, 31, 27]

    with open('ex4.html', 'w') as f:
        f.write('<html>\n')
        f.write('<body>\n')

        f.write('<table>\n')
        f.write('<tr>\n')
        f.write('<th>Name</th>\n<th>Age</th>\n')

        for name, age in zip(names, ages):
            f.write(f'<tr>\n<td>{name}</td>\n<td>{age}</td>\n</tr>\n')
        f.write("</table")
        f.write('</body>\n')
        f.write('</html>\n')

    print("HTML file \"ex4.html\" has been created succesfully.")

#ex1()
#ex2()
ex3()
ex4()