# DijkstraAlgorithm
 The simple Java implements of the  Dijkstra algorithm

 The Graph is like this:
![image](https://github.com/user-attachments/assets/b3b47b89-6146-4e43-8759-8c40e8e591a1)

Find the least cost of the path from Node S to Node E.

Core Algorithm:
     Maintain 3 tables, one for neighbourhood: the key is a node,the value contains all the neighbour nodes and its cost to the node.
     One for cost: the key includes all the nodes, the value represents the present least cost to the node S. If there is no idea, 
     typed in a maximum value first(e.g 1000).
     The last one for parents: the key includes all the nodes, and the value is its parents node.
     So the process below:
     From the Node S, find its neighbours, deal with the neighbours one by one at the order of from the least cost to the highest cost.
     At each neighbour node, the cost to node S pluses the cost to a neighbour, then get the cost from the node S to the neighbour node.
     If the cost less than the vlaue on the cost table, replace this cost value, and record this node as the neighbour's parents on the parents table.
     Go on and calculate all the nodes, then got the least cost to all the nodes at the cost table and the parents node of all the nodes 
     which is on the path of the least cost on the parents table.
