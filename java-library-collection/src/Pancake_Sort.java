import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;

public class Pancake_Sort {
	static ArrayList<Integer> value = new ArrayList<Integer>();

	public static void pancakeSort() {
		int max = 0, index = 0, maxPancake = value.size();
        while(maxPancake>0){
			index=0;
			max=0;
			for (int i=0;i<maxPancake;i++) {
				if (value.get(i) > max) {
					max = value.get(i);
                  	index=i;
				}
			}
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = index; i >= 0; i--) {
				temp.push(value.get(i));
			}
			Collections.reverse(temp);
			for (int i = 0; i < temp.size(); i++) {
				value.set(i, temp.get(i));
			}
			if (maxPancake == value.size()) {
				Collections.reverse(value);
				maxPancake--;
			} else {
				temp = new ArrayList<Integer>();
				for (int i = maxPancake-1; i >= 0 ; i--) {
					temp.push(value.get(i));
				}
				Collections.reverse(temp);
				for (int i = 0; i < temp.size(); i++) {
					value.set(i, temp.get(i));
				}
				maxPancake--;
			}
      }
	}
}
