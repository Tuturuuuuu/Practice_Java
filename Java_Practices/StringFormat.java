import java.util.*;
import java.io.*;
import java.math.*;

public class StringFormat {
	public String text;
	public String format;

	public StringFormat(String textInput, String formatInput){
		text = textInput;
		format = formatInput;
	}

	public String printResult(boolean r) {
		return r ? "MATCH":"FAIL";
	}

	public boolean Solve(String text, String format) {
		int formatIndex = 0;
		for(int i=0; i<text.length(); i++) {
			if(format.charAt(formatIndex) == '~') {
				if(format.length()-1 <= formatIndex) {
					return true;
				} else {
					while(!isMatch(format.charAt(formatIndex+1), text.charAt(i))) {
						if(text.length()-1 <= i) {
							return false;
						}
						i++;
					}
					if(format.charAt(formatIndex+1) != '?') {
						i--;
					}
					formatIndex++;
				}

			} else if(isMatch(format.charAt(formatIndex), text.charAt(i))) {
				formatIndex++;
			} else {
				return false;
			}
		}
		return true;
	}


	public boolean isMatch(char x, char y) {
		if(x == '?'|| x=='~' || x == y){
			return true;
		} else {
			return false;
		}
	}
}