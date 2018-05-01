import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;

public class Shell_Sort {
	ArrayList<Integer> value = new ArrayList<Integer>();

	public void shellSort(int gap) {
		int temp = 0;
		while (temp < gap) {
			for (int i = temp; i < value.size(); i = (i + gap)) {
				for (int j = i + temp; j < value.size(); j = j + gap) {
					if (value.get(i).compareTo(value.get(j)) > -1) {
						swap(i, j);
					}
				}
			}
			temp++;
		}
		for (int j = 1; j < value.size(); j++) {
			int x = value.get(j);
			int i = j - 1;
			while (i >= 0 && value.get(i) > x) {
				value.set(i + 1, value.get(i));
				i = i - 1;
			}
			value.set(i + 1, x);
		}

	}

	public static void swap(Integer a, Integer b) {
		int temp = value.get(a);
		value.set(a, value.get(b));
		value.set(b, temp);
	}
}
