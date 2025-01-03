package my.utem.ftmk.ViewApp.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import my.utem.ftmk.ViewApp.model.Expense;

public class DatabaseExpense extends SQLiteOpenHelper {
    public static final String dbname = "dbexpense";
    public static final int dbVersion = 1;
    public static final String tblExpense = "tblExpense";
    public static final String colId = "id";
    public static final String colExpName = "exp_name";
    public static final String colExpDate = "exp_date";
    public static final String colExpValue = "exp_value";
    public static final String colExpQty = "exp_qty";
    public static final String colExpDesc = "exp_desc";
    public static final String colExpImg = "exp_img";
    public static final String colExpType = "exp_type";
    public static final String colExpTotal = "exp_total";

    public static final String createTable = "CREATE TABLE " + tblExpense + "(" + colId +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + colExpName + "TEXT," +
            colExpDesc + " TEXT," + colExpImg + " TEXT," + colExpType + " TEXT," + colExpQty +
            " TEXT," + colExpTotal + " TEXT," + colExpDate + "TEXT," +
            colExpValue + " TEXT)";

    public static final String dropTable = "DROP TABLE IF EXISTS " + tblExpense;

    public DatabaseExpense(Context context){
        super(context, dbname, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropTable);
    }

    public  int fnInsertExpense(Expense expense){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(colExpName, expense.getExpName());
        values.put(colExpDate, expense.getExpDate());
        values.put(colExpValue, expense.getExpValue());
        values.put(colExpQty, expense.getExpQty());
        long value = db.insert(tblExpense, null, values);
        return (int) value;
    }

    @SuppressLint("Range")
    public List<Expense> fnGetAllExpense() {
        List<Expense> expenses = new ArrayList<>(); // Create a list to hold the expenses
        String strSelect = "SELECT * FROM " + tblExpense;
        Cursor cursor = getReadableDatabase().rawQuery(strSelect, null);
        if (cursor.moveToFirst()) {
            do {
                // Retrieve the data from the cursor
                String expName = cursor.getString(cursor.getColumnIndex(colExpName));
                String expDate = cursor.getString(cursor.getColumnIndex(colExpDate));
                float expValue = cursor.getFloat(cursor.getColumnIndex(colExpValue));
                int expQty = cursor.getInt(cursor.getColumnIndex(colExpQty));

                // Create an Expense object with the retrieved data
                Expense expense = new Expense(expName, expDate, expValue, expQty);

                // Add the Expense object to the expenses list
                expenses.add(expense); // Corrected this line
            } while (cursor.moveToNext());
        }
        cursor.close(); // Always close the cursor after use
        return expenses; // Return the list of expenses
    }


}
