package com.sun.note_01.data.model

data class Note(
    val idNote: Int,
    val title: String,
    val body: String,
    val dc: Long,
    val alarm: Long,
    val isFavorite: Boolean,
    val isDelete: Boolean,
    val idUser: Int,
    val idCate: Int
)

object NoteEntry {
    const val KEY_ENTITY = "NOTE"
    const val ID = "idNote"
    const val TITLE = "title"
    const val BODY = "body"
    const val DAY_CREATE = "dc"
    const val ALARM = "alarm"
    const val IS_FAVORITE = "isFavorite"
    const val IS_DELETE = "isDelete"
    const val ID_USER = "idUser"
    const val ID_CATE = "idCate"
}
