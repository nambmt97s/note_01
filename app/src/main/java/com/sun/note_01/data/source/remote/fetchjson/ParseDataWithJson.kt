package com.sun.note_01.data.source.remote.fetchjson

import com.sun.note_01.data.model.CategoryEntry
import com.sun.note_01.data.model.NoteEntry
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ParseDataWithJson {

    fun parseJsonToData(jsonArray: JSONArray?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        for (i in 0 until (jsonArray?.length() ?: 0)) {
            val jsonObjects = jsonArray?.getJSONObject(i)
            val item = ParseDataWithJson().parseJsonToObject(jsonObjects, keyEntity)
            item?.let { data.add(it) }
        }
        return data
    }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String): Any? {
        try {
            jsonObject?.let {
                when (keyEntity) {
                    NoteEntry.KEY_ENTITY -> return ParseJson().noteParseJson(it)
                    CategoryEntry.KEY_ENTITY -> return ParseJson().categoryParseJson(it)
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
}
