package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage= 0
    lateinit var image : ImageView
    var places  = arrayOf("India Gate","Kutub Mianr","Akshar Dham Temple","Red Fort","Lotus Temple")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar ?.hide()

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrevios)
        val placeName = findViewById<TextView>(R.id.textview)

        next.setOnClickListener {
//      Go to next image
            var idCurrentImageString = "pic$currentImage"
            // Get all images by id
            var idCurrentImage = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImage)
            image.alpha= 0f

            currentImage = (5+currentImage+1)%5
            var idImageToShowString ="pic"+currentImage
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f
//      Go to next text
            placeName.text = places[currentImage]





        }
        prev.setOnClickListener {
            var idCurrentImageString = "pic$currentImage"
//       Go to previous image
            // Get all images by id
            var idCurrentImage = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImage)
            image.alpha= 0f

            currentImage = (5+currentImage-1)%5
            var idImageToShowString ="pic"+currentImage
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f

            //      Go to prev text
            placeName.text = places[currentImage]

        }
    }


}