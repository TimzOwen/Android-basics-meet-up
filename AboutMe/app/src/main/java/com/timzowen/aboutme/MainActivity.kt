package com.timzowen.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.timzowen.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var myName : MyName = MyName("Timz Owen ") // Instantiate and set the name here from data class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnDone.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view : View){
        binding.apply {
            myName?.nickname = etNickName.text.toString()
            invalidateAll()
            binding.etNickName.visibility = View.GONE
            // hide button visibility
            view.visibility = View.GONE
            // un-hide text to display the given name
            binding.tvNickName.visibility = View.VISIBLE
        }

        // hide the keyboard input type
       val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}