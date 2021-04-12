package org.techtown.dobetterdomore

import android.app.AlertDialog
import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class LockScreenActivity : AppCompatActivity() {
    private val setLockScreenButton: ImageButton by lazy{
        findViewById<ImageButton>(R.id.setLockScreenButton)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            //setTurnScreenOn(true)
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)
        } else {
            this.window.addFlags(
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }


        setContentView(R.layout.activity_lock_screen)



        initViews()
        bindViews()
    }

    private fun initViews(){
        setLockScreenButton.setOnClickListener {
            val lockScreenDialog = DialogOfLockScreenSettings()
            lockScreenDialog.show(supportFragmentManager, "dialog_of_settings")
        }
    }

    private fun bindViews(){

    }
}