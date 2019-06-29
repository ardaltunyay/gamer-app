package net.altunyay.gamerapp.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface ISchedulerProvider {
    fun main() : CoroutineDispatcher
    fun io() : CoroutineDispatcher
    fun default() : CoroutineDispatcher
}