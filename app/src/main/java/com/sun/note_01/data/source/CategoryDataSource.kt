package com.sun.note_01.data.source

import com.sun.note_01.data.model.Category
import com.sun.note_01.data.source.remote.OnFetchDataJsonListener

interface CategoryDataSource {

    interface Remote {
        fun getCategory(
            onFetchDataJsonListener: OnFetchDataJsonListener<MutableList<Category>>
        )
    }

    interface Local {
    }
}
