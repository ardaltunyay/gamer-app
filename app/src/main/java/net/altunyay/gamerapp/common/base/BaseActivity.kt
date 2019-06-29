package net.altunyay.gamerapp.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import net.altunyay.gamerapp.R

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getContentViewId() : Int
    protected abstract fun onCreateFinished(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDarkMode()
        super.onCreate(savedInstanceState)

        setContentView(getContentViewId())
        onCreateFinished(savedInstanceState)
    }

    private fun injectDarkMode() {
        /*Check dark mode*/
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            setTheme(R.style.AppTheme_Dark)
        else
            setTheme(R.style.AppTheme_Light)
    }
}