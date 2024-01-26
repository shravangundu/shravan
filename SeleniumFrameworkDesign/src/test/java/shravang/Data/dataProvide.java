package shravang.Data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	
	//multiple set of data to our tests
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String greeting, String comm, int id) {
		
		System.out.println(greeting+" "+comm+" "+id);
		
	}
	
	@DataProvider(name = "driveTest")
	public Object[][] getData() {
		
		Object[][] data = {{"Hello","text", 1},{"bye","message", 143}, {"solo", "call", 453}};
		 return data;
		
	}

}
