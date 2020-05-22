package com.example.examproject

class Joke {
    private var question: String? = null
    private var answer: String? = null
    private var id = 0

    fun Note(){
        //constructor needed
    }
    fun Note(Question: String?, Answer: String?, Id: Int) {
        this.answer = Answer
        this.question = Question
        this.id = Id
    }

    fun getQuestion()
    : String? {
        return question
    }

    fun getAnswer() : String? {
        return answer
    }

    fun getId() : Int? {
        return id
    }
}