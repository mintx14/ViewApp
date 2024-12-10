package my.utem.ftmk.ViewApp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Calendar;
import java.util.Vector;

import my.utem.ftmk.ViewApp.adapter.StudentAdapter;
import my.utem.ftmk.ViewApp.databinding.ActivityStudentMainBinding;
import my.utem.ftmk.ViewApp.model.Student;

public class StudentMainActivity extends AppCompatActivity {

    ActivityStudentMainBinding binding;
    Student student;

    Vector<Student> students;
    StudentAdapter adapter;

    DatePickerDialog datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStudentMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.fabAdd.setOnClickListener(this:: fnAdd );

        binding.edtBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                int mHour = cldr.get(Calendar.HOUR_OF_DAY);
                int mMinute = cldr.get(Calendar.MINUTE);
                String strDay ="";
                // date picker dialog
                datePicker = new DatePickerDialog(StudentMainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int monthOfYear = 0;
                                binding.edtBirthdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                            
                        }, year, month, day);
                datePicker.show();
            }
        });

        students = new Vector<>();
        adapter = new StudentAdapter(getLayoutInflater(),students);

        binding.rcvStud.setAdapter(adapter);
        binding.rcvStud.setLayoutManager(new LinearLayoutManager(this));


    }

    private void fnAdd(View view)
    {
        String fullname = binding.edtFullName.getText().toString();
        String studNo = binding.edtStudNum.getText().toString();
        String email = binding.edtEmail.getText().toString();
        String birth = binding.edtBirthdate.getText().toString();
        String gender = "";
        String state = binding.spnState.getSelectedItem().toString();

        if(binding.rbMale.isChecked())
            gender = binding.rbMale.getText().toString();
        else if(binding.rbFemale.isChecked())
            gender = binding.rbFemale.getText().toString();

        student = new Student(fullname,studNo,email,gender,birth, state);

        students.add(student);
        adapter.notifyItemInserted(students.size());

    }
    
}