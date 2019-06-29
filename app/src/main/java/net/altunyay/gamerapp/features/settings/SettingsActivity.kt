package net.altunyay.gamerapp.features.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_settings.*
import net.altunyay.gamerapp.R
import net.altunyay.gamerapp.common.base.BaseActivity
import net.altunyay.gamerapp.common.preferences.ClientPreferences
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsActivity : BaseActivity() {

    private val preferences : ClientPreferences by inject()

    override fun getContentViewId(): Int = R.layout.activity_settings

    override fun onCreateFinished(savedInstanceState: Bundle?) {
        window.setWindowAnimations(R.style.AppWindowAnimation)
        title = "Settings"
        if(preferences.isDarkModeEnabled()) smDarkMode.isChecked = true

        smDarkMode.setOnCheckedChangeListener { _, isChecked ->
            preferences.setDarkModeEnabled(isChecked)
            if(isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            recreate()
        }
    }
}
