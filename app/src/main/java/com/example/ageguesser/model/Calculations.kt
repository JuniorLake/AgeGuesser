package com.example.ageguesser.model

import kotlin.random.Random

class Calculations {
    private fun eachAgeJokes(age: Int, name: String?): String{
        var string = ""
        when(age){
            in 1..5 -> string = "you're $age....why are you using this app $name?"
            in 6..10 -> string = "$name, $age year olds should be playing with toys. Go on."
            in 11..15 -> string = "$age year olds play Fortnite right??? go do that."
            in 16..20 -> string = "you should have your drivers license, come on $name you're $age."
            in 21..25 -> string = "$name do you have a job yet....no?? well that's embarrassing Lol you're $age"
            in 26..30 -> string = "lol yeah you're old now, $age is not that old but still old. Should i get you your cane?"
            in 31..35 -> string = "yeah you should not be single, maybe dating but not single, you don't have much time at $age $name."
            in 36..40 -> string = "$age??? ok now your old old...i said you OLD OLD!!! can you hear me?? do you need your hearing aid??"
            in 41..45 -> string = "are you getting back pains $name, you should go to a chiropractor at $age you should start from now."
            in 46..50 -> string = "did your kids help you use this app? oh sorry you're $age, so did your grand kids help you?"
            in 51..55 -> string = "are you ok...guess not cause your $age. teeth falling out yet?"
            in 56..60 -> string = "hello senior citizen how did you find this app at $age?"
        }
        return string
    }

    fun getData(enteredName: String? = null): String {
        val age = Random.nextInt(1, 61)
        return eachAgeJokes(age, enteredName)
    }
}