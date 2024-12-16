from copy import deepcopy
from random import choice
from math import sqrt, log
import random

WIDTH = 7
HEIGHT = 6
def init_board():
    return [["0" for j in range(WIDTH)] for i in range(HEIGHT)]

def print_board(board):
    for i in range(HEIGHT):
        l = map(lambda c: board[i][c], range(WIDTH))
        print("|" + " ".join(l) + "|")
    print('-'+WIDTH*'--')
    print('\n')
    
    
board = init_board()
# print_board(board)



def get_available_actions(board):
    res = []
    for column in range(len(board[0])):
        l = [board[i][column] for i in range(len(board))]
        if '0' in l:
            res.append(column)
    return res

# get_available_actions(board)

def apply_move(board, move, player):
    new_board = deepcopy(board)

    for i in reversed(range(len(board))):
        if new_board[i][move] == '0':
            new_board[i][move] = player
            return new_board
    raise Exception("Unable to make that move")

# print_board(apply_move(board, 3, "R"))


from functools import reduce

moves = [2, 6, 3, 3, 1, 3, 5, 4, 3, 2, 0]
board_after_moves = reduce(
    lambda b, move_next_turn: apply_move(b, move_next_turn[1], 'R' if move_next_turn[0] % 2 == 0 else 'Y'),
    enumerate(moves), board)

# print_board(board_after_moves)


def check_winner(board, player):
    for row in range(HEIGHT):
        for col in range(WIDTH - 3): 
            if all(board[row][col + i] == player for i in range(4)):
                return True
    
    for col in range(WIDTH):
        for row in range(HEIGHT - 3):  
            if all(board[row + i][col] == player for i in range(4)):
                return True
    
    for row in range(HEIGHT - 3):
        for col in range(WIDTH - 3):
            if all(board[row + i][col + i] == player for i in range(4)):
                return True

    for row in range(3, HEIGHT):
        for col in range(WIDTH - 3):
            if all(board[row - i][col + i] == player for i in range(4)):
                return True
    
    return False



def check_draw(board, players):
    if check_winner(board, players[0]) is False and check_winner(board, players[1]) is False and not any(["0" in line for line in board]):
        return True
    return False

def is_final(board, players):
    if check_draw(board, players) is False and check_winner(board, players[0]) is False and check_winner(board, players[1]) is False:
        return False
    if check_winner(board, players[0]) is True:
        return players[0]
    if check_winner(board, players[1]) is True:
        return players[1]
    else:
        return "DRAW"
    
    
players = ["R", "Y"]
current_player = "R"
while is_final(board, players) is False:
    actions = get_available_actions(board)
    if not actions:
        break
    action = choice(actions)
    board = apply_move(board, action, current_player)
    current_player = "Y" if current_player == "R" else "R"
    
print_board(board)        

def init_node(state, parent = None):
    return {"N": 0, "Q": 0, "STATE": state, "PARENT": parent, "ACTIONS": {}}


c = 1.0 / sqrt(2.0)

CP = 1.414 


def UCT_search(root_state, computational_budget=40):
    root = init_node(root_state)
    for _ in range(computational_budget):
        v1 = tree_policy(root)  
        delta = default_policy(v1["STATE"])
        backup(v1, delta) 
    return max(root["ACTIONS"], key=lambda action: root["ACTIONS"][action]["N"])

def tree_policy(v):
    while not is_final(v["STATE"], ["R", "Y"]):
        if not fully_expanded(v):
            return expanded(v)
        else:
            v = best_child(v, CP)
    return v

def fully_expanded(v):
    return len(v["ACTIONS"]) == len(get_available_actions(v["STATE"]))

def expanded(v):
    untried_actions = [a for a in get_available_actions(v["STATE"]) if a not in v["ACTIONS"]]
    action = random.choice(untried_actions)
    new_state = apply_move(v["STATE"], action, current_player(v))
    child_node = init_node(new_state, v)
    v["ACTIONS"][action] = child_node
    return child_node

def best_child(v, c):
    def ucb1(node):
        q = node["Q"] / node["N"]
        u = c * sqrt(log(v["N"]) / node["N"])
        return q + u
    return max(v["ACTIONS"].values(), key=ucb1)


def current_player(node):
    r_moves = sum(row.count("R") for row in node["STATE"])
    y_moves = sum(row.count("Y") for row in node["STATE"])
    return "R" if r_moves == y_moves else "Y"

def default_policy(state):

    players = ["R", "Y"]
    current = current_player({"STATE": state})  
    simulation_state = deepcopy(state)
    while not is_final(simulation_state, players):
        actions = get_available_actions(simulation_state)
        if not actions:
            break
        action = random.choice(actions)
        simulation_state = apply_move(simulation_state, action, current)
        current = "Y" if current == "R" else "R"
    winner = is_final(simulation_state, players)
    if winner == "R":
        return 1  
    elif winner == "Y":
        return -1 
    else:
        return 0  

def backup(v, delta):
    while v is not None:
        v["N"] += 1
        v["Q"] += delta
        delta = -delta  
        v = v["PARENT"]
        
current_budget = 40

R_wins = 0
Y_wins = 0

for _ in range(30):
    board = init_board()  
    current_player_gaming = "R" 
    while is_final(board, players) is False:
        if not actions:
            break
        
        action = UCT_search(board, current_budget)
        board = apply_move(board, action, current_player_gaming)
        current_player_gaming = "Y" if current_player_gaming == "R" else "R"
        current_budget = 40 if current_player_gaming == "R" else 5
    
    winner = is_final(board, players)
    if winner == "R":
        R_wins +=1
    elif winner == "Y":
        Y_wins +=1
    


print("R with buget of 40 wins: ", R_wins)
print("Y with buget of 5 wins: ", Y_wins)