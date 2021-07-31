package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Quiz3 : AppCompatActivity() {
    lateinit var radioGroup: RadioGroup
    lateinit var answerRadioButton: RadioButton
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var textView3 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz3)
        var score = intent.getIntExtra("Score",0)

        radioGroup = findViewById(R.id.radioGroup1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        textView3 = findViewById(R.id.textView3)
        answerRadioButton = findViewById(R.id.radioButton3)

        button2.setOnClickListener{
            var selected = radioGroup.checkedRadioButtonId
            if(selected == -1){
                Toast.makeText(this@Quiz3,"Please Select Any Option First", Toast.LENGTH_LONG).show()
            }else{
                textView3.setText("Answer: \nAlt + F4")
            }
        }
        button3.setOnClickListener{
            var selected = radioGroup.checkedRadioButtonId
            if(selected == answerRadioButton.id) {
                score++
            }
            if(selected != -1) {
                var intent1 = Intent(this@Quiz3,Result::class.java)
                intent1.putExtra("Score",score)
                startActivity(intent1)
            }else{
                Toast.makeText(this@Quiz3,"Please Select Any Option First", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}