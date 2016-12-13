package com.udacity.gradle.builditbigger;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by uyan on 12/12/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class GetJokeTaskInstrumentationTest {
    CountDownLatch signal = null;
    String joke;

    @Before
    public void initializeLatch(){
        signal = new CountDownLatch(1);
    }

    @Test
    public void testGetTask(){
        try{
            new GetJokeTask(new GetJokeTask.OnJokeReceivedListener() {
                @Override
                public void onJokeReceived(String result) {
                    joke  =result;
                    signal.countDown();
                }
            }).execute();

            signal.await(10, TimeUnit.SECONDS);
            Assert.assertNotNull(joke);
        }catch (Exception e){
        }
    }
}
