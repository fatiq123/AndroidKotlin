package com.example.quizapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.model.Question
import com.example.quizapp.viewmodel.QuizViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var questionsList: List<Question>

    companion object {
        var result = 0
        var totalQuestions = 0
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]


        // since we will reset the quiz many times so
        result = 0
        totalQuestions = 0


        // displaying the first question
        GlobalScope.launch(Dispatchers.Main) {
            quizViewModel.getQuestionsFromLiveData().observe(this@MainActivity,
                androidx.lifecycle.Observer {

                    if (it.isNotEmpty()) {
                        questionsList = it
                        Log.v("Tag", "This is 1st question: ${questionsList[0]}")
                    }

                    binding.apply {
                        tvQuestion.text = questionsList[0].question
                        radio1.text = questionsList[0].option1
                        radio2.text = questionsList[0].option2
                        radio3.text = questionsList[0].option3
                        radio4.text = questionsList[0].option4

                    }

                })
        }


        var i = 1
        binding.apply {
            btnNext.setOnClickListener {
                val selectedOption = radioGroup.checkedRadioButtonId

                if (selectedOption != -1) {
                    val radioButton = findViewById<View>(selectedOption) as RadioButton

                    questionsList.let {
                        if (i < it.size) {

                            // getting number of questions
                            totalQuestions = it.size
                            // checking if it is correct or not
                            if (radioButton.text.toString() == it[i - 1].correct_option) {
                                result++
                                tvResult.text = "Correct Answer: $result"
                            }

                            // displaying the next question
                            tvQuestion.text = "Question ${i + 1}: " + questionsList[i].question
                            radio1.text = it[i].option1
                            radio2.text = it[i].option2
                            radio3.text = it[i].option3
                            radio4.text = it[i].option4

                            // checking if it is the last question
                            if (i == it.size.minus(1)) {
                                btnNext.text = "Finish"
                            }

                            radioGroup.clearCheck()
                            i++
                        } else {
                            if (radioButton.text.toString() == it[i - 1].correct_option) {
                                result++
                                tvResult.text = "Correct Answer: $result"
                            } else {

                            }

                            val intent = Intent(this@MainActivity, ResultActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Please Select One Option",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}