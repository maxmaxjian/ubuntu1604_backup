
#include "LinkedList.hpp"

int main() {
  vector<int> nums{3,2,1,4,5};
  LinkedList list(nums);
  // list.print();

  // list.swap(0,4);
  cout << "Before sorting:" << endl;
  list.print();

  list.sort();
  cout << "After sorting:" << endl;
  list.print();  

  return 0;
}
