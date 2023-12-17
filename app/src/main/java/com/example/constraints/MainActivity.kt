package com.example.constraints

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.example.constraints.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000
    private lateinit var binding: ActivityMainBinding
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Set animations to ImageView and Logo using ViewBinding
        binding.imageView.startAnimation(topAnim)
        binding.text1.startAnimation(bottomAnim)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}
