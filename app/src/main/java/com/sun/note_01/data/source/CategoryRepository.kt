package com.sun.note_01.data.source

import com.sun.note_01.data.model.Category
import com.sun.note_01.data.source.local.CategoryLocalDataSource
import com.sun.note_01.data.source.remote.CategoryRemoteDataSource
import com.sun.note_01.data.source.remote.OnFetchDataJsonListener

class CategoryRepository private constructor(
    private val remote: CategoryDataSource.Remote,
    private val local: CategoryDataSource.Local
) : CategoryDataSource.Local, CategoryDataSource.Remote {

    override fun getCategory(
        onFetchDataJsonListener: OnFetchDataJsonListener<MutableList<Category>>
    ) {
        remote.getCategory(onFetchDataJsonListener)
    }

    companion object {
        private var instance: CategoryRepository? = null
        fun getInstance(local: CategoryLocalDataSource, remote: CategoryRemoteDataSource) =
            instance ?: synchronized(this) {
                instance ?: CategoryRepository(local = local, remote = remote).also {
                    instance = it
                }
            }
    }
}
