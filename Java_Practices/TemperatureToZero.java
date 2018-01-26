import java.util.*;
import java.io.*;
import java.math.*;
/*
Write a program that prints the temperature closest to 0 among input data.
If two numbers are equally close to zero, positive integer has to be considered closest
to zero (for instance, if the temperatures are -5 and 5, then display 5).
*/

public class TemperatureToZero {
	public int total;
	public int[] temperature;
	public TemperatureToZero(int aTotal, int[] aTemperature) {
		total = aTotal;
		temperature = aTemperature;
	}

	public int intClosestToZero() {
		int result = 0;
		for (int i = 0; i < total; i++) {
			if(i == 0) {
				result = temperature[i];
			} else {
				if(temperature[i] > 0) {
					if(Math.abs(result) == Math.abs(temperature[i])) {
						result = Math.abs(temperature[i]);
					} else if(result > temperature[i]) {
						result = temperature[i];
					}
				} else {
					if(Math.abs(result) == Math.abs(temperature[i])) {
						if(result < 0) {
							result = temperature[i];
						} else {
							result = Math.abs(temperature[i]);
						}
					} else if(Math.abs(result) > Math.abs(temperature[i])) {
						result = temperature[i];
					}
				}
			}

		}
        System.out.println(result);
        return result;
	}
}