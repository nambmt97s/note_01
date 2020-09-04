package com.sun.note_01.data.source.remote.fetchjson

import com.sun.note_01.data.model.Category
import com.sun.note_01.data.model.CategoryEntry
import com.sun.note_01.data.model.Note
import com.sun.note_01.data.model.NoteEntry
import org.json.JSONObject

class ParseJson {

    fun noteParseJson(jsonObject: JSONObject) = Note(
        idNote = jsonObject.getInt(NoteEntry.ID),
        title = jsonObject.getString(NoteEntry.TITLE),
        body = jsonObject.getString(NoteEntry.BODY),
        dc = jsonObject.getLong(NoteEntry.DAY_CREATE),
        alarm = jsonObject.getLong(NoteEntry.ALARM),
        isFavorite = jsonObject.getBoolean(NoteEntry.IS_FAVORITE),
        isDelete = jsonObject.getBoolean(NoteEntry.IS_DELETE),
        idUser = jsonObject.getInt(NoteEntry.ID_USER),
        idCate = jsonObject.getInt(NoteEntry.ID_CATE),
    )

    fun categoryParseJson(jsonObject: JSONObject) = Category(
        idCate = jsonObject.getInt(CategoryEntry.ID),
        name = jsonObject.getString(CategoryEntry.NAME),
        idUser = jsonObject.getInt(CategoryEntry.ID_USER)
    )

    fun createJson(email: String, password: String) = JSONObject().apply {
        put(EMAIL, email)
        put(PASSWORD, password)
    }

    private companion object {
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}
