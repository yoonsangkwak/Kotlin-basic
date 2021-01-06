package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table memo (num integer primary key, content text, datetime integer)"
        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 테이블에 변경사항이 있을 경우 호출됨
        // SqliteHelper()의 생성자를 호출할 때 기존 데이터베이스와 version을 비교해서 높으면 호출된다.
    }

    // 데이터 입력함수
    fun insertMemo(memo:Memo) {

        // db 가져오기
        val wd = writableDatabase
        // Memo를 입력타입으로 변환
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        // db에 넣기
        wd.insert("memo", null, values)
        // db 닫기
        wd.close()
    }

    // 데이터 조회함수
    fun selectMemo() : MutableList<Memo> {

        val list = mutableListOf<Memo>()

        val select = "select * from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)

        while (cursor.moveToNext()) {
            val num = cursor.getLong(cursor.getColumnIndex("num"))
            val content = cursor.getString(cursor.getColumnIndex("content"))
            val datetime = cursor.getLong(cursor.getColumnIndex("datetime"))

            val memo = Memo(num, content, datetime)
            list.add(memo)
        }
        cursor.close()
        rd.close()

        return list
    }

    // 데이터 수정함수
    fun updateMemo(memo:Memo) {

        val wd = writableDatabase

        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        wd.update("memo", values, "num = ${memo.num}", null)
        wd.close()
    }

    // 데이터 삭제함수
    fun deleteMemo(memo:Memo) {

        val wd = writableDatabase
//        val delete = "delete from memo where num = ${memo.num}"
//        wd.execSQL(delete)

        wd.delete("memo", "num = ${memo.num}", null)
        wd.close()
    }
}

data class Memo(var num:Long?, var content:String, var datetime:Long)