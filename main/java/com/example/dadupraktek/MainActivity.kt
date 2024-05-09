package com.example.dadupraktek

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Roll : AppCompatActivity() {

    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dice)

        diceImage1 = findViewById(R.id.imageView1)
        diceImage2 = findViewById(R.id.imageView2)
        rollButton = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        val drawableResource1 = getDiceImageResource(diceRoll1)
        val drawableResource2 = getDiceImageResource(diceRoll2)

        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        val message = if (diceRoll1 == diceRoll2) {
            "Selamat anda dapat dadu double!"
        } else {
            "Anda belum beruntung!"
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun getDiceImageResource(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dadu_1
            2 -> R.drawable.dadu_2
            3 -> R.drawable.dadu_3
            4 -> R.drawable.dadu_4
            5 -> R.drawable.dadu_5
            else -> R.drawable.dadu_6
        }
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
