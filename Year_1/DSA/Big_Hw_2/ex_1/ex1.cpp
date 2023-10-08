#include <iostream>
#include "adjacencymatrix_directed.h"
using namespace std;

bool *visited;
Graph<unsigned, unsigned> seaChart;
int path[] = { 0 }, maxPath[] = { 0 }, k, maxK, profit, maxProfit, start, finish,  nrP = 0;

bool ok(int currentI, int currentJ)
{
    if(seaChart.A[currentI][currentJ])
    {

        profit += seaChart.getEdgeInfo(currentI, currentJ);
        path[k++] = currentJ;
        return 1;
    }
    else return 0;    
}

bool isSolution()
{
    if(path[0] == start and path[seaChart.getSize() - 1] == finish)
        return true;
    else return false;

}

void write(){
    cout << "How many ports do we have ?";
    unsigned n; cin >> n;
    
    seaChart.initialize(n);
    
    cout << "Type in the routes that Jack Sparrow can take! When you are done, type \"0 0\" as a path";
    
    ///we read the paths from keyboard
    for(int i = 0; true; i++)
    {
        unsigned x, y, z; ///x is the starting node, y is the finish node, z is the edge info
        
        cout << endl << "Route " << (i + 1), cin >> x >> y;
        if(!(x and y))///"0 0" case
            break;
        seaChart.addEdge(x, y);
        
        ///set the value of the edge
        cout << " | Coins that can be found: ";
        cin >> z;
        seaChart.setEdgeInfo(x, y, z);
    }
    
    cout << "Path :" << ++nrP;

    for(int i = 0; i < k; i++)
        cout << ' ' << path[i];

    cout << " | Profit made on this path: " << profit;            

    if(profit > maxProfit)
    {
        maxProfit = profit;

        for(int i = 0; i < k; i++)
            maxPath[i] = path[i];
        
        for(int i = k; i <= maxK; i++)
            maxPath[i] = 0;
    }
}

void navigation(int currentI, int currentJ)
{
    if(start == finish)
        cout << "Captain Jack Sparrow and Captain Barbossa are already in the same port !";

    if(path[0] == start)
    {
        profit = 0;
        k = 0;
        currentI = 0;
    }

    for(int i = 0; i <= seaChart.getSize(); i++)
    {
        currentJ = i;

        if(ok(currentI, currentJ))
        {
            if(isSolution())
                write();
            else
                navigation(currentI = currentJ, currentJ++);
        }
    }

}

int main()
{
    cout << "How many ports do we have ?";
    unsigned n; cin >> n;
    
    seaChart.initialize(n);
    
    cout << "Type in the routes that Jack Sparrow can take! When you are done, type \"0 0\" as a path";
    
    ///we read the paths from keyboard
    for(int i = 0; true; i++)
    {
        unsigned x, y, z; ///x is the starting node, y is the finish node, z is the edge info
        
        cout << endl << "Route " << (i + 1), cin >> x >> y;
        if(!(x and y))///"0 0" case
            break;
        seaChart.addEdge(x, y);
        
        ///set the value of the edge
        cout << " | Coins that can be found: ";
        cin >> z;
        seaChart.setEdgeInfo(x, y, z);
    }
    
    navigation(0, 0);

    return 0;
}