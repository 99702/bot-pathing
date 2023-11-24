import sys

if len(sys.argv) < 2:
    print("Please enter path")
    sys.exit(1)

plaintext = sys.argv[1:]


"""

L -> (Left or West)
R -> (Right or East)
N -> (North )
S -> (South)
Mn -> Move ( M10 -> move 10 forward )

Eg.  
1. RM15  ==>  Right + move to 15   => East (15, 0)

2. RM15 LM10 
==>  (Right + move to 15 )   , (Left + move to 10)
==> East(15,0) + (Left + move to 10)
==>  
"""

initial_position = {"axis": (0,0), "direction": "NORTH"}
LEFT = ("L","WEST" )
RIGHT = ("R", "EAST")
NORTH = ("N", "NORTH")
SOUTH = ("S", "SOUTH")
for text in plaintext:
    direction = text[0]
    moveN = int(text[2:])
    if(direction in RIGHT):
        initial_position["axis"] = (initial_position["axis"][0] + moveN, initial_position["axis"][1])
        match initial_position["direction"]:
            case 'NORTH':
                initial_position["direction"] = RIGHT[1]
            case 'EAST':
                initial_position["direction"] = SOUTH[1]
            case 'SOUTH':
                initial_position["direction"] = LEFT[1]
            case 'WEST' :
                initial_position["direction"] = NORTH[1]

    if(direction in LEFT):
        initial_position["axis"] = (initial_position["axis"][0] - moveN, initial_position["axis"][1])
        match initial_position["direction"]:
            case 'NORTH':
                initial_position["direction"] = LEFT[1]
            case 'WEST':
                initial_position["direction"] = SOUTH[1]
            case 'SOUTH':
                initial_position["direction"] = RIGHT[1]
            case 'EAST' :
                initial_position["direction"] = NORTH[1]

    # break

print(initial_position["direction"]+str(initial_position["axis"]))
