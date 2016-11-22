
class Sorting {
    public String sort(String s) {
	char[] strArr = s.toCharArray();
	return quicksort(strArr, 0, strArr.length-1);
    }

    private String quicksort(char[] s, int start, int end) {
	if (start < end) {
	    int p = partition(s, start, end);
	    quicksort(s, start, p-1);
	    quicksort(s, p+1, end);
	}
	return new String(s);
    }

    private int partition(char[] arr, int start, int end) {
	int p = end;
	int firsthigh = start;
	for (int i = start; i <= end; i++) {
	    if (arr[i] < arr[p]) {
		swap(arr, i, firsthigh);
		firsthigh++;
	    }
	}
	swap(arr, firsthigh, p);
	return firsthigh;
    }

    private void swap(char[] s, int i, int j) {
	char temp = s[i];
	s[i] = s[j];
	s[j] = temp;
    }

    public static void main(String[] args) {
	// String toSort = "arandomstringtosort";
	String toSort = "031245651326767899";
	System.out.println("The string before sorting is:");
	System.out.println(toSort);

	Sorting sortAlgm = new Sorting();
	String sorted = sortAlgm.sort(toSort);
	System.out.println("The string after sorting is:");
	System.out.println(sorted);
    }
}
