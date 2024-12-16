package my.utem.ftmk.ViewApp.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.utem.ftmk.ViewApp.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private final TextView lblFullname, lblStudNo, lblGender, lblBirthdate, lblEmail, lblState;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        // Match variable names with their declarations
        this.lblFullname = itemView.findViewById(R.id.lblFullName); // Fixed to lblFullname
        this.lblStudNo = itemView.findViewById(R.id.lblStudNo);
        this.lblGender = itemView.findViewById(R.id.lblGender);
        this.lblBirthdate = itemView.findViewById(R.id.lblBirthdate);
        this.lblEmail = itemView.findViewById(R.id.lblEmail);
        this.lblState = itemView.findViewById(R.id.lblState);
    }

    public TextView getLblFullname() {
        return lblFullname;
    }

    public TextView getLblStudNo() {
        return lblStudNo;
    }

    public TextView getLblGender() {
        return lblGender;
    }

    public TextView getLblBirthdate() {
        return lblBirthdate;
    }

    public TextView getLblEmail() {
        return lblEmail;
    }

    public TextView getLblState() {
        return lblState;
    }
}
