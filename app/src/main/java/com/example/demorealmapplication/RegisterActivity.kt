package com.example.demorealmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demorealmapplication.model.User
import io.realm.Realm
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val realm = Realm.getDefaultInstance()

        btnSubmit.setOnClickListener {
            realm.beginTransaction()
            if (edtName.text.isNotEmpty() && edtPhoneNumber.text.isNotEmpty()){
                val user = realm.createObject<User>()
                user.name = edtName.text.toString()
                user.phone = edtPhoneNumber.text.toString()
            }
            realm.commitTransaction()
            finish()
        }
    }
}