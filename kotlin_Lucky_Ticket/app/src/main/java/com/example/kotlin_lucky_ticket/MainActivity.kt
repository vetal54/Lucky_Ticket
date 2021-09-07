package com.example.kotlin_lucky_ticket

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var ticketNumber: EditText? = null
    private var image_lamp: ImageView? = null
    private var drawable_color: Drawable? = null

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ticketNumber = findViewById(R.id.edit_Number)
        image_lamp = findViewById(R.id.lamp_image)
        drawable_color = getDrawable(R.drawable.circle)
    }

    fun checkTicket(view: View) {
        val ticket: CharArray = ticketNumber?.text.toString().toCharArray()
        var leftSum = 0
        var rightSum = 0

        if(ticket.size != 6){
            drawable_color?.setTint(Color.GRAY)
            image_lamp?.background = drawable_color
            Toast.makeText(applicationContext, resources.getString(R.string.incorrectLength), Toast.LENGTH_SHORT).show()
            return
        } else {
            for (i in 0..2) {
                leftSum += ticket[i].toString().toInt()
                rightSum += ticket[i + 3].toString().toInt()
            }
            if(leftSum == rightSum)  {
                drawable_color?.setTint(Color.GREEN)
                image_lamp?.background = drawable_color
                Toast.makeText(applicationContext, resources.getString(R.string.lucky), Toast.LENGTH_SHORT).show()
            } else {
                drawable_color?.setTint(Color.RED)
                image_lamp?.background = drawable_color
                Toast.makeText(applicationContext, resources.getString(R.string.unlucky), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
