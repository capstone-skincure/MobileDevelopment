package com.example.skincure.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.skincure.R

fun showConfirmationDialog(
    context: Context,
    message: String,
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null)
    val dialog = AlertDialog.Builder(context).create()

    dialog.setView(dialogView)

    val title = dialogView.findViewById<TextView>(R.id.title)
    val messageView = dialogView.findViewById<TextView>(R.id.message)
    val cancelButton = dialogView.findViewById<Button>(R.id.btn_cancel)
    val logoutButton = dialogView.findViewById<Button>(R.id.btn_logout)

    title.text = buildString {
        append("CONFIRM LOGOUT")
    }
    messageView.text = message

    cancelButton.setOnClickListener {
        onCancel()
        dialog.dismiss()
    }

    logoutButton.setOnClickListener {
        onConfirm()
        dialog.dismiss()
    }

    dialog.setCancelable(false)
    dialog.show()
}