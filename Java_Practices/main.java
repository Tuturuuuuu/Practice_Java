import java.util.*;
import java.io.*;
import java.math.*;

public class main{
	public static void main(String args[]) {
		StringFormat f = new StringFormat(";Z8Rx3u4)i~ax;20*7:B|3^",  "~u4)i?a?;?*~");
		System.out.println(f.printResult(f.Solve()));

		int[] x = {-5, -4, -2, 12, -40, 4, 2, 18, 11, 5, 2};
		TemperatureToZero t = new TemperatureToZero(x.length, x);
		t.intClosestToZero();
	}
}