package my.utem.ftmk.ViewApp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import my.utem.ftmk.ViewApp.adapter.ExpenseAdapter;
import my.utem.ftmk.ViewApp.databinding.ActivityExpenseBinding;
import my.utem.ftmk.ViewApp.model.Expense;
import my.utem.ftmk.ViewApp.sqlite.DatabaseExpense;

public class ActivityExpense extends AppCompatActivity {

    ActivityExpenseBinding binding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private ExpenseAdapter expenseAdapter;
    private DatabaseExpense databaseExpense;
    private List<Expense> expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        expenses = new ArrayList<>();  // Initialize the expenses list
        databaseExpense = new DatabaseExpense(this);

        drawerLayout = binding.myDrawerLayout;
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open,
                R.string.nav_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = binding.navigation;

        navigationView.setNavigationItemSelectedListener(item -> {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.nav_login_activity:
                    intent = new Intent(getApplicationContext(), ActivityLogin.class);
                    startActivity(intent);
                    return true;

                case R.id.nav_register:
                    intent = new Intent(getApplicationContext(), ActivityRegister.class);
                    startActivity(intent);
                    return true;

                case R.id.nav_expenses:
                    intent = new Intent(getApplicationContext(), ActivityExpense.class);
                    startActivity(intent);
                    return true;

                default:
                    return false;
            }
        });

        Integer[] numbers = new Integer[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = i + 1;
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, numbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnQty.setAdapter(adapter);

        binding.btnSave.setOnClickListener(this::fnSaveExp);
        binding.imgExp.setOnClickListener(this::fnTakePic);

        binding.edtExpDate.setOnClickListener(v -> fnInvokeDatePicker());
    }

    private void fnInvokeDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog pickerDialog = new DatePickerDialog(ActivityExpense.this, (view, year1, monthOfYear, dayOfMonth) ->
                binding.edtExpDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1), year, month, day);
        pickerDialog.show();
    }

    private void fnTakePic(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    @SuppressLint("SetTextI18n")
    private void fnSaveExp(View view) {
        int qtyItem = (int) binding.spnQty.getSelectedItem();
        float total = qtyItem * Float.parseFloat(binding.edtExpValue.getText().toString());
        binding.txtVwTotalPrice.setText("RM " + Float.toString(total));

        Expense expense = new Expense();
        expense.setExpName(binding.edtExpType.getText().toString());
        String expDate = binding.edtExpDate.getText().toString();
        if (TextUtils.isEmpty(expDate)) {
            // Prompt user to select a date
            Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show();
            return;  // Prevent further action
        }

        expense.setExpDate(expDate);
        expense.setExpValue(Float.parseFloat(binding.edtExpValue.getText().toString()));
        expense.setExpQty(qtyItem);

        try {
            int resCode = databaseExpense.fnInsertExpense(expense);
            if (resCode > 0) {
                Toast.makeText(this, "Information saved locally", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Information not saved locally", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && data.getExtras() != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            if (bitmap != null) {
                binding.imgExp.setImageBitmap(bitmap);
            }
        }
    }
}
