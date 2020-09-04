package com.sun.note_01.data.model

data class Category(val idCate: Int, val name: String, val idUser: Int)

object CategoryEntry {
    const val KEY_ENTITY = "CATEGORY"
    const val ID = "idCate"
    const val NAME = "name"
    const val ID_USER = "idUser"
}
