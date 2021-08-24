package edu.nmhu.sd_bssd4250_12

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val constraintLayout = ConstraintLayout(this)
        constraintLayout.id = View.generateViewId() //each view to constrain needs an id
        constraintLayout.setBackgroundColor(Color.WHITE) //change bg color

        val textView = TextView(this)
        textView.text = "Select Color" //Set the text view text
        textView.setBackgroundColor(Color.WHITE) //make textView stand out on constraintLayout
        textView.id = View.generateViewId() //each view to constrain needs an id

        constraintLayout.addView(textView) //add the text view to the layout
        setContentView(constraintLayout) //add the layout to the activity

        val blueButton = Button(this)
        blueButton.text = "Blue"
        blueButton.id = View.generateViewId()
        blueButton.setBackgroundColor(Color.BLUE)
        blueButton.setOnClickListener(View.OnClickListener {
            constraintLayout.setBackgroundColor(Color.BLUE)
        })

        constraintLayout.addView(blueButton)

        val redButton = Button(this)
        redButton.text = "Red"
        redButton.id = View.generateViewId()
        redButton.setBackgroundColor(Color.RED)
        redButton.setOnClickListener(View.OnClickListener {
            constraintLayout.setBackgroundColor(Color.RED)
        })

        constraintLayout.addView(redButton)

        val greenButton = Button(this)
        greenButton.text = "Green"
        greenButton.id = View.generateViewId()
        greenButton.setBackgroundColor(Color.GREEN)
        greenButton.setOnClickListener(View.OnClickListener {
            constraintLayout.setBackgroundColor(Color.GREEN)
        })

        constraintLayout.addView(greenButton)


        //important to constrain everything after hierarchy has been created
        val constraintSet = ConstraintSet() //Apply multiple constraints at once with a set
        val pid = ConstraintSet.PARENT_ID //the parent id. This will save typing below
        constraintSet.constrainHeight(textView.id, ConstraintSet.WRAP_CONTENT) //Wrap only text
        constraintSet.constrainWidth(textView.id, ConstraintSet.WRAP_CONTENT) //Wrap only text

        constraintSet.constrainHeight(blueButton.id, ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainWidth(blueButton.id, ConstraintSet.WRAP_CONTENT)

        constraintSet.constrainHeight(redButton.id, ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainWidth(redButton.id, ConstraintSet.WRAP_CONTENT)

        constraintSet.constrainHeight(greenButton.id, ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainWidth(greenButton.id, ConstraintSet.WRAP_CONTENT)


        //Match bottom, top, left, right. equal tension between all places textView in center

        constraintSet.connect(textView.id, ConstraintSet.BOTTOM, pid, ConstraintSet.BOTTOM)
        constraintSet.connect(textView.id, ConstraintSet.TOP, pid, ConstraintSet.TOP)
        constraintSet.connect(textView.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
        constraintSet.connect(textView.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)

        constraintSet.connect(blueButton.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
        constraintSet.connect(blueButton.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)
        constraintSet.connect(blueButton.id, ConstraintSet.TOP, textView.id, ConstraintSet.BOTTOM)

        constraintSet.connect(redButton.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
        constraintSet.connect(redButton.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)
        constraintSet.connect(redButton.id, ConstraintSet.TOP, blueButton.id, ConstraintSet.BOTTOM)

        constraintSet.connect(greenButton.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
        constraintSet.connect(greenButton.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)
        constraintSet.connect(greenButton.id, ConstraintSet.TOP, redButton.id, ConstraintSet.BOTTOM)

        constraintSet.applyTo(constraintLayout) //apply this to the Layout container

    }
}