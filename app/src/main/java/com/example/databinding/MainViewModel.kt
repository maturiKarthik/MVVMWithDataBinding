package com.example.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(),Observable {

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    val currentRandomFruitName: LiveData<String>
    get() = FakeRepos.currentFruitName

    fun onChangeRandomFruitClick() = FakeRepos.changeFruitName()

    /**
     * Now ,here comes the property to
     * hold databinding
     */


    @Bindable
    val editTextContent = MutableLiveData<String>()

    /**
     * Never expose your MutableLiveData
     * Display only LiveData
     */
    private val _displayEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
    get() = _displayEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        editTextContent.value = FakeRepos.getRandomFruitName()
    }
}