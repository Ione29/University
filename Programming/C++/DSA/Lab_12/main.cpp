#include <iostream>
#include "hash.h"
#define VMAX 17
#define P 13

using namespace std;

///our hash function - keys of type int
int hfunc(int key) {
    return (P * key) % VMAX;
}

/// add a second hash function with keys of type string


int main() {

    ///create the hashtables here or globally
    Hashtable<int, int> table(VMAX, *hfunc);

    ///test the functions    
    table.put(1, 15);
    table.put(2, 33);
    table.put(3, 100);


	return 0;
}

