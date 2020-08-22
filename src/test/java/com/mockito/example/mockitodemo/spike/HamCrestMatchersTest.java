package com.mockito.example.mockitodemo.spike;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamCrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,22,35);
		
		assertThat(numbers,hasSize(3));
		assertThat(numbers,hasItems(12,35));
		assertThat(numbers,everyItem(greaterThan(10)));
		assertThat(numbers,everyItem(lessThan(40)));
		
		assertThat("",is(emptyString()));
		assertThat("ABCDE",containsString("BCD"));
		assertThat("ABCDE",startsWith("AB"));
		assertThat("DE",endsWith("DE"));
		
	}
}
