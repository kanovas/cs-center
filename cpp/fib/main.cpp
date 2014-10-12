#include <iostream>
#include "fib.h"
#include "fib.cpp"
using namespace std;

int main() {
    int n;
    cin >> n;
    cout << fib(n) << endl;
    return 0;
}