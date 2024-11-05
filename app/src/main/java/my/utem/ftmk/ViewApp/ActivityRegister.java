package my.utem.ftmk.ViewApp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import my.utem.ftmk.ViewApp.databinding.ActivityRegisterBinding;

public class ActivityRegister extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNext.setOnClickListener(this::fnNext);

//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_register);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    @Override
    protected void onStart() {
        Intent intent = getIntent();
        binding.edtName.setText(intent.getStringExtra("username"));
        binding.edtPassword.setText(intent.getStringExtra("password"));
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void fnCalculate(View view) {
        String yearBirth = binding.edtDOB.getText().toString();
        int yearOfBirth = Integer.parseInt(yearBirth);
        int age = 2024 - yearOfBirth;

        binding.edtDOB.setText("Your are " + age + " years old");
    }


    public void fnNext(View view) {
        Intent intent = new Intent(this, ActivityExpense.class);
        startActivity(intent);
    }
}