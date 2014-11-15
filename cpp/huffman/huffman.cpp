#include "huffman.hpp"

bool compare(node & a) {
    return value > a.value;
}

void zip(std::ifstream & input, std::ofstream & output) {
    node table = new node [256];
    for (int i = 0; i < 256; i++) {
        table[i].value = 0;
        table[i].key = (char) i;
    }
    char c;
    while (!input.eof()) {
        input.read(&c, 1);
        table[c].value++;
    }
    std::sort(table, table + 256, compare);
    for (int i = 0; i < 256; i++) {
        std::cout << table[i].key << " " << table[i].value << endl;
    }
}

void unzip(std::ifstream & input, std::ofstream & output) {

}