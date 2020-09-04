package com.sun.note_01.data.source

import com.sun.note_01.data.model.Note
import com.sun.note_01.data.source.remote.OnFetchDataJsonListener

interface NoteDataSource {

    interface Remote {
        fun getNote(
            onFetchDataJsonListener: OnFetchDataJsonListener<MutableList<Note>>
        )
    }

    interface Local {
    }
}
