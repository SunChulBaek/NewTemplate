package kr.pe.ssun.myapplication.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.pe.ssun.myapplication.navigation.DetailArgs
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val args = DetailArgs(savedStateHandle)

    init {
        println("[x1210x] detail for id = ${args.id}")
    }
}