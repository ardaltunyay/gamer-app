package net.altunyay.gamerapp.features.splash

import android.content.Intent
import android.os.Bundle
import kotlinx.coroutines.*
import net.altunyay.gamerapp.R
import net.altunyay.gamerapp.common.base.BaseActivity
import net.altunyay.gamerapp.features.games.GamesActivity

class SplashActivity : BaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_splash

    override fun onCreateFinished(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        GlobalScope.launch(Dispatchers.Main){
            delay(1500)
            startActivity(Intent(this@SplashActivity, GamesActivity::class.java))
        }
    }
}
