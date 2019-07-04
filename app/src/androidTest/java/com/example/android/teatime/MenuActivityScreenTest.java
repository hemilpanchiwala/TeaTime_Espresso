package com.example.android.teatime;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    @Rule public ActivityTestRule<MenuActivity> activityTestRule = new
            ActivityTestRule<>(MenuActivity.class);

    @Test
    public void clickGridViewItem_OpensOrderActivity() {

        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(0).perform(click());

        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Black Tea")));

    }

}
