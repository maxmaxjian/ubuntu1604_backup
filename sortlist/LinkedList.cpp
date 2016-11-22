#include "LinkedList.hpp"

LinkedList::LinkedList(const vector<int> & nums) {
  head = make_shared<ListNode>(nums[0]);
  pNode curr = head;
  for (size_t i = 1; i < nums.size(); i++) {
    curr->next = make_shared<ListNode>(nums[i]);
    curr = curr->next;
  }
}

void LinkedList::print() {
  // pNode curr = head;
  // while (curr != nullptr) {
  //   curr->print();
  //   curr = curr->next;
  // }
  int len = getLength();
  for (int i = 0; i < len; i++) {
    // cout << "node " << i << ": ";
    find(i)->print();
  }
}

int LinkedList::getLength() {
  int count = 1;
  pNode curr = head;
  while (curr->next != nullptr) {
    count++;
    curr = curr->next;
  }

  return count;
}

pNode LinkedList::find(int kth) {
  assert(kth < getLength());

  int count = 0;
  pNode curr = head;
  while (curr != nullptr && count != kth) {
    count++;
    curr = curr->next;
  }

  return curr;
}

void LinkedList::swap(int i, int j) {
  assert(i < getLength() && j < getLength());

  // if (i != 0 && j != 0) {
  //   pNode previ = find(i-1), prevj = find(j-1);
  //   pNode temp;
  //   if (previ->next != prevj && prevj->next != previ) {
  //     temp = previ->next->next;
  //     previ->next->next = prevj->next->next;
  //     prevj->next->next = temp;

  //     temp = previ->next;
  //     previ->next = prevj->next;
  //     prevj->next = temp;
  //   }
  //   else if (previ->next == prevj) {
  //     temp = previ->next;
  //     previ->next = previ->next->next;
  //     temp->next = previ->next->next;
  //     previ->next->next = temp;
  //   }
  //   else {
  //     temp = prevj->next;
  //     prevj->next = prevj->next->next;
  //     temp->next = prevj->next->next;
  //     prevj->next->next = temp;
  //   }
  // }

  pNode nodei = find(i), nodej = find(j);
  int temp = nodei->val;
  nodei->val = nodej->val;
  nodej->val = temp;
}

void LinkedList::sort() {
  quicksort(0, getLength()-1);
}

void LinkedList::quicksort(int start, int end) {
  if (start < end) {
    int p = partition(start, end);
    // cout << "p = " << p << endl;
    quicksort(start,p-1);
    quicksort(p+1, end);
  }
}

int LinkedList::partition(int start, int end) {
  int p = end;
  int firsthigh = start;
  for (int i = start; i < end; i++) {
    if (find(i)->val < find(p)->val) {
      if (i != firsthigh) {
	swap(i, firsthigh);
      }
      firsthigh++;
    }
  }
  swap(firsthigh, p);
  return firsthigh;
}
