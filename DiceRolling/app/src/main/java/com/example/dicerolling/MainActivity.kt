package com.example.dicerolling

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

        val rollbutton: Button = findViewById(R.id.button)
//following code is used to create a effect over a button.
        rollbutton.setOnClickListener {
//following code here helps to create a texted alert , that would be occured when a certain event is performed.
            val x = Toast.makeText(this,"Dice rolled!!",Toast.LENGTH_LONG).show()
            rollDice()
        }
        rollDice()
    }

//this function here is used to link following class "dice" to "MainActivity" class through function.
    private fun rollDice() {
        val dice = dice(6)
        val diceRoll = dice.roll()
        val sdiceRoll = dice.roll()
//following variable is created to link and enhance the behaviour of imageview.
        val DiceImage: ImageView = findViewById(R.id.imageView)
        val sDiceImage:ImageView = findViewById(R.id.imageView2)


//Following code is used to link particular image to imageView.
        val x = when(diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val y = when(sdiceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

         DiceImage.setImageResource(x)
         DiceImage.contentDescription = diceRoll.toString()
         sDiceImage.setImageResource(y)
         sDiceImage.contentDescription = diceRoll.toString()
    }
}

//this class is used to add randomness to the app.
class dice(private val nsides: Int)
{
    fun roll():Int
    {
        return(1..nsides).random()
    }
}