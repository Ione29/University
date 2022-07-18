#include "adjacencymatrix_directed.h"

Graph<int, int> g(10);
char* visited;

void resetVisited()
{
    visited = new char[g.N];
    for (int i = 0; i < g.N; i++)
        visited[i] = 0;
}


void dfs(int x)
{
    int y;
    cout << x << " ";
    visited[x] = 1;

    for (y = 0; y < g.N; y++)
        if (g.A[x][y] && !visited[y])
            dfs(y);
}

void bfs(int S) {
    std::queue<int> Q;
    int x, y;

    Q.push(S);
    visited[S] = 1;

    while (!Q.empty())
    {
        x = Q.front();
        Q.pop(); ///dequeue
        cout << x << " ";
        for (y = 0; y < g.N; y++)
            if (g.A[x][y] && !visited[y])
            {
                visited[y] = 1;
               Q.push(y);
            }
    }
}

bool checkWeakCon()
{
    ///for each node
    for(int i = 0; i < 10; i++)
    {
        bool connected = false;

        ///we check the connection with each other node
        for(int j = 0; j < 10; j++)
            if(g.A[i][j] or g.A[j][i])///if we find a edge either incoming or coming in the node
                connected = true;///we don't stop the program

        if(!connected)///else, the program returns false
            return false;
    }
    ///if it didn't stop until here, it means the graph is weakly connected
    return true;
}

int main()
{
    resetVisited();

    /*
    ///exercise 4
    ///creating the graph
    g.addEdge(0, 1);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(4, 1);
    g.addEdge(2, 0);
    g.addEdge(2, 5);
    g.addEdge(6, 5);
    g.addEdge(0, 7);
    g.addEdge(7, 9);
    g.addEdge(9, 7);
    g.addEdge(8, 7);

    ///applying the DFS and BFS methods
    ///which won't work properly
    cout << "DFS: "; dfs(7);

    resetVisited();

    cout << endl << "BFS: "; bfs(3);

    resetVisited();
    */

    ///exercise 5
    ///creating the graph
    g.addEdge(2, 7);
    g.addEdge(7, 0);
    g.addEdge(3, 7);
    g.addEdge(7, 5);
    g.addEdge(7, 6);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    g.addEdge(1, 4);
    g.addEdge(1, 6);

    cout << "First check: ";
    if(checkWeakCon())
        cout << "the directed graph is weakly connected.";
    else
        cout << "the directed graph is not weakly connected.";

    g.removeEdge(7, 6);
    g.removeEdge(1, 6);

    cout << "Second check: ";
    if(checkWeakCon())
        cout << "the directed graph is weakly connected.";
    else
        cout << "the directed graph is not weakly connected.";


	return 0;
}
