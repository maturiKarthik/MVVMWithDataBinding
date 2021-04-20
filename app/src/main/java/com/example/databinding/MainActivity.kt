package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * This is the main declaration
         */
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val bindingActivity = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        bindingActivity.lifecycleOwner = this
        bindingActivity.viewModle = mainViewModel

        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(applicationContext,"${it.toString()}",Toast.LENGTH_SHORT).show()
        })


    }
}