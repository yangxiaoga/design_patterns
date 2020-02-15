package com.ethan.design.patterns;

import java.util.ArrayList;
import java.util.Collections;



/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(final String[] args) {
		final String s1 = "aab";
		final String s2 = "acb";
		System.out.print(s1.compareTo(s2));
		final java.util.List<String> sList = new ArrayList<String>();
		Collections.synchronizedList(sList);
	}

}
