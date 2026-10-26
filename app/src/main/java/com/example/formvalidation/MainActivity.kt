package com.example.formvalidation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtHoTen = findViewById<EditText>(R.id.edtHoTen)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtSDT = findViewById<EditText>(R.id.edtSDT)
        val edtMatKhau = findViewById<EditText>(R.id.edtMatKhau)
        val btnDangKy = findViewById<Button>(R.id.btnDangKy)
        val btnHuy = findViewById<Button>(R.id.btnHuy)

        // Nút Hủy: Xóa trắng form
        btnHuy.setOnClickListener {
            edtHoTen.text.clear()
            edtEmail.text.clear()
            edtSDT.text.clear()
            edtMatKhau.text.clear()
            edtHoTen.requestFocus()
        }

        // Nút Đăng Ký: Validation
        btnDangKy.setOnClickListener { view ->
            val hoTen = edtHoTen.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val sdt = edtSDT.text.toString().trim()
            val matKhau = edtMatKhau.text.toString().trim()

            when {
                hoTen.isEmpty() || email.isEmpty() || sdt.isEmpty() || matKhau.isEmpty() -> {
                    Snackbar.make(view, "⚠️ Vui lòng điền đầy đủ tất cả thông tin!", Snackbar.LENGTH_SHORT).show()
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Snackbar.make(view, "❌ Định dạng Email không hợp lệ!", Snackbar.LENGTH_SHORT).show()
                }
                sdt.length < 10 -> {
                    Snackbar.make(view, "📱 Số điện thoại phải có ít nhất 10 số!", Snackbar.LENGTH_SHORT).show()
                }
                else -> {
                    val nguoiDung = NguoiDung(hoTen, email, sdt, matKhau)
                    val intent = Intent(this, TrangChuActivity::class.java).apply {
                        putExtra("NGUOI_DUNG", nguoiDung)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}