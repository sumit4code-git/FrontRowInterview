package com.example.frontrowinterview.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

fun EditText.onTextChangeFlow(): StateFlow<String> {

    val flow = MutableStateFlow(String.EMPTY)

    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(newText: CharSequence?, start: Int, before: Int, count: Int) {
            flow.value = newText.toString()
        }

        override fun afterTextChanged(s: Editable?) {
        }

    })

    return flow.asStateFlow()
}
val String.Companion.EMPTY: String by lazy { "" }