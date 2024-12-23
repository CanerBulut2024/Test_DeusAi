package com.deusai.test_deusai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val btnChangePassword = findViewById<Button>(R.id.btnChangePassword)
        val btnPremiumPlan = findViewById<Button>(R.id.btnPremiumPlan)
        val btnAboutUs = findViewById<Button>(R.id.btnAboutUs)
        val btnSettings = findViewById<Button>(R.id.btnSettings)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val btnSwitchAccount = findViewById<Button>(R.id.btnSwitchAccount)

        btnChangePassword.setOnClickListener {
            // Şifre değiştirme ekranına yönlendirin
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }

        btnPremiumPlan.setOnClickListener {
            // Premium plan ekranına yönlendirin
            startActivity(Intent(this, PremiumPlanActivity::class.java))
        }

        btnAboutUs.setOnClickListener {
            // Hakkımızda ekranına yönlendirin
            startActivity(Intent(this, AboutUsActivity::class.java))
        }

        btnSettings.setOnClickListener {
            // Ayarlar ekranına yönlendirin
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        btnLogout.setOnClickListener {
            showLogoutDialog()
        }

        btnSwitchAccount.setOnClickListener {
            // Hesap değiştirme işlemleri
            startActivity(Intent(this, SwitchAccountActivity::class.java))
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setMessage(R.string.are_you_sure_logout)
            .setPositiveButton(R.string.yes) { _, _ ->
                // Çıkış işlemleri yapılacak
                finish()  // Uygulamayı kapatabilirsiniz
            }
            .setNegativeButton(R.string.no) { dialog, _ ->
                dialog.dismiss()  // Çıkışı iptal et
            }
            .show()
    }
}