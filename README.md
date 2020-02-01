# Dijkstra-s-Algorithm

In this code I have implemented Dijkstra’s Algorithm for finding the shortest paths from a given source in a weighted directed graph. In this code I have implemented the priority queue as a heap. The input to the program is a textual representation of a weighted directed graph as detailed below. The output is a list of shortest path lengths (one per vertex) as described below. Let the input file name be “input.txt” and the output file name be “output.txt”.
The textual representation of the graph consists of one line with two integers specifying the number of vertices and the number of edges, respectively, followed by a list of edges (one line per edge). If the number of vertices is V, assume, without any loss of generality, that the vertices are numbered 0 through V-1, and that the source is Vertex 0. The line for each edge consists of three numbers representing the source vertex, the destination vertex and the edge weight, respectively. 
The output shows the shortest distance for each vertex. The first line in the output starts with the word “Vertex” followed by vertex numbers in order. The second line starts with the word “Distance”, followed by the shortest distances in order.
For example, here is the input and the output for the graph used to illustrate the Dijkstra’s algorithm in class (the graph should be in your notes): 

Input:
5    10
0   1   10
0   4    5
1   2    1
1   4    2
2   3    4
3   0    7
3   2    6
4   1    3
4   2    9
4   3    2

Output: 
Vertex           0	1	2         3        4
Distance       0	8	9         7        5

In the above example, the graph has 5 vertices and 10 edges. The first edge is from Vertex 0 to Vertex 1 and has a weight of 10, and so on. 

