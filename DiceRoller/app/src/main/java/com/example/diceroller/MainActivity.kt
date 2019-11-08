package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { upCount() }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

   private fun upCount() {
       val resultText: TextView = findViewById(R.id.result_text)
       var result = resultText.text.toString()
       if (result == "Hey You!") {
           resultText.text = "1"
           val drawableResource = R.drawable.dice_1
           diceImage.setImageResource(drawableResource)
           return
       }
       if (result == "6") {
           Toast.makeText(this, "can't get larger number using dice",
               Toast.LENGTH_SHORT).show()
           val drawableResource = R.drawable.dice_6
           diceImage.setImageResource(drawableResource)
           return
       }
       else {
           var int = result.toInt()
           int += 1
           val drawableResource = when (int) {
               2 -> R.drawable.dice_2
               3 -> R.drawable.dice_3
               4 -> R.drawable.dice_4
               5 -> R.drawable.dice_5
               else -> R.drawable.dice_6
           }
           diceImage.setImageResource(drawableResource)
           resultText.text = int.toString()
           return
       }

   }
}


