package in.ineuron.nitin.test;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestMockVsSpy {

	@Test
	public void testList() {
		
		//Mock Object for ArrayList class
		ArrayList<String> listMock = Mockito.mock(ArrayList.class);
		
		//Spy Object for ArrayList class
		ArrayList<String> listSpy = Mockito.spy(new ArrayList<String>());
		
		//Stubbing on Mock object
		Mockito.when(listMock.size()).thenReturn(10);
		
		//Mock Object:: Stub implementation will be used
		listMock.add("sachin");
		
		//Stubbing on Spy Object
		Mockito.when(listSpy.size()).thenReturn(10);
		
		//Spy Object :: Actual implementation of ArrayList is used
		listSpy.add("sachin");
		
		System.out.println(listMock.size() + "::"  +listSpy.size());
		
	}
	
}
