#include "huffman.hpp"

void zip(std::ifstream input, std::ofstream output) {
    int table [512];
    char c;
    while (!input.eof()) {
        input.read(& c, 1);
        std::cout << c << " ";
        table[256 + c]++;
    }

}

void unzip(std::ifstream input, std::ofstream output) {

}