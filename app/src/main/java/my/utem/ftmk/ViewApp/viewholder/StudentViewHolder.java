package my.utem.ftmk.ViewApp.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.utem.ftmk.ViewApp.R;

public class StudentViewHolder extends RecyclerView.ViewHolder{

    private final TextView lblFullname, lblStudNo,lblGender, lblBirthdate, lblEmail, lblState;

    public StudentViewHolder(View itemView, TextView lblFullname, TextView lblStudNo, TextView lblGender, TextView lblBirthdate, TextView lblEmail, TextView lblState) {
        super(itemView);

        this.lblFullname = itemView.findViewById(R.id.edtFullName);
        this.lblStudNo = itemView.findViewById(R.id.edtStudNum);
        this.lblGender = itemView.findViewById(R.id.lblGender);
        this.lblBirthdate = itemView.findViewById(R.id.edtBirthdate);
        this.lblEmail = itemView.findViewById(R.id.edtEmail);
        this.lblState = itemView.findViewById(R.id.spnState);
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
