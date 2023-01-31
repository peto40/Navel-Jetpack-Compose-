package com.hfad.android.navel.models

import android.net.Uri
import android.os.Parcelable
import androidx.compose.material.icons.Icons
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    var userName: String = "",
    var imageUri: Uri? = null,
) : Parcelable


class DbUserModel {
    var name: String? = null
    var email: String? = null
    var uid: String? = null

    constructor() {}

    constructor(name: String?, email: String?, uid: String?) {
        this.name = name
        this.email = email
        this.uid = uid
    }
}