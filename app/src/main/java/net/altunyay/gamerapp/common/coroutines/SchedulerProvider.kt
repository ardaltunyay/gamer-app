package net.altunyay.gamerapp.common.coroutines

import kotlinx.coroutines.Dispatchers

class SchedulerProvider : ISchedulerProvider {
    override fun main() = Dispatchers.Main
    override fun io() = Dispatchers.IO
    override fun default() = Dispatchers.Default
}