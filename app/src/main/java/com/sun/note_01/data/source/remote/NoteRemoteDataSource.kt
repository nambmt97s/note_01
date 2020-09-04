package com.sun.note_01.data.source.remote

import com.sun.note_01.data.model.Note
import com.sun.note_01.data.model.NoteEntry
import com.sun.note_01.data.source.NoteDataSource
import com.sun.note_01.data.source.local.prefs.AppPreferencesHelper
import com.sun.note_01.data.source.remote.fetchjson.DataTypeResponse
import com.sun.note_01.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.note_01.untils.Constant

class NoteRemoteDataSource private constructor(
    private val pref: AppPreferencesHelper
) : NoteDataSource.Remote {
    private val baseUrl = Constant.BASE_URL + Constant.GET_NOTE_PATH + pref.getUserIdLocal()

    override fun getNote(
        onFetchDataJsonListener: OnFetchDataJsonListener<MutableList<Note>>
    ) {
        GetJsonFromUrl(
            listener = onFetchDataJsonListener,
            keyEntity = NoteEntry.KEY_ENTITY,
        ).execute(
            baseUrl, Constant.METHOD_GET, DataTypeResponse.Default.name
        )
    }

    companion object {
        private var instance: NoteRemoteDataSource? = null

        fun getInstance(preferencesHelper: AppPreferencesHelper) = instance ?: synchronized(this) {
            instance ?: NoteRemoteDataSource(preferencesHelper).also { instance = it }
        }
    }
}
