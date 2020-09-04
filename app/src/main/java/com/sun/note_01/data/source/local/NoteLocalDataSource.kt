package com.sun.note_01.data.source.local

import com.sun.note_01.data.source.NoteDataSource

class NoteLocalDataSource private constructor() : NoteDataSource.Local {

    companion object {
        private var instance: NoteLocalDataSource? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: NoteLocalDataSource().also { instance = it }
        }
    }
}
