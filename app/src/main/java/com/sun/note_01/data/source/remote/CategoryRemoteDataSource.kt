package com.sun.note_01.data.source.remote

import com.sun.note_01.data.model.Category
import com.sun.note_01.data.model.CategoryEntry
import com.sun.note_01.data.source.CategoryDataSource
import com.sun.note_01.data.source.local.prefs.AppPreferencesHelper
import com.sun.note_01.data.source.remote.fetchjson.DataTypeResponse
import com.sun.note_01.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.note_01.untils.Constant

class CategoryRemoteDataSource(private val pref: AppPreferencesHelper) : CategoryDataSource.Remote {
    private val baseUrl = Constant.BASE_URL + Constant.GET_CATEGORY_PATH + pref.getUserIdLocal()

    override fun getCategory(
        onFetchDataJsonListener: OnFetchDataJsonListener<MutableList<Category>>
    ) {
        GetJsonFromUrl(
            listener = onFetchDataJsonListener,
            keyEntity = CategoryEntry.KEY_ENTITY,
        ).execute(
            baseUrl, Constant.METHOD_GET, DataTypeResponse.Default.name
        )
    }

    companion object {
        private var instance: CategoryRemoteDataSource? = null
        fun getInstance(pref: AppPreferencesHelper) = instance ?: synchronized(this) {
            instance ?: CategoryRemoteDataSource(pref).also { instance = it }
        }
    }
}
