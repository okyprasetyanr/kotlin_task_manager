package com.example.task_manager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task_manager.features.main_menu.presentation.ui.MainMenu
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var email:TextInputEditText
    private lateinit var password:TextInputEditText
    private lateinit var loginButton:MaterialButton
    private val txemail="demo@gmail.com"
    private var txpassword="123456"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        loginButton=findViewById(R.id.loginButton)

        setInit()
    }

    private fun setInit() {
        loginButton.setOnClickListener {
            if(email.text.toString()==txemail && password.text.toString()==txpassword){
                val toMainMenu = Intent(this, MainMenu::class.java)
                startActivity(toMainMenu)
            }else{
                Toast.makeText(this,"E-mail atau Password salah!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}