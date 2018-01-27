import java.util.*;
import java.io.*;
import java.math.*;

/**
Casablanca’s hippodrome is organizing a new type of horse racing: duals. During a dual,
only two horses will participate in the race. In order for the race to be interesting,
it is necessary to try to select two horses with similar strength.

Write a program which, using a given number of strengths, identifies the two closest strengths
and shows their difference with an integer (= 0).

src https://www.codingame.com/ide/puzzle/horse-racing-duals
**/
public class HorseMatcher {
	int[] horseStr;

	public HorseMatcher(int[] strength) {
		horseStr = strength;
		inSort();
		findDifference();
	}

    public void findDifference() {
        int N = horseStr.length;
        int tempRes=0;
        int result=-1;
        for (int i = 0; i < N-1; i++) {
			if(horseStr[i]==horseStr[i+1]) {
				result = 0;
				break;
			} else {
				tempRes = Math.abs(horseStr[i]-horseStr[i+1]);
				if(result>0){
					if(tempRes < result) {
						result=tempRes;
					}
				} else {
					result=tempRes;
				}

			}
        }
		System.out.println(result);
    }//end f(x) findDifference()

    public void inSort() {
		int temp = 0;
		int current = 0;
		int checkIndex = 0;
		for(int i=0; i < horseStr.length; i++) {
			current = horseStr[i];
			checkIndex = i-1;

			while(checkIndex >= 0 && horseStr[checkIndex] > current) {
				horseStr[checkIndex+1] = horseStr[checkIndex];
				checkIndex--;
			}
			horseStr[checkIndex+1] = current;
		}
	}//end of f(x) sort

	public void displayHorse(){
		for(int i=0; i < horseStr.length; i++) {
			System.out.println(horseStr[i]);
		}
	}
}
