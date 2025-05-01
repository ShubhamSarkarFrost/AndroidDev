package com.onet.kanyefunquotes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val _quoteState = mutableStateOf(QuoteState())
    val quoteState: State<QuoteState> = _quoteState

    init {
        fetchQuote()
    }

    fun fetchQuote() {
        viewModelScope.launch {
            _quoteState.value = _quoteState.value.copy(loading = true, error = null) // Reset state
            try {
                val response = quotesService.getQuote()
                _quoteState.value = _quoteState.value.copy(
                    quote = response.quote,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _quoteState.value = _quoteState.value.copy(
                    loading = false,
                    error = "Error fetching quote: ${e.message}"
                )
            }
        }
    }

    data class QuoteState(
        val loading: Boolean = true,
        val quote: String = "",
        val error: String? = null
    )
}