package com.sun.note_01.data.source

import com.sun.note_01.data.model.Note
import com.sun.note_01.data.source.local.NoteLocalDataSource
import com.sun.note_01.data.source.remote.NoteRemoteDataSource
import com.sun.note_01.data.source.remote.OnFetchDataJsonListener

class NoteRepository private constructor(
    private val remote: NoteDataSource.Remote,
    private val local: NoteDataSource.Local
) : NoteDataSource.Local, NoteDataSource.Remote {

    override fun getNote(
        onFetchDataJsonListener: OnFetchDataJsonListener<MutableList<Note>>
    ) {
        remote.getNote(onFetchDataJsonListener)
    }

    companion object {
        private var instance: NoteRepository? = null
        fun getInstance(local: NoteLocalDataSource, remote: NoteRemoteDataSource) =
            instance ?: synchronized(this) {
                instance ?: NoteRepository(local = local, remote = remote).also {
                    instance = it
                }
            }
    }
}
