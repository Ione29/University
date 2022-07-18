#ifndef ADJACENCYMATRIX_UNDIRECTED_H_INCLUDED
#define ADJACENCYMATRIX_UNDIRECTED_H_INCLUDED
#include <stdio.h>
#include <queue>
#include <iostream>

using namespace std;

template<typename TnodeInfo, typename TedgeInfo>
class Graph {
    public:
        int N;
        char **A;
        TnodeInfo *nodeInfo;
        TedgeInfo **edgeInfo;

        Graph(int numNodes)
        {
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

        void initialize(int numNodes)
        {
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

        void setNodeInfo(int i, TnodeInfo info)
        {
            nodeInfo[i] = info;
        }

        TnodeInfo getNodeInfo(int i)
        {
            return nodeInfo[i];
        }

        void addEdge(int i, int j)
        {
            A[i][j] = 1;
        }

        void removeEdge(int i, int j)
        {
            A[i][j] = 0;
        }

        void setEdgeInfo(int i, int j, TedgeInfo info)
        {
            edgeInfo[i][j] = info;
        }

        TedgeInfo getEdgeInfo(int i, int j)
        {
            return edgeInfo[i][j];
        }

        int getSize()
        {
            return N;
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

#endif // ADJACENCYMATRIX_UNDIRECTED_H_INCLUDED
