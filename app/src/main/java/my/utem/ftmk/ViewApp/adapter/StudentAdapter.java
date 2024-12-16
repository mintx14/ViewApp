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

    public StudentAdapter(LayoutInflater layoutInflater, Vector<Student> students) {
        this.layoutInflater = layoutInflater;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.tvFullName.setText(student.getStrFullname());
        holder.tvStudNo.setText(student.getStrStudNo());
        holder.tvEmail.setText(student.getStrEmail());
        holder.tvGender.setText(student.getStrGender());
        holder.tvState.setText(student.getStrState());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName, tvStudNo, tvEmail, tvGender, tvState;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvStudNo = itemView.findViewById(R.id.tvStudNo);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvState = itemView.findViewById(R.id.tvState);
        }
    }
}
