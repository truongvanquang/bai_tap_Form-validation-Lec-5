package com.example.formvalidation

import java.io.Serializable

data class NguoiDung(
    val hoTen: String,
    val email: String,
    val soDienThoai: String,
    val matKhau: String
) : Serializable