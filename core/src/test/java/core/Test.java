package core;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		try {
			r.exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
