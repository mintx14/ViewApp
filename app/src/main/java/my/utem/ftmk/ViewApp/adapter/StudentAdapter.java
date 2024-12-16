package my.utem.ftmk.ViewApp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

import my.utem.ftmk.ViewApp.R;
import my.utem.ftmk.ViewApp.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Vector<Student> students;

    // Constructor for the adapter
    public StudentAdapter(LayoutInflater layoutInflater, Vector<Student> students) {
        this.layoutInflater = layoutInflater;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = layoutInflater.inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // Get the student object for the current position
        Student student = students.get(position);

        // Bind data to the views
        holder.lblFullName.setText(student.getStrFullname());
        holder.lblStudNo.setText(student.getStrStudNo());
        holder.lblEmail.setText(student.getStrEmail());
        holder.lblGender.setText(student.getStrGender());
        holder.lblState.setText(student.getStrState());
    }

    @Override
    public int getItemCount() {
        // Return the total number of items
        return students.size();
    }

    // ViewHolder class for Student
    static class StudentViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblFullName, lblStudNo, lblEmail, lblGender, lblState;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the TextView fields
            lblFullName = itemView.findViewById(R.id.lblFullName);
            lblStudNo = itemView.findViewById(R.id.lblStudNo);
            lblEmail = itemView.findViewById(R.id.lblEmail);
            lblGender = itemView.findViewById(R.id.lblGender);
            lblState = itemView.findViewById(R.id.lblState);
        }
    }
}
