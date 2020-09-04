package com.sun.note_01.data.source.local

import android.content.Context
import com.sun.note_01.data.source.CategoryDataSource

class CategoryLocalDataSource : CategoryDataSource.Local {

    companion object {
        private var instance: CategoryLocalDataSource? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: CategoryLocalDataSource().also { instance = it }
        }
    }
}
