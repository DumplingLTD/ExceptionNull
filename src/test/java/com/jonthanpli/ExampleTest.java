package com.jonthanpli;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// This example has a JUnit4 runner because it doesn't require spring or spring plugins to operate.
@RunWith(JUnit4.class)
public class ExampleTest {
	private static final String TEST_STRING_1 = "This is a test string";

	/**
	 * Represents an API you really don't want to spin up during a unit test.
	 */
	public interface ExampleInterface1 {
		/**
		 * Returns true on success.
		 * @return
		 */
		public boolean someSuperHeavyApiCall();
	}

	/**
	 * Represents an interface you don't really care about, but just provides something.
	 */
	public interface ExampleInterface2 {
		public String provide();
	}

	/**
	 * Represents a class that needs to be unit tested, but uses some super heavy API.
	 */
	public static class ExampleTestClass {
		private final ExampleInterface1 i1;
		private final ExampleInterface2 i2;

		public ExampleTestClass(ExampleInterface1 i1, ExampleInterface2 i2) {
			this.i1 = i1;
			this.i2 = i2;
		}

		/**
		 * The function call to the super heavy api call, but doesn't return anything.
		 */
		public void doSomethingComplex() {
			// does some logic thing

			// calls the API and does something with the result
			boolean result = i1.someSuperHeavyApiCall();
		}

		/**
		 * Function call to something, and return something.
		 * @return
		 */
		public String doSomethingComplexAndReturnAString() {
			return i2.provide();
		}
	}

	private ExampleInterface1 i1;
	private ExampleInterface2 i2;

	// @Before is run before every single @Test, thus, any class variable is reset between tests.
	@Before
	public void setUp() {
		// We use a Spy when we care how many times the interface's methods were used.
		i1 = spy(ExampleInterface1.class);
		when(i1.someSuperHeavyApiCall()).thenReturn(true);

		// We use a Mock when we don't really care that the interface was called.
		i2 = mock(ExampleInterface2.class);
		when(i2.provide()).thenReturn(TEST_STRING_1);

		// Why use mock over spy or vis versa?
		// http://stackoverflow.com/questions/15052984/what-is-the-difference-between-mocking-and-spying-when-using-mockito
	}

	/**
	 * Because we're testing ExampleTestClass#doSomethingComplex(), we name the test function that.
	 * If there are multiple logical tests for this single function, we do the following:
	 *
	 * doSomethingComplex_DescriptiveTestName1
	 * doSomethingComplex_DescriptiveTestName2
	 */
	@Test
	public void doSomethingComplex() {
		ExampleTestClass test = getTestClassInstance();

		// Call the method to test
		test.doSomethingComplex();

		// Because the method we're testign doesn't return anything, we test the underlying business
		// logic, that is, that it called the api once.
		verify(i1, times(1)).someSuperHeavyApiCall();

		// You cannot do this with a @Mock
	}

	@Test
	public void doSomethingComplexAndReturnAString() {
		ExampleTestClass test = getTestClassInstance();

		// In this case, the function returns something, so we only care to test the output.
		assertThat(test.doSomethingComplexAndReturnAString()).matches(TEST_STRING_1);

		// There, of course, is a lot of mixing and matching between spying and mocking. Generally,
		// these are the test case scenarios in which you'd use each.
	}

	/**
	 * A lot of the time, the class you're testing requires setup. this is where you do that. Also
	 * could have been placed in the @Setup block. Sometimes you need more than 1 instance so you'd
	 * make a function like this. It's up to you.
	 * @return
	 */
	private ExampleTestClass getTestClassInstance() {
		return new ExampleTestClass(i1, i2);
	}
}
