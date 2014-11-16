#ifndef HUFFMAN_HPP
#define HUFFMAN_HPP

#include <fstream>
#include <iostream>
#include <algorithm>
#include <string>
#include <stdexcept>

using namespace std;

class node {
    int value;
    char key;
public:
    friend bool compare(node & a);
};

bool compare(node & a);

void zip(std::ifstream & in, std::ofstream & out);
void unzip(std::ifstream & in, std::ofstream & out);


#endif