package com.example.demorealmapplication.model

import io.realm.RealmObject

open class User(var name: String? = null, var phone: String? = null) : RealmObject()