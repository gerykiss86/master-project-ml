/**
 * 
 */
package com.kiss.mlwebui.test;

import java.util.ArrayList;

import com.kiss.mlwebui.prediction.*;

/**
 * @author Gery
 *
 */
public class Test extends junit.framework.TestCase {

	public Test(String name) {
		super(name);
	}

	protected void setUp() throws Exception {

		super.setUp();

	}

	public void testPrediction() {

		System.out.println("TEST CASE");
		
		try {

			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < 52; i++) {
				list.add(Integer.toString(i));
			}

			System.out.println(Prediction.predict(list));
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
