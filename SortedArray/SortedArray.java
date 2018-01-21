class SortedArray {
	private int[] a;
	private int[] temp;
	int count = 0;
	final int buffer = 5;
	
	public SortedArray() {
		a = new int[0];
	}
	
	public void printArray() {
		System.out.print("Array: ");
		for (int i = 0; i < count; i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}
	
	public int index(int n) {
		int k = 0, size = a.length;
		if (size == 0) return -1;
		else {
				while ((n > a[k]) && (k < size - 1)) k++;
				if (a[k] == n) return k;
				else if (k == 0) return -1;
					 else return -k;
		}		
	}
	
	public void add(int n) {
		count++;
		int size = a.length;
		if (count > size){
			temp = new int[size];
			for(int i = 0; i < size; i++) temp[i] = a[i];
			a = new int[size + buffer];
			for(int i = 0; i < size; i++) a[i] = temp[i];
		}
		if (count == 1)
			a[0] = n;
		else {
			if (n <= a[0]) {
				for(int i = count - 1; i > 0 ; i--) a[i] = a[i - 1];
				a[0] = n;
			} else if (n >= a[count - 2]) a[count - 1] = n;
					else {
						int k = Math.abs(index(n));
						for(int i = count - 1; i >= k ; i--) a[i] = a[i - 1];
						a[k] = n;
					}
		}
	}

	public boolean remove(int n) {
		if (count == 0) {
			return false;
		} else {
				int k = index(n);
				if (k < 0) {
					return false;
				} else {
						count --;
						for(int i = k; i < count; i++) a[i] = a[i + 1]; 
						a[count] = 0;
				
						int size = a.length;
						if (size > count + buffer){
							temp = new int[size - buffer];
							for(int i = 0; i < count; i++) temp[i] = a[i];
							a = new int[size - buffer];
							for(int i = 0; i < count; i++) a[i] = temp[i];
						}
						return true;
				  }
			}
	}
}