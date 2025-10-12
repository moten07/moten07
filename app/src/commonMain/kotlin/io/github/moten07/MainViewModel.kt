package io.github.moten07


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    val data = MutableStateFlow("Hello World")
    val showContent = MutableStateFlow(false)

    fun update(){
        showContent.value = !showContent.value
    }
}