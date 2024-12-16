package my.utem.ftmk.ViewApp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import my.utem.ftmk.ViewApp.databinding.ActivityGetImgBinding;

public class ActivityGetImg extends AppCompatActivity {

    ActivityGetImgBinding binding;
    Executor executor;
    Handler handler;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityGetImgBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        // Check for internet connectivity
//        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
//
//        if(networkInfo != null  && networkInfo.isConnected()) {
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        // Replace this with your image URL
//                        URL imageUrl = new URL("https://ftmk.utem.edu.my/web/wp-content/uploads/2020/02/cropped-Logo-FTMK.png");
//                        HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
//                        connection.setDoInput(true);
//                        connection.connect();
//                        InputStream inputStream = connection.getInputStream();
//
//                        // Decode the stream into a bitmap
//                        BitmapFactory.Options options = new BitmapFactory.Options();
//                        options.inPreferredConfig = Bitmap.Config.RGB_565;
//                        bitmap = BitmapFactory.decodeStream(inputStream, null, options);
//
//                        inputStream.close(); // Always close the input stream after you're done
//
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    // Once the image is downloaded, update the UI
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            binding.imgVwSelfie.setImageBitmap(bitmap);
//                        }
//                    });
//                }
//            });
//        } else {
//            Toast.makeText(getApplicationContext(), "No Network!! Please add data plan or connect to wifi network!", Toast.LENGTH_SHORT).show();
//        }
    }

    public void getImg(View view) {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null  && networkInfo.isConnected()) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Replace this with your image URL
                        URL imageUrl = new URL("https://ftmk.utem.edu.my/web/wp-content/uploads/2020/02/cropped-Logo-FTMK.png");
                        HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
                        connection.setDoInput(true);
                        connection.connect();
                        InputStream inputStream = connection.getInputStream();

                        // Decode the stream into a bitmap
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        bitmap = BitmapFactory.decodeStream(inputStream, null, options);

                        inputStream.close(); // Always close the input stream after you're done

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.imgVwSelfie.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "No Network!! Please add data plan or connect to wifi network!", Toast.LENGTH_SHORT).show();
        }
    }
}
