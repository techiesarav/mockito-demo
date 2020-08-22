package com.mockito.example.mockitodemo.spike;

import static org.assertj.core.api.Assertions.assertThat;
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

//less static import than hamcrest
//chaining assertions
public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,22,35);
		assertThat(numbers).hasSize(3)
							.contains(12,22)
							.allMatch(x -> x >10)
							.noneMatch(x -> x < 0);
		assertThat("").isEmpty();
		assertThat("ABCDEF").startsWith("AB").endsWith("EF");
	}
}
