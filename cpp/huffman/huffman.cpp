#include "huffman.hpp"

bool node::compare(node & a) {
    return this->value > a.value;
}

static bool compare(node a, node b) {
    return a.compare(b);
}

node::node(int val, char k) {
    value = val;
    key = k;
}

node::~node() {
}

void zip(std::ifstream & input, std::ofstream & output) {
    node table [256];
    for (int i = 0; i < 256; i++) {
        table[i] = * new node(0, (char) i);
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