package net.altunyay.gamerapp.features.games

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_games.*
import net.altunyay.gamerapp.R
import net.altunyay.gamerapp.common.base.BaseActivity
import net.altunyay.gamerapp.common.extensions.toast
import net.altunyay.gamerapp.features.settings.SettingsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesActivity : BaseActivity() {

    private val viewModel : GamesViewModel by viewModel()

    override fun getContentViewId(): Int = R.layout.activity_games

    override fun onCreateFinished(savedInstanceState: Bundle?) {
        title = "Welcome"
        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        viewModel.games.observe(this, Observer {state ->
            toast("${state.size}")
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getGames()
    }
}
