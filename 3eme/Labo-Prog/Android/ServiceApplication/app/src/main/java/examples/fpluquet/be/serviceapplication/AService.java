package examples.fpluquet.be.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AService extends Service {

    public static final String STRING_TO_SHOW = "StringToShow";
    String message = "Default message";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (flags == 0) {
            Log.d(MainActivity.TAG, "New service");
        } else {
            Log.d(MainActivity.TAG, "No New service");
            if((flags & START_FLAG_REDELIVERY) != 0) {
                Log.d(MainActivity.TAG, "Redelivery Intent");
            }
            if((flags & START_FLAG_RETRY) != 0) {
                Log.d(MainActivity.TAG, "Abnormal ending, restart service");
            }
        }
        if (intent != null) {
            message = intent.getStringExtra(STRING_TO_SHOW);
        }
        new ProgressAsyncTask().execute();

//        return START_NOT_STICKY; // Does not relaunch the service if it's stopped
//        return START_STICKY; // Relauch service without intent
        return START_REDELIVER_INTENT; // Relaunch service if stopped by memory need (with intent)
    }

    private class ProgressAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while(true) {
                try {
                    publishProgress();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Toast.makeText(AService.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
