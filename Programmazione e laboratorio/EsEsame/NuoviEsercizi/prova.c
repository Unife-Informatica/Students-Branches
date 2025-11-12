#include <stdio.h>



int f(int d) { 
    if (d <= 2) 
        return 1;
    else
        return f(d - 1);
}
int main() { 
    return f(3);
}
