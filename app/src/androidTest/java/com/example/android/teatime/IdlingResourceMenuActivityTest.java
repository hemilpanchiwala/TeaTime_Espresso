package com.example.android.teatime;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.base.IdlingResourceRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class IdlingResourceMenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> activityTestRule = new
            ActivityTestRule<>(MenuActivity.class);

    private IdlingResource idlingResource;

    @Before
    public void registerIdlingResurce() {
        idlingResource = activityTestRule.getActivity().getIdlingResource();

        Espresso.registerIdlingResources(idlingResource);
    }

    @Test
    public void idlingResourceTest() {
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(0).perform(click());
    }

    @After
    public void unregisterIdlingResource() {
        if (idlingResource != null){
            Espresso.unregisterIdlingResources(idlingResource);
        }
    }

}
