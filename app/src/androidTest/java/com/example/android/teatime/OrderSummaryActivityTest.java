package com.example.android.teatime;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class OrderSummaryActivityTest {

    @Rule
    public IntentsTestRule<OrderSummaryActivity> intentsTestRule = new
            IntentsTestRule<>(OrderSummaryActivity.class);

    @Before
    public void stubAllExternalIntents() {

        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));

    }

    @Test
    public void clickSendEmailButton_SendsEmail() {

        onView(withId(R.id.send_email_button)).perform(click());

        intended(allOf(
              hasAction(Intent.ACTION_SENDTO),
                hasData(Uri.parse("mailto:"))
        ));

    }

}

