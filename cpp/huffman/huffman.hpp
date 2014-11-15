#ifndef HUFFMAN_HPP
#define HUFFMAN_HPP

#include <fstream>
#include <stdexcept>
#include "huffman.cpp"

using namespace std;

void zip(std::ifstream in, std::ofstream out);
void unzip(std::ifstream in, std::ofstream out);

#endif