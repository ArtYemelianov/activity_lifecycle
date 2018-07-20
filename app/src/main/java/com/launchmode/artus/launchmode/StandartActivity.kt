package com.launchmode.artus.launchmode

import android.os.Bundle

class StandartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = intent.getStringExtra("name")
    }

}
