#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

typedef std::pair<int, int> intPair;

class Stack {
    int count; // used to keep track of # elements in stack and is used as key in the pq
    std::priority_queue<std::pair<int, int> > pq;

    public:
        Stack() : count(0) {

        }
        void push(int n);
        void pop();
        int top();
        bool isEmpty();
};

void Stack::push(int n) {
    count++;
    pq.push(intPair(count, n));
}

// pops an element and reduces count
void Stack::pop() {
    if (pq.empty()) {
        std::cout << "Nothing to pop, silly." << std::endl;
    }
    count--;
    pq.pop();
}

// returns the top element of the stack by using the count as the key to determine the highest priority (i.e. the top)
int Stack::top() {
    intPair temp = pq.top();
    return temp.second;
}   

bool Stack::isEmpty() {
    return (pq.empty());
}

int main() {
    Stack* s = new Stack();
    s->push(4);
    s->push(2);
    s->push(3);

    while (!s->isEmpty()) {
        std::cout << "The top is: " << s->top() << std::endl;
        s->pop();
    }
}
