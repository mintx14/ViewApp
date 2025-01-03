package my.utem.ftmk.ViewApp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import my.utem.ftmk.ViewApp.R;
import my.utem.ftmk.ViewApp.model.Expense;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private List<Expense> expenseList;

    public ExpenseAdapter(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom layout for individual items
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_expense, parent, false);
        return new ExpenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        // Bind data to the views
        Expense currentExpense = expenseList.get(position);

        // Set the values to the views
        holder.expName.setText(currentExpense.getExpName());
        holder.expDate.setText(currentExpense.getExpDate());
        holder.expValue.setText(String.format("RM %.2f", currentExpense.getExpValue()));

        // Set up Spinner for quantity
        ArrayAdapter<Integer> qtyAdapter = new ArrayAdapter<>(holder.itemView.getContext(),
                android.R.layout.simple_spinner_item, getQuantityOptions());
        qtyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.expQty.setAdapter(qtyAdapter);

        // Set the current quantity value based on the Expense data
        holder.expQty.setSelection(currentExpense.getExpQty() - 1); // assuming qty starts from 1
    }

    @Override
    public int getItemCount() {
        return expenseList != null ? expenseList.size() : 0;
    }

    // ViewHolder class for expense items
    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {

        TextView expName;
        TextView expDate;
        TextView expValue;
        Spinner expQty;

        public ExpenseViewHolder(View itemView) {
            super(itemView);

            expName = itemView.findViewById(R.id.edtExpType);
            expDate = itemView.findViewById(R.id.edtExpDate);
            expValue = itemView.findViewById(R.id.edtExpValue);
            expQty = itemView.findViewById(R.id.spnQty);  // Spinner for quantity
        }
    }

    // Helper function to generate quantity options (1-15 for example)
    private Integer[] getQuantityOptions() {
        Integer[] options = new Integer[15];
        for (int i = 0; i < 15; i++) {
            options[i] = i + 1;
        }
        return options;
    }
}