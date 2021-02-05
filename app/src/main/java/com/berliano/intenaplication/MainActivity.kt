package com.berliano.intenaplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveActivityWithData: Button = findViewById(R.id.btn_move_with_data)
        val btnMoveActivityWithObject: Button = findViewById(R.id.btn_move_with_object)
        val btnDialNumber: Button = findViewById(R.id.dial_number)
        val btnForResult: Button = findViewById(R.id.btn_move_with_result)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnForResult.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_move_activity -> {
                val intentMoveActivity = Intent(this, MoveActivity::class.java)
                startActivity(intentMoveActivity)
            }

            R.id.btn_move_with_data -> {
                val intentMoveWithData = Intent(this,MoveWithDataActivity::class.java)
                intentMoveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dicoding Academy")
                intentMoveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 6)
                startActivity(intentMoveWithData)
            }

            R.id.btn_move_with_object -> {
                val person = Person(
                    "Dicoding Academy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                val moveIntentWithObject = Intent(this, MoveWithObjectActivity::class.java)
                moveIntentWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveIntentWithObject)
            }

            R.id.dial_number -> {
                val phoneNumber = "0895381769841"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel : $phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}