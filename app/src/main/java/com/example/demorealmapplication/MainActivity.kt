package com.example.demorealmapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorealmapplication.adapter.UserAdapter
import com.example.demorealmapplication.model.User
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var realm: Realm
    lateinit var mAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        btnAdd.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        mAdapter = UserAdapter()
        loadData()

        rcUser.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun loadData() {
        val users = realm.where<User>().findAll()
        Log.d("TAG", "loadData: ${users.size}")
        mAdapter.addList(users)
    }
}