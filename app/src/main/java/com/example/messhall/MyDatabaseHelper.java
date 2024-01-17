package com.example.messhall;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private Context mContext;


    public static final String CREATE_BOOK1 = "create table IF NOT EXISTS users(" +
            "User_school NVARCHAR(100) NOT NULL," +
            "User_ID NVARCHAR(100) NOT NULL," +
            "User_phone NVARCHAR(100) NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            "User_pwd NVARCHAR(100) NOT NULL,"+
            "User_pwd2 NVARCHAR(100) NOT NULL);";

          //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public  MyDatabaseHelper(Context context){
        super(context,"db" ,null,1);
        db = getReadableDatabase();
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //调用SQLiteDatabase中的execSQL（）执行建表语句。
        db.execSQL(CREATE_BOOK1);
        //创建成功
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }
    public void add(TextView User_school, TextView User_ID, TextView User_phone, TextView User_pwd, TextView User_pwd2){
        db.execSQL("INSERT INTO users (User_school,User_ID,User_phone,User_pwd,User_pwd2) VALUES(?,?,?,?,?)",new Object[]{User_school,User_ID,User_phone,User_pwd,User_pwd2});
    }
    public void delete(String User_phone){
        db.execSQL("DELETE FROM users WHERE User_phone = ?",new Object[]{User_phone});
    }
    public void updata(String password){
        db.execSQL("UPDATE users SET User_pwd = ? AND User_pwd2 = ?",new Object[]{password,password});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }


    public ArrayList<user> getAllData(){
        ArrayList<user> list = new ArrayList<user>();
        Cursor cursor = db.query("user",null,null,null,null,null,"User_phone DESC");
        while(cursor.moveToNext()){
            String User_phone = cursor.getString(cursor.getColumnIndex("User_phone"));
            String User_pwd = cursor.getString(cursor.getColumnIndex("User_pwd"));
            list.add(new user(User_phone,User_pwd));
        }
        return list;
    }
}


