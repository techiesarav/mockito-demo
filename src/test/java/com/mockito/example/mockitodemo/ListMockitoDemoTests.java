package com.mockito.example.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockitoDemoTests {

	List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	public void return_diffValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void return_specificParams() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes",mock.get(0));
		assertEquals(null,mock.get(1));
	}
	
	@Test
	public void return_GenericParams() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes",mock.get(0));
		assertEquals("in28Minutes",mock.get(1));
	}
	
	@Test
	//verify check whether specify method in mock
	//is called with specific args
	public void verification_Basics() {
		String val1 = mock.get(0);
		String val2 = mock.get(1);
		verify(mock).get(0);
		verify(mock,atMost(2)).get(anyInt());
		verify(mock,times(1)).get(0);
		verify(mock,atLeastOnce()).get(0);
		verify(mock,never()).get(2);
	}
	
	@Test
	public void args_capture() {
		mock.add("some_string");
		//Capture arguments
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("some_string",captor.getValue());
	}
	
	@Test
	public void multiple_args_capture() {
		mock.add("some_string1");
		mock.add("some_string2");
		//Capture arguments
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> values = captor.getAllValues();
		assertEquals("some_string1",values.get(0));
		assertEquals("some_string2",values.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("String1");
		arrayListMock.add("String2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
		arrayListMock.add("String3");
		System.out.println(arrayListMock.size());//5
	}
	
	@Test
	public void spying() {
		ArrayList<String> arrayListspy = spy(ArrayList.class);
		//System.out.println(arrayListMock.get(0));//null pointer exception
		arrayListspy.add("String0");
		System.out.println(arrayListspy.get(0));//String0
		System.out.println(arrayListspy.size());//1
		arrayListspy.add("String1");
		arrayListspy.add("String2");
		System.out.println(arrayListspy.size());//2
		when(arrayListspy.size()).thenReturn(5);
		System.out.println(arrayListspy.size());//5
		arrayListspy.add("String3");
		System.out.println(arrayListspy.size());//5
	}
}
