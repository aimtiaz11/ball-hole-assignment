# ball-hole-assignment

A model of a resource allocation problem:
1. I have two data records: Hole, and Ball
2. Hole and Ball each have an integer size property

I need a function to assign balls to holes

The function must 
1. take a collection of balls and a collection of holes
2. return a collection of balls that could not be assigned
3. return a collection of holes that could not be assigned
4. return a collection of (hole, ball) pairs representing the assignments

Assignment criteria:
1. the size of the ball must be equal or lower than the size of the hole
4. only one ball per hole (although fitting multiple balls is also an interesting problem)