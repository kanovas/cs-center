#include "matrices.cpp"

using namespace std;

void read(const char * arg, matrix* matr) {
    unsigned long pos;
    string sarg = arg;
    pos = sarg.find(".txt");
    if(pos && pos < sarg.length()) {
        if(pos == sarg.length() - 4) {
            try {
                ifstream input;
                input.open(arg);
                matr->read_matrix(input);
            }
            catch (...) {
                throw std::runtime_error("Wrong matrix file");
            }
        }
        else {
            throw std::runtime_error("You should input matrix in file matrix_name.txt");
        }
    }
    else {
        throw std::runtime_error("You should input matrix in file matrix_name.txt");
    }
}

int main(int argc, char ** argv) {
    matrix* ans = new matrix(0, 0, new double[0]);
    matrix* matr = new matrix(0, 0, new double[0]);
    if (argc < 2) {
        throw std::runtime_error("You should input arguments");
    }
    read(argv[1], ans);
    int i = 2;
    while(i < argc) {
        unsigned long pos;
        string arg = argv[i];
        pos = arg.find("--");
        if(!pos) {
            if(arg.find("add") && arg.length() == 5) {
                read(argv[++i], matr);
                *ans += *matr;
                i++;
            }
            else if(arg.find("mult") && arg.length() == 6) {
                read(argv[++i], matr);
                *ans *= *matr;
                i++;
            }
            else {
                throw std::runtime_error("Wrong operation. The program supports --add and --mult");
            }
        }
        else {
            throw std::runtime_error("Wrong operation format. The program supports --add and --mult");
        }
    }
    ans->print_matrix(cout);
    return 0;
}