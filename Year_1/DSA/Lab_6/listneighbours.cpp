#include <stdio.h>
#include "linked_list.h"
#include "queue2.h"

template<typename TedgeInfo> struct list_elem_info {
    int node;
    TedgeInfo edgeInfo;
};

template<typename TnodeInfo, typename TedgeInfo> 
class Graph {
    public:
        int N;
        LinkedList<struct list_elem_info<TedgeInfo> > *L;
        TnodeInfo *nodeInfo;

        Graph(int numNodes) {
            N = numNodes;
            L = new LinkedList<struct 
                         list_elem_info<TedgeInfo> > [N];
            nodeInfo = new TnodeInfo[N];
        }
        void setNodeInfo(int i, TnodeInfo info) {
            nodeInfo[i] = info;
        }

        TnodeInfo getNodeInfo(int i) {
            return nodeInfo[i];
        }

        void addEdge(int i, int j) {
            struct list_elem_info<TedgeInfo> lei_i, lei_j;
            lei_i.node = j;
            lei_j.node = i;

            L[i].addFirst(lei_i);
            L[j].addFirst(lei_j);
        }

        void removeEdge(int i, int j) {
            struct list_elem<struct list_elem_info<TedgeInfo> > *p;
            p = L[i].pfirst;
            while (p != NULL) {
                if (p->info.node == j)
                    break;
                p = p->next;
            }

// remove the element pointed to by p from L[i] -- code ommitted

            p = L[j].pfirst;
            while (p != NULL) {
                if (p->info.node == i)
                    break;
                p = p->next;
            }

// remove the element pointed to by p from L[j] -- code ommitted
        }

        void setEdgeInfo(int i, int j, TedgeInfo info) {
            struct list_elem<struct list_elem_info<TedgeInfo> > *p;
            p = L[i].pfirst;
            while (p != NULL) {
                if (p->info.node == j)
                    break;
                p = p->next;
            }
            p->info.edgeInfo = info;

            p = L[j].pfirst;
            while (p != NULL) {
                if (p->info.node == i)
                    break;
                p = p->next;
            }
            p->info.edgeInfo = info;
        }

        TedgeInfo getEdgeInfo(int i, int j) {
            struct list_elem<struct list_elem_info<TedgeInfo> > *p;
            p = L[i].pfirst;
            while (p != NULL) {
                if (p->info.node == j)
                    break;
                p = p->next;
            }
			
            return p->info.edgeInfo;
        }

        ~Graph() {
            int i;
            delete nodeInfo;
            for (i = 0; i < N; i++)
                while (!L[i].isEmpty())
                    L[i].removeFirst();
            delete L;
        }
};

Graph<int, int> g(7);
bool* visited;
void dfs(int x) {
    int y;
    struct list_elem<struct list_elem_info<int> > *p;
    printf("%d\n", x);
    visited[x] = 1;
    p = g.L[x].pfirst;

    while (p != NULL) {
        y = p->info.node;
        if (!visited[y])
            dfs(y);
        p = p->next;
    }
}

int *dist;

void bfs(int S) {
    Queue<int> Q;
    int x, y;
    struct list_elem<struct list_elem_info<int> > *p;
    Q.enqueue(S);
    visited[S] = 1;
    dist[S] = 0;
    
    while (!Q.isEmpty()) {
        x = Q.dequeue();
        printf("%d: dist=%d\n", x, dist[x]);

        p = g.L[x].pfirst;
        while (p != NULL) {
            y = p->info.node;
            if (!visited[y]) {
                visited[y] = 1;
                dist[y] = dist[x] + 1;
                Q.enqueue(y);
            }

            p = p->next;
        }
    }
}
int main() {
    int i;

    g.addEdge(0, 1); g.addEdge(0, 2);
    g.addEdge(0, 3); g.addEdge(1, 6);
    g.addEdge(2, 5); g.addEdge(3, 4);
    g.addEdge(4, 6); g.addEdge(5, 1);

    visited = new bool[g.N];
    for (i = 0; i < g.N; i++)
        visited[i] = 0;
    printf("DFS:\n");
    dfs(4);

    for (i = 0; i < g.N; i++)
        visited[i] = 0;
    dist = new int[g.N];
    printf("BFS:\n");
    bfs(4);

    return 0;
}

