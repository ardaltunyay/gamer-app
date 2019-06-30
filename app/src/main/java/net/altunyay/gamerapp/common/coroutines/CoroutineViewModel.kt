package net.altunyay.gamerapp.common.coroutines

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class CoroutineViewModel(private val schedulerProvider: ISchedulerProvider) : ViewModel() {

    private var jobs = listOf<Job>()


    fun launch(code: suspend CoroutineScope.() -> Unit) {
        jobs += GlobalScope.launch(schedulerProvider.main(), block = code)
    }

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { it.cancel() }
    }
}