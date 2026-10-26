package com.example.formvalidation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TrangChuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trang_chu)

        val tvThongTin = findViewById<TextView>(R.id.tvThongTin)
        val nguoiDung = intent.getSerializableExtra("NGUOI_DUNG") as? NguoiDung

        if (nguoiDung != null) {
            tvThongTin.text = """
                👤 Họ và tên: ${nguoiDung.hoTen}
                📧 Email: ${nguoiDung.email}
                📞 Số điện thoại: ${nguoiDung.soDienThoai}
            """.trimIndent()
        }
    }
}