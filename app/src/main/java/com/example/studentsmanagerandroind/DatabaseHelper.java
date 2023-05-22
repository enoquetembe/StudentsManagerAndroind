package com.example.studentsmanagerandroind;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AlunosDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ALUNOS = "alunos";

    public static  final String TABLE_NAME = "alunos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "name";
    private static final String COLUMN_IDADE = "age";
    private static final String COLUMN_SEXO = "gender";
    private static final String COLUMN_MORADA = "adress";
    private static final String COLUMN_TELEFONE = "telefone";

    private static final String CREATE_TABLE_ALUNOS =
            "CREATE TABLE " + TABLE_ALUNOS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NOME + " TEXT," +
                    COLUMN_IDADE + " INTEGER," +
                    COLUMN_SEXO + " TEXT," +
                    COLUMN_MORADA + " TEXT," +
                    COLUMN_TELEFONE + " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALUNOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUNOS);
        onCreate(db);
    }

    public void save(String name, int age, String gender, String address, String telefone) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, name);
        values.put(COLUMN_IDADE, age);
        values.put(COLUMN_SEXO, gender);
        values.put(COLUMN_MORADA, address);
        values.put(COLUMN_TELEFONE, telefone);

        db.insert(TABLE_ALUNOS, null, values);
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NOME)));
                student.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_IDADE)));
                student.setGender(cursor.getString(cursor.getColumnIndex(COLUMN_SEXO)));
                student.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_MORADA)));
                student.setTel(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_TELEFONE))));
                students.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }

    public void delete(String name) {
        SQLiteDatabase db = getWritableDatabase();

        String whereClause = "name = ?";
        String[] whereArgs = { name };
        db.delete(TABLE_ALUNOS, whereClause, whereArgs);
    }


    public void update(String name, int age, String gender, String address, int telefone) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_IDADE, age);
        values.put(COLUMN_SEXO, gender);
        values.put(COLUMN_MORADA, address);
        values.put(COLUMN_TELEFONE, telefone);

        String whereClause = "name = ?";
        String[] whereArgs = { name };

        db.update(TABLE_ALUNOS, values, whereClause, whereArgs);
    }
}

