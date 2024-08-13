# DijkstraAlgorithm
The simple Java implements of the  Dijkstra algorithm
## Question: Find the path with the least cost from Node S to Node E.   
The Graph is like this:
![image](https://github.com/user-attachments/assets/b3b47b89-6146-4e43-8759-8c40e8e591a1)

## Core Algorithm:  
1. Maintain 3 tables：  
    1. One for Graph: the key is a node, and the value contains all the neighbour nodes and their cost to the node.  
    2. One for Cost: the key includes all the nodes, and the value represents the least cost to node S.   
      If there is no idea, type in a maximum value first(e.g. 1000).  
    3. The last one for Parents: the key includes all the nodes; the value is its parent node.   
![image](https://github.com/user-attachments/assets/b1cbadd6-fe4b-40bf-831a-eda2dd708118)
2. So the process is below:  
- **From Node S, find its neighbours, and deal with the neighbours one by one at the order from the least cost to the highest cost.**    
- **At each neighbour node, the cost to node S pluses the cost to a neighbour, then gets the cost from node S to the neighbour node.**
- **If the cost is less than the value on the Cost table, replace this cost value, and record this node as the neighbour's parents on the Parents table.**
- **Go on and calculate all the nodes, then get the least cost value of all the nodes to node S and the parent node of each node on the path of the least cost.**  

***

