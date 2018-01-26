import java.util.*;
import java.io.*;
import java.math.*;

/*
You are given a line of text and a "string format".
The format seems to be heavily inspired from LIKE clauses from SQL and uses two special characters, ? and ~:

?: Matches exactly one character.
~: Matches any number of characters, from zero (none) to the entire string.
Any other characters: Matches exactly that character.

It seems that the format does not include escaping special characters (good for you!)
so ? and ~ in text may only be matched by ? and ~ under the right circumstances.
The backslash character will match only the backslash character itself.

The text is considered to MATCH if the format describes the text from start to end with no
characters rejected by the pattern. If it does not match, write FAIL instead.


Problem by: Unihedron
https://www.codingame.com/profile/1d1729a2d8c008c6cf728ee88f1faa6d4978712
*/

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