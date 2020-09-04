package com.sun.note_01.screen.login.fragment.childlogin

import com.sun.note_01.data.model.Category
import com.sun.note_01.data.model.Note
import com.sun.note_01.data.source.CategoryRepository
import com.sun.note_01.data.source.NoteRepository
import com.sun.note_01.data.source.UserRepository
import com.sun.note_01.data.source.remote.OnFetchDataJsonListener
import com.sun.note_01.untils.Constant.isValidEmail
import com.sun.note_01.untils.Constant.isValidPassword

class LoginPresenter(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val categoryRepository: CategoryRepository,
    private val view: LoginContract.View
) : LoginContract.Presenter {

    override fun setRememberAccount(isRemember: Boolean) {
        userRepository.setRememberAccount(isRemember)
    }

    override fun login(email: String, password: String) {
        if (email.isValidEmail() && password.isValidPassword()) {
            userRepository.login(email, password, object : OnFetchDataJsonListener<Int> {
                override fun onSuccess(data: Int) {
                    userRepository.setUserIdLocal(data)
                    view.onLoginSuccess()
                }

                override fun onError(exception: Exception?) {
                    view.onError(exception)
                }
            })
        } else {
            view.onErrorValidate()
        }
    }

    private fun getNotesDataFromServer() {
        noteRepository.getNote(object : OnFetchDataJsonListener<MutableList<Note>> {
            override fun onSuccess(data: MutableList<Note>) {

            }

            override fun onError(exception: Exception?) {

            }
        })
    }

    private fun getCategoriesDataFromServer() {
        categoryRepository.getCategory(object : OnFetchDataJsonListener<MutableList<Category>> {
            override fun onSuccess(data: MutableList<Category>) {

            }

            override fun onError(exception: Exception?) {

            }
        })
    }
}
