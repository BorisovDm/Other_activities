import java.util.*;

public class Test {
	private static void choice() {
		System.out.println(" ------------------------------------------");
		System.out.println("| You can:                                 |");
		System.out.println("| 1. Add an element to the array           |");
		System.out.println("| 2. Remove an element from the array      |");
		System.out.println("| 3. Know index of the element in the array|");
		System.out.println("| 4. Finish the program                    |");
		System.out.println(" ------------------------------------------");
		System.out.println("Enter the number of steps and element:");
	}
	
	public static void main(String[] args) {

		SortedArray work = new SortedArray();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello, Now we are going to do sorted array.");
		choice();
		
		boolean t1 = true;
		while (t1) {
			System.out.print("input-> ");
			switch(in.nextInt()) {
		    	case 1: 
		    		work.add(in.nextInt());
		    		work.printArray();
		    		break;
		    	case 2: 
		    		boolean flag = work.remove(in.nextInt());
		    		if (flag == true) work.printArray();
		    		else System.out.println("Remove error");
		    		break;
		    	case 3: 
		    		int k = work.index(in.nextInt());
		    		if (k < 0) System.out.println("Error, this element is not in the array!");
		    		else System.out.println("element index " + k);
		    		break;
		    	case 4: 
		    		System.out.println("-> Goodbye! <-");
		    		t1 = false;
		    		break;
		    	default: 
		    		System.out.println("Oh no, you're wrong!  (Choose 1, 2 or 3 step)");
		    		break;
			}
		}
	}
}