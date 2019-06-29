package net.altunyay.gamerapp.features.gameList

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_list.*
import net.altunyay.gamerapp.R
import net.altunyay.gamerapp.common.base.BaseActivity
import net.altunyay.gamerapp.features.settings.SettingsActivity

class GameListActivity : BaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_game_list

    override fun onCreateFinished(savedInstanceState: Bundle?) {
        title = "Welcome"
        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
