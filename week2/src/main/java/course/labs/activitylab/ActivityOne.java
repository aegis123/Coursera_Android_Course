package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {
    // String for LogCat documentation
    private final static String TAG = "Lab-ActivityOne";

    public static final String KEY_START = "start";

    public static final String KEY_CREATE = "create";

    public static final String KEY_RESUME = "resume";

    public static final String KEY_RESTART = "restart";

    private TextView mTvCreate, mTvStart, mTvResume, mTvRestart;

    private int mCreate = 0, mStart = 0, mResume = 0, mRestart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        mTvCreate = (TextView) findViewById(R.id.create);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvRestart = (TextView) findViewById(R.id.restart);

        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        // Check for previously saved state
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(KEY_CREATE)) {
                mCreate = savedInstanceState.getInt(KEY_CREATE);
            }
            if (savedInstanceState.containsKey(KEY_START)) {
                mStart = savedInstanceState.getInt(KEY_START);
            }
            if (savedInstanceState.containsKey(KEY_RESUME)) {
                mResume = savedInstanceState.getInt(KEY_RESUME);
            }
            if (savedInstanceState.containsKey(KEY_RESTART)) {
                mRestart = savedInstanceState.getInt(KEY_RESTART);
            }
        }

        Log.i(TAG, "onCreate");
        mCreate++;
        displayCounts();
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");

        mStart++;
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
        mResume++;
        displayCounts();

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart");

        displayCounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(KEY_CREATE, mCreate);
        savedInstanceState.putInt(KEY_START, mStart);
        savedInstanceState.putInt(KEY_RESUME, mResume);
        savedInstanceState.putInt(KEY_RESTART, mRestart);
    }

    // Updates the displayed counters
    public void displayCounts() {
        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);
    }
}
