package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val rollButton : Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice=Dice(6)
        val RolledDice=dice.roll()
        // Find the ImageView in the layout
        val resultTextView : TextView = findViewById(R.id.textView)
        val resultImageView : ImageView = findViewById(R.id.imageview)
        // Determine which drawable resource ID to use based on the dice roll
        val RolledImage=when(RolledDice){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        resultImageView.setImageResource(RolledImage)
        // Update the content description

        resultImageView.contentDescription = RolledDice.toString()
        resultTextView.text=RolledDice.toString()
    }
}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
