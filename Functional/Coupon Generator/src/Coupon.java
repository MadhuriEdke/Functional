import java.util.*;
import java.util.stream.*;


public class Coupon {
	
	
public static void main(String[] args) {
	System.out.println("Enter the Coupon Length");
    Scanner sc = new Scanner(System.in);
	int len = sc.nextInt();
	System.out.println("Enter the Number Of Coupon You Want");
	int num = sc.nextInt();
	Set<Integer> result = getCoupon(len , num);
	System.out.println(result);
	
}

private static Set<Integer> getCoupon(int len ,int num) {
	Random r = new Random();
	/*The nextInt(n) method returns a random integer in the range 0 to n-1 inclusive. 
	 * So the lowest possible value of num is 0 + 1000000 = 1000000, 
	 * and the highest possible value is 90000000 - 1 + 10000000 = 99999999, as desired.
	 */
	int inner = (int) (9 * Math.pow(10, len-1));
	int add = (int) (10 * Math.pow(10, len-2));
	int[] randomArray = new int [num]; ////Array for Result 
	
	int c=0;

	while(c < num) {
		int newRandomNum = r.nextInt(inner)+add;
		    randomArray[c]= newRandomNum;
		    c++;
	}
	
	List<Integer> list = new ArrayList(randomArray.length);
	for(int i:randomArray) {
		list.add(Integer.valueOf(i));
	}
	
	Set<Integer> set = list.stream().collect(Collectors.toSet()); 
	int sizeOfSet = set.size();
	
	while(sizeOfSet< num) {
		int newRandomNum = r.nextInt(inner)+add;
		set.add((Integer)newRandomNum);
		sizeOfSet++;
	}
	//int newRandomNum = r.nextInt(90000000)+10000000;
	return set;
}
}
