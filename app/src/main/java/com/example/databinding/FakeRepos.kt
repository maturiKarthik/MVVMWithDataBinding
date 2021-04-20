package com.example.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object FakeRepos {
    private val fruitNames: List<String> = listOf(
        "Apple",
        "Banna",
        "Kiwi",
        "Cold Apple",
        "Strawberry",
        "Balckberry",
        "Gassbery",
        "Pink Fruit"
    )

    //you should protect your Mutable Live Data
    private val _currentFruitName: MutableLiveData<String> = MutableLiveData<String>()
    val currentFruitName: LiveData<String>
        get() = _currentFruitName

    init {
        _currentFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        return fruitNames[java.util.Random().nextInt(fruitNames.size)]
    }

    fun changeFruitName() {
        _currentFruitName.value = getRandomFruitName()
    }

}