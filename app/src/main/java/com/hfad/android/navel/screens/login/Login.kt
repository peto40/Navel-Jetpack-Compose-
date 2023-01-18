package com.hfad.android.navel.screens.login

import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.hfad.android.navel.MainActivity

private lateinit var mAuth: FirebaseAuth

class Login(private val context: Context) {
    init {
        mAuth = FirebaseAuth.getInstance()
    }

    fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            } else {
                Log.d("1988", "Login isn't success")
            }
        }
    }
}
