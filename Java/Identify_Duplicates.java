import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Identify_Duplicates {

	public static void main(String[] args) {
		ArrayList<Integer> list_with_dupes = new ArrayList<Integer>();
		list_with_dupes.add(4);
		list_with_dupes.add(4);
		list_with_dupes.add(2);
		list_with_dupes.add(3);
		list_with_dupes.add(3);
		list_with_dupes.add(3);
	
		Set<Integer> dupes = new HashSet<Integer>();
		dupes = find_duplicates(list_with_dupes);
		System.out.println(dupes.toString());
		
		Set<Integer> non_dupes = new HashSet<Integer>();
		
		for (int num : list_with_dupes) {
			if (!dupes.contains(num))
				non_dupes.add(num);
		}
		System.out.println(non_dupes.toString());
	}
	
	public static Set<Integer> find_duplicates(ArrayList<Integer> list_with_dupes) {
		final Set<Integer> dupes = new HashSet<Integer>();
		final Set<Integer> uniques = new HashSet<Integer>();
		for (int i : list_with_dupes) {
			if (!uniques.add(i)) dupes.add(i); // this works too
			
			// this works too
//			if (!uniques.contains(i)) uniques.add(i);
//			else dupes.add(i);
		}
		return dupes;
	}

}
