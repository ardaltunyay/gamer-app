package net.altunyay.gamerapp.features

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.coroutineScope
import net.altunyay.gamerapp.R
import net.altunyay.gamerapp.common.base.BaseActivity
import net.altunyay.gamerapp.features.settings.SettingsActivity

class MainActivity : BaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_main

    override fun onCreateFinished(savedInstanceState: Bundle?) {
        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
