package com.pkm.byebyestress.ui.stresstes.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class QuizViewModel : ViewModel() {

    private val _quizQuestions = MutableLiveData<List<String>>()
    val quizQuestions: LiveData<List<String>> = _quizQuestions

    fun getQuizQuestions() {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("material/quiz questions")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val questions = mutableListOf<String>()
                for (questionSnapshot in snapshot.children) {
                    val question = questionSnapshot.getValue(String::class.java)
                    question?.let {
                        questions.add(it)
                    }
                }
                _quizQuestions.value = questions
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle kegagalan akses ke database
            }
        })
    }
}