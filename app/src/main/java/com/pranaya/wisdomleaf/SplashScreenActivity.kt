package com.pranaya.wisdomleaf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pranaya.wisdomleaf.Utils.Utils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class
SplashScreenActivity : AppCompatActivity() {

    companion object {
        const val DURATION : Long = 5000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //using coroutine context and delay suspend function to set a delay of 5seconds
        MainScope().launch {
            delay(DURATION)
            if (Utils.isOnline(this@SplashScreenActivity))
             startNextActivity()
            else
                Utils.showDialog("Please connect to Internet",this@SplashScreenActivity)
        }
    }



    // start list activity on this method invoked
    fun startNextActivity() {
        startActivity(Intent(this@SplashScreenActivity,ListDashboardActivity::class.java))
    }


}