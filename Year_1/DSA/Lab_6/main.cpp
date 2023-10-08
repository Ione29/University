#include <stdio.h>
#include <queue>
#include <iostream>
/// http://www.cplusplus.com/reference/queue/queue/
using namespace std;

template<typename TnodeInfo, typename TedgeInfo>
class Graph {
    public:
        int N;
        char **A;
        TnodeInfo *nodeInfo;
        TedgeInfo **edgeInfo;

        Graph(int numNodes) {
            int i, j;

            N = numNodes;

            /// allocate the adjacency matrix
            A = new char*[N]; ///allocated rows
            for (i = 0; i < N; i++)
                A[i] = new char[N]; ///allocated columns

			for (i = 0; i < N; i++)
                for (j = 0; j < N; j++)
                    A[i][j] = 0;

            // allocate the array with node information
            nodeInfo = new TnodeInfo[N];

            // allocate the matrix of edge information
            edgeInfo = new TedgeInfo*[N];
            for (i = 0; i < N; i++)
                edgeInfo[i] = new TedgeInfo[N];
        }

        void setNodeInfo(int i, TnodeInfo info) {
            nodeInfo[i] = info;
        }

        TnodeInfo getNodeInfo(int i) {
            return nodeInfo[i];
        }

        void addEdge(int i, int j) {
            A[i][j] = A[j][i] = 1;
        }
        void removeEdge(int i, int j) {
            A[i][j] = A[j][i] = 0;
            }

        void setEdgeInfo(int i, int j, TedgeInfo info) {
            edgeInfo[i][j] = edgeInfo[j][i] = info;
            }

        TedgeInfo getEdgeInfo(int i, int j) {
            return edgeInfo[i][j];
            }

        ~Graph() {
            int i;
            for (i = 0; i < N; i++) {
                delete A[i];
                delete edgeInfo[i];
            }
            delete A;
            delete edgeInfo;
            delete [] nodeInfo;
        }
};

Graph<int, int> g(9);
char* visited;

void dfs(int x) {
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

    while (!Q.empty()) {
        x = Q.front();
		Q.pop(); ///dequeue
        cout << x << " ";
        for (y = 0; y < g.N; y++)
            if (g.A[x][y] && !visited[y]) {
                visited[y] = 1;
               Q.push(y);
            }
    }
}

bool checkBipartite(int S) {
    std::queue<int> Q;
    int x, y;

    Q.push(S);
    visited[S] = 1;

    g.setNodeInfo(S, 0);

    while (!Q.empty()) {
        x = Q.front();
		Q.pop(); ///dequeue
        cout << x << " ";
        for (y = 0; y < g.N; y++)
            if (g.A[x][y] && !visited[y]) 
            {
                g.setNodeInfo(y, 1 - g.getNodeInfo(x));
                visited[y] = 1;
                Q.push(y);
            }

            if(g.getNodeInfo(x) == g.getNodeInfo(y) && g.A[x][y] == 1)
                return false;
    }

    return true;
}

void theSocialNetwork(int x, int limit, int k)
{
    int y;
    visited[x] = 1;

    for (y = 0; y < g.N; y++)
        if (g.A[x][y])
        {   
        cout << y << " | Friendship degree: " << k;
        theSocialNetwork(y, limit + 1, k++);
        }
        else if(k <= limit)
                break;
}


int main() {
    int i;
    /*
    g.addEdge(0, 1);    g.addEdge(1, 3);
    g.addEdge(0, 3);    g.addEdge(5, 3);
    g.addEdge(3, 6);    g.addEdge(6, 10);
    g.addEdge(6, 11);   g.addEdge(10, 11);
    g.addEdge(6, 4);    g.addEdge(2, 6);
    g.addEdge(7, 2);    g.addEdge(9, 2);
    g.addEdge(9, 8);    g.addEdge(8, 2);
    g.addEdge(7, 4);
    */

	//Task 1: create the graph from ex 1
    /*
    g.addEdge(1, 3);
    g.addEdge(3, 5);
    g.addEdge(5, 7);
    g.addEdge(4, 7);
    g.addEdge(5, 6);
    g.addEdge(6, 4);
    g.addEdge(4, 2);
    g.addEdge(4, 0);


    visited = new char[g.N];
    for (i = 0; i < g.N; i++)
        visited[i] = 0;

    cout << "DFS: "; dfs(4);

    visited = new char[g.N];
    for (i = 0; i < g.N; i++)
        visited[i] = 0;

    cout << endl << "BFS: "; bfs(4);
    */
	///Task 2: Check if a graph is bipartite
    /*
    visited = new char[g.N];
        for (i = 0; i < g.N; i++)
            visited[i] = 0;

    g.addEdge(0, 1);    g.addEdge(0, 2);
    g.addEdge(3, 4);    g.addEdge(4, 5);
    g.addEdge(4, 6);    g.addEdge(1, 3);
    g.addEdge(4, 7);    g.addEdge(6, 8);
    g.addEdge(2, 3);    g.addEdge(7, 8);

    if(checkBipartite(0))
        cout << "It is";
    else cout << "It isn't";

    cout << endl;
    */
    ///Task 3: The Social Network
    
    g.addEdge(1, 3);
    g.addEdge(3, 5);
    g.addEdge(5, 7);
    g.addEdge(4, 7);
    g.addEdge(5, 6);
    g.addEdge(6, 4);
    g.addEdge(4, 2);
    g.addEdge(4, 0);

    cout << endl;
    theSocialNetwork(0, 3, 1);

    cout << endl;
    return 0;
}

