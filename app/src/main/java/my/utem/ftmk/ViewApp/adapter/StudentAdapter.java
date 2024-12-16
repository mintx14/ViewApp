package my.utem.ftmk.ViewApp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

import my.utem.ftmk.ViewApp.R;
import my.utem.ftmk.ViewApp.model.Student;
import my.utem.ftmk.ViewApp.viewholder.StudentViewHolder;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder>{

    private final LayoutInflater layoutInflater;
    private final Vector<Student> students;

    public StudentAdapter(LayoutInflater layoutInflater, Vector<Student> students) {
        this.layoutInflater = layoutInflater;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(layoutInflater.inflate(R.layout.item_student, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.setStudent(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
