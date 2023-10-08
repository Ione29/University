#include <stdlib.h>

int vectGt(int* v, int n, int val){
    if(n < 0) return 0;
    return v[n] > val ? 1 + vectGt(v, n - 1, val): vectGt(v, n - 1, val);
}

int vectLt(int* v, int n, int val){
    if(n < 0) return 0;
    return v[n] > val ? 1 + vectLt(v, n - 1, val): vectLt(v, n - 1, val);
}