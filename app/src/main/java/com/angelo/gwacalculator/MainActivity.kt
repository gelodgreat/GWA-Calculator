package com.angelo.gwacalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    internal var xunits: Double = 0.toDouble()
    internal var xgrades: Double = 0.toDouble()
    internal var numxunits: Double = 0.toDouble()
    internal var numxgrades: Double = 0.toDouble()
    internal var numtotalave: Double = 0.toDouble()
    internal var multixgrade: Double = 0.toDouble()
    internal var df = DecimalFormat("#.00")
    internal var xresultgrades = ""
    internal var xresultunits = ""
    internal var clickcounter = 0
    internal var clickrecorder: Int = 0
    private var btn_next: Button? = null
    private var btn_clear: Button? = null
    private var et_units: EditText? = null
    private var et_grade: EditText? = null
    private var et_total_subj: EditText? = null
    private var tv_totalunits: TextView? = null
    private var tv_totalgrade: TextView? = null
    private var tv_totalaverage: TextView? = null
    private var tv_totalclicks: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        onclickbuttons()

    }

    private fun onclickbuttons() {
        btn_next!!.setOnClickListener {
            calcuunits()
            tv_totalclicks!!.text = "Total Inputed Grade: " + clickcounter
            total()
        }


        btn_clear!!.setOnClickListener { clearfunctionchangetotalsubj() }

        et_total_subj!!.setOnKeyListener { v, keyCode, event ->

            if (et_total_subj!!.text.toString() == "") {
                clearfunctionchangetotalsubj()
            } else if (et_total_subj!!.text.toString() != "") {
                btn_next!!.setEnabled(true);
                et_grade!!.setEnabled(true);
                et_units!!.setEnabled(true);
            }

            false
        }

    }


    private fun clearfunctionchangetotalsubj() {
        numxunits = 0.0
        numxgrades = 0.0
        numtotalave = 0.0
        clickcounter = 0
        et_grade!!.setText("")
        et_units!!.setText("")
        et_total_subj!!.setText("")
        tv_totalunits!!.text = "Total Units: " + numxunits
        tv_totalgrade!!.text = "Total Grade: " + numxgrades
        tv_totalaverage!!.text = "GWA: " + numtotalave
        tv_totalclicks!!.text = "Total Inputed Grade: " + clickcounter
        et_total_subj!!.requestFocus()
        disablewhendone()
    }

    private fun init() {
        numxunits = 0.0
        numxgrades = 0.0
        numtotalave = 0.0
        clickcounter = 0

        btn_next = findViewById(R.id.btn_next) as Button
        btn_clear = findViewById(R.id.btn_clear) as Button

        et_units = findViewById(R.id.et_units) as EditText
        et_grade = findViewById(R.id.et_grade) as EditText
        et_total_subj = findViewById(R.id.et_totalsubj) as EditText

        tv_totalunits = findViewById(R.id.tv_totalunits) as TextView
        tv_totalgrade = findViewById(R.id.tv_totalgrade) as TextView
        tv_totalaverage = findViewById(R.id.tv_averagegrade) as TextView
        tv_totalclicks = findViewById(R.id.tv_totalclicks) as TextView

        tv_totalunits!!.text = "Total Units: " + numxunits
        tv_totalgrade!!.text = "Total Grade: " + numxgrades
        tv_totalaverage!!.text = "GWA: " + numtotalave
        tv_totalclicks!!.text = "Total Inputed Grade: " + clickcounter
//        disablewhendone()
    }


    private fun calcuunits() {
        try {

            if (et_units!!.text.toString() == "" || et_grade!!.text.toString() == "" || et_total_subj!!.text.toString() == "") {
                Toast.makeText(this, "Fill all fields!", Toast.LENGTH_SHORT).show()
            } else {

                //Calculating Units
                xunits = java.lang.Double.parseDouble(et_units!!.text.toString()) + numxunits
                numxunits = xunits
                xresultunits = df.format(numxunits)

                //Calculating GWA
                multixgrade = java.lang.Double.parseDouble(et_grade!!.text.toString()) * java.lang.Double.parseDouble(et_units!!.text.toString())
                xgrades = multixgrade + numxgrades
                numxgrades = xgrades
                xresultgrades = df.format(xgrades)


                tv_totalunits!!.text = "Total Units: " + xresultunits
                tv_totalgrade!!.text = "Total Grade: " + xresultgrades


                et_grade!!.setText("")
                et_units!!.setText("")
                et_units!!.requestFocus()
                clickcounter = clickcounter + 1
            }


        } catch (ex: Exception) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun disablewhendone() {
        btn_next!!.setEnabled(false);
        et_grade!!.setEnabled(false);
        et_units!!.setEnabled(false);
    }

    private fun total() {
        try {
            clickrecorder = Integer.parseInt(et_total_subj!!.text.toString())
            if (clickcounter == clickrecorder) {
                val ion = java.lang.Double.parseDouble(xresultgrades) / java.lang.Double.parseDouble(xresultunits)
                xresultgrades = df.format(ion)
                tv_totalaverage!!.text = "GWA: " + xresultgrades
                disablewhendone()
            }
        } catch (ex: Exception) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show()
        }


    }
}
