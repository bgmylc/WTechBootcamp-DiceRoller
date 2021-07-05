package com.begumyolcu.zaruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSalla : Button = findViewById(R.id.buttonSalla)

        buttonSalla.setOnClickListener {
            zariSalla()
        }

    }

    private fun zariSalla() {
        val zar = Zar(6)
        val gelenDeger = zar.salla()

        val textZar : TextView = findViewById(R.id.textViewZar)
        textZar.text = gelenDeger.toString()

        val zarResim : ImageView = findViewById(R.id.imageViewZar)
        val drawableResource = when(gelenDeger) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        zarResim.setImageResource(drawableResource)

        zarResim.contentDescription = gelenDeger.toString()

    }


    class Zar(private val yuzSayisi : Int) {

        fun salla() : Int {
            return (1..yuzSayisi).random()
        }

    }
}

