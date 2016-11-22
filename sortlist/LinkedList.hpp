#include <iostream>
#include <memory>
#include <vector>
#include <cassert>

using namespace std;

struct ListNode {
  int val;
  shared_ptr<ListNode> next;

  ListNode(int x, shared_ptr<ListNode> nx = nullptr) : val(x), next(nx) {}

  void print() {
    if (next != nullptr)
      cout << "val = " << val << " -> ";
    else
      cout << "val = " << val << endl;
  }
};

using pNode = shared_ptr<ListNode>;

class LinkedList {
public:
  pNode head;

public:
  LinkedList(const vector<int> & nums);

  void print();

  int getLength();

  pNode find(int kth);

  void swap(int i, int j);

  void sort();

  void quicksort(int start, int end);

  int partition(int start, int end);
};
