package net.altunyay.gamerapp.common.preferences

import android.content.Context

class ClientPreferences(context: Context) : PreferencesManager(context) {

    companion object {
        private const val IS_DARK_MODE_ENABLED = "IS_DARK_MODE_ENABLED"
    }

    fun isDarkModeEnabled() : Boolean {
        return getBooleanValue(IS_DARK_MODE_ENABLED, false)
    }

    fun setDarkModeEnabled(isEnabled : Boolean) {
        putBoolean(IS_DARK_MODE_ENABLED, isEnabled)
    }
}