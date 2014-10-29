#include "matrices.hpp"

matrix::matrix(int n, int m, double* const& matrix_) {
    this->n = n;
    this->m = m;
    this->matrix_ = matrix_;
}

matrix& matrix::operator = (matrix const& other) {
    n = other.n;
    m = other.m;
    matrix_ = other.matrix_;
    return *this;
}

matrix::~matrix() {
    delete [] matrix_;
    matrix_ = 0;
}

matrix& matrix::read_matrix(std::ifstream& input) {
    try {
        input >> n >> m;
        matrix_ = new double[n * m];
        for(int i = 0; i < n * m; i++) {
            input >> matrix_[i];
        }
        return *this;
    }
    catch (...) {
        throw std::runtime_error("Wrong matrix file format");
    }
}

void matrix::print_matrix(std::ostream& out) {
    out << n << ' ' << m << endl;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            out << matrix_[i * m + j] << ' ';
        }
        out << endl;
    }
}

matrix& matrix::operator += (matrix const& a) {
    if(n != a.n || m != a.m) {
        throw std::runtime_error("Impossible to count sum for matrices of different sizes");
    }
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            matrix_[i * m + j] += a.matrix_[i * m + j];
        }
    }
    return *this;
}

matrix& matrix::operator *= (matrix const& a) {
    if(m != a.n) {
        throw std::runtime_error("Impossible to multiply matrices where m1 != n2");
    }
    matrix* ans = new matrix(n, a.m, new double[n * a.m]);
    long long cur_sum;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < a.m; j++) {
            cur_sum = 0;
            for(int k = 0; k < m; k++) {
                cur_sum += matrix_[i * m + k] * a.matrix_[k * a.m + j];
            }
            ans->matrix_[i * m + j] = cur_sum;
        }
    }
    *this = *ans;
    return *this;
}