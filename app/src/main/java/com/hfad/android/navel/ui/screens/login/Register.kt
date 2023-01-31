package com.hfad.android.navel.ui.screens.login

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hfad.android.navel.models.DbUserModel


const val USER_KEY = "user"
private lateinit var mAuth: FirebaseAuth
private lateinit var mDbRef: DatabaseReference

class Register {
    init {
        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().reference
    }

    fun createUser(name: String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("1989", "user is created")
                    addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                } else {
                    TODO()
                }
            }
    }

    private fun addUserToDatabase(name: String, email: String, uid: String) {

        mDbRef.child(USER_KEY).child(uid).setValue(DbUserModel(name, email, uid))
    }
}

