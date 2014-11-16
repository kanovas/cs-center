#ifndef HUFFMAN_HPP
#define HUFFMAN_HPP

#include <fstream>
#include <iostream>
#include <algorithm>
#include <string>
#include <stdexcept>

using namespace std;

class node {
    static int value;
    static char key;
public:
    node(int val = 0, char k = (char) 0);
    ~node();
    bool compare(node & a);
    friend void zip(std::ifstream & in, std::ofstream & out);
};

void zip(std::ifstream & in, std::ofstream & out);
void unzip(std::ifstream & in, std::ofstream & out);
static bool compare(node a, node b);

#endif