package com.example.taskmaster1;


import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.contrib.RecyclerViewActions;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void titleOnHomePage() {
        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }

    @Test
    public void settingButtonOnHomePage() {
        onView(withId(R.id.settings)).check(matches(isDisplayed()));
    }

    @Test
    public void ButtonAddTask() {
        onView(withId(R.id.button_first)).perform(click());
        onView(withId(R.id.taskDescription)).check(matches(isDisplayed()));
    }

    @Test
    public void testEditTheUserName(){
        onView(withId(R.id.settings)).perform(click());
        onView(withId(R.id.username_text)).perform(clearText(), typeText("deyaa"));
        onView(withId(R.id.save)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.username)).check(matches(withText("deyaa")));
    }
}