package com.example.novelscholar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DB="BooksDatabase";
    private static final String BOOK_TABLE="books";
    private static final String ID="id";
    private static final String TITLE="title";
    private static final String AUTHOR="author";
    private static final String REVIEW="review";
    private static final String STARTED="started";
    private static final String FINISHED="finished";

    public DBHelper(@Nullable Context context) {
        super(context, DB, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE "+ BOOK_TABLE +"("+ID+" integer primary key autoincrement,"+ TITLE+" TEXT,"+AUTHOR+" TEXT,"+REVIEW+" TEXT,"+STARTED+" LONG,"
                +FINISHED+" LONG)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query ="DROP TABLE "+ BOOK_TABLE;db.execSQL(query);onCreate(db);
    }
    public void addBook(Book book){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TITLE,book.getTitle());
        cv.put(AUTHOR,book.getAuthor());
        cv.put(REVIEW,book.getReview());
        cv.put(STARTED,book.getStarted());
        cv.put(FINISHED,book.getFinished());
        db.insert(BOOK_TABLE,null,cv);
        db.close();
    }
    public Book getBook(int id){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query(
                BOOK_TABLE,new String[] {ID,TITLE,AUTHOR,REVIEW,STARTED,FINISHED},ID+ "=?",new String[] {String.valueOf(id)},
                null,null,null,null
        );
        Book book;if (cursor!=null){
            cursor.moveToFirst();
            book=new Book(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getLong(4),cursor.getLong(5));
            return book;
        } else
            return null;
    }
    public List<Book> getAllBooks(){
        SQLiteDatabase db=getReadableDatabase();
        List<Book> books=new ArrayList<>();
        String query="SELECT * FROM "+BOOK_TABLE ;
        Cursor cursor=db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{Book book=new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setReview(cursor.getString(3));
                book.setStarted(cursor.getLong(4));
                book.setFinished(cursor.getLong(5));books.add(book);
            }while (cursor.moveToNext());
        }
        return books;
    }
    public int updateBook(Book book){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TITLE,book.getTitle());
        cv.put(AUTHOR,book.getAuthor());
        cv.put(REVIEW,book.getReview());
        cv.put(STARTED,book.getStarted());
        cv.put(FINISHED,book.getFinished());
        int success=db.update(BOOK_TABLE,cv,ID+"=?",new String[] {String.valueOf(book.getId())});
        return success;
    }
    public void deleteBooks(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(BOOK_TABLE,ID+"=?",new String[] {String.valueOf(id)});
        db.close();
    }
    public int countBooks(){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+BOOK_TABLE;
        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
    }
}
