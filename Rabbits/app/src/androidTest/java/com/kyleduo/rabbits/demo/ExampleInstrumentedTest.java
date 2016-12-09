package com.kyleduo.rabbits.demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {
	@Test
	public void useAppContext() throws Exception {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry.getTargetContext();

		assertEquals("com.kyleduo.rabbits.demo", appContext.getPackageName());
	}

	@Rule
	public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule<>(MainActivity.class, true);

	@Test
	public void testGoTest() throws Exception {
		onView(withId(R.id.start_test_bt)).perform(click());
		onView(withId(R.id.back_home_bt)).check(matches(isDisplayed()));

		onView(withId(R.id.back_home_bt)).perform(click());
		onView(withId(R.id.start_test_bt)).check(matches(isDisplayed()));
	}
}