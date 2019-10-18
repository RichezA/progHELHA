package examples.fpluquet.be.asyncapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends Activity {

    private static final String PROGRESS = "Progress";
    private static final String PROGRESSING = "Progressing";
    private Button button;
    private ProgressBar progressBar;
    private int progress;
    private MaTache ceThread;

    public static final String TAG = "AsyncApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while(true) {
//                    Log.d(TAG, "Hello !");
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            button.setText("Nouveau string " + new Random().nextInt());
//                        }
//                    });
//
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }
//        }).start();



        progressBar = findViewById(R.id.progressBar);
        progress = 0;

        if (savedInstanceState != null) {
            progress = savedInstanceState.getInt(PROGRESS);
            if (savedInstanceState.getBoolean(PROGRESSING)) {
                launchAsyncTask();
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PROGRESS, progress);
        outState.putBoolean(PROGRESSING, ceThread != null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAsyncTask();
    }

    public void clickOnButton(View view) {
        launchAsyncTask();
    }

    private void launchAsyncTask() {
        if (stopAsyncTask()) return;
        button.setText("Stop progress");
        ceThread = new MaTache();
        ceThread.execute();
    }

    private boolean stopAsyncTask() {
        if (ceThread != null) {
            ceThread.cancel(true);
            button.setText("Start progress");
            ceThread = null;
            return true;
        }
        return false;
    }

    private class MaTache extends AsyncTask<Void, Integer, Integer> {


        @Override
        protected Integer doInBackground(Void... objects) {

            while(!this.isCancelled()) {
                progress = (progress + 1) % 101;
                this.publishProgress(progress);
                Log.d(TAG, progress+"...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(progress);
        }
    }


}

