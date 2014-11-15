#include <iostream>
#include "huffman.hpp"

using namespace std;

int main(int argc, char ** argv) {
    if (argc < 2) {
        throw std::runtime_error("You should input arguments");
    }

    //USAGE:
    // argv[1] - function ('c' / 'u')
    // argv[2] - "-f"
    // argv[3] - input file name
    // argv[4] - "-o"
    // argv[5] - output file name

    if (argv[1] != "-c" || argv[1] != "-u") {
        throw std::runtime_error("Availible functions: zipping (-c) and unzipping (-u)");
    }
    if (argv[2] != "-f") {
        throw std::runtime_error("You should input arguments, using pattern -func -f <input file name> -o <output file name>");
    }
    if (argv[4] != "-o") {
        throw std::runtime_error("You should input arguments, using pattern -func -f <input file name> -o <output file name>");
    }

    ifstream input;
    ofstream output;
    try {
        input.open(argv[3]);
    }
    catch (...) {
        throw std::runtime_error("Can't open input file");
    }

    try {
        output.open(argv[5]);
    }
    catch (...) {
        throw std::runtime_error("Can't open output file");
    }

    if (argv[1] == "-c") {
        zip(input, output);
    }
    else {
        unzip(input, output);
    }
    return 0;
}