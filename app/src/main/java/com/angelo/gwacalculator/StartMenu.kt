package com.angelo.gwacalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class StartMenu : AppCompatActivity() {

    private var btn_gocalculate: Button? = null
    private var btn_exit: Button? = null
    var mAdView: AdView? = null
    var mAdView2: AdView? = null
    val adRequest = AdRequest.Builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_menu)

        mAdView = findViewById(R.id.adView) as AdView
        mAdView2 = findViewById(R.id.adView2) as AdView
//        mAdView!!.loadAd(adRequest)
//        mAdView2!!.loadAd(adRequest)

        btn_gocalculate = findViewById(R.id.btn_gocalculate) as Button
        btn_gocalculate!!.setOnClickListener {
            val intent = Intent("com.angelo.gwacalculator.MainActivity")
            startActivity(intent)
        }
        btn_exit = findViewById(R.id.btn_exit) as Button
        btn_exit!!.setOnClickListener {
            exit()
        }
    }

    override fun onBackPressed() {
        exit()

    }

    private fun exit() {
        val alertDialog = AlertDialog.Builder(this)
        // Setting Dialog Title
        alertDialog.setTitle("Exit alert");
        alertDialog.setMessage("Do You want Exit??");
        alertDialog.setNegativeButton("NO") { dialog, _ -> dialog.cancel() }
        alertDialog.setPositiveButton("YES") { _, _ -> finish() }
        alertDialog.show()
    }
}
