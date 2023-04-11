package com.example.quizapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class QuizQuestions : AppCompatActivity() {

    private lateinit var options:ArrayList<TextView>
    private lateinit var questions:ArrayList<Question>
    private  var currentQues:Int=1
    private  var  selectedOption:Int=0
    private lateinit var opt1:TextView
    private lateinit var opt2:TextView
    private lateinit var opt3:TextView
    private lateinit var opt4:TextView
    private  lateinit var progressBar:ProgressBar
    private  lateinit var progressCount:TextView
    private  lateinit var questionText:TextView
    private  lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        progressBar=findViewById(R.id.progressBar)
        progressCount=findViewById(R.id.progressCount)
        questionText=findViewById(R.id.question)
        image=findViewById(R.id.image)
        opt1=findViewById(R.id.opt1)
        opt2=findViewById(R.id.opt2)
        opt3=findViewById(R.id.opt3)
        opt4=findViewById(R.id.opt4)

        val sumbit:Button=findViewById(R.id.submit)

        questions=Constants.getQuestions()
        currentQues=1
        var question:Question? =questions[currentQues-1]

        progressBar.progress=currentQues

        progressCount.text="${currentQues}/10"

       questionText.text=question!!.question
        image.setImageResource(question.image)
        opt1.text=question.optionOne
        opt2.text=question.optionTwo
        opt3.text=question.optionThree
        opt4.text=question.optionFour

        options=ArrayList<TextView>()
        options.add(opt1)
        options.add(opt2)
        options.add(opt3)
        options.add(opt4)

        options.forEach {
            option->option.setOnClickListener { selectedOptionView(option) }
        }

        sumbit.setOnClickListener{
            setQuestions()
        }

    }
    private fun setQuestions(){
        currentQues++;
        defaultOptionsView()

        if(currentQues==10){


        }else {

            var question: Question? = questions[currentQues - 1]

            progressBar.progress = currentQues

            progressCount.text = "${currentQues}/10"

            questionText.text = question!!.question
            image.setImageResource(question.image)
            opt1.text = question.optionOne
            opt2.text = question.optionTwo
            opt3.text = question.optionThree
            opt4.text = question.optionFour
        }

    }
    private fun defaultOptionsView(){

        options.forEach {
            option->
            option.setBackgroundColor(Color.parseColor("#FFFFFF"))


        }
    }
    private  fun selectedOptionView(option:TextView){
        defaultOptionsView()
        option.setBackgroundColor(R.drawable.selected_option_border_bg)
    }
}