package com.example.helloworld.mail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.helloworld.R
import kotlinx.android.synthetic.main.activity_send_mail.mailMessage
import kotlinx.android.synthetic.main.activity_send_mail.mailSubject
import kotlinx.android.synthetic.main.activity_send_mail.mailTo
import kotlinx.android.synthetic.main.activity_send_mail.sendButton
import org.jetbrains.anko.email
import org.jetbrains.anko.sdk27.coroutines.onClick

class SendMailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_mail)

        sendButton.onClick {
            val email = mailTo.text.toString()
            val subject = mailSubject.text.toString()
            val msg = mailMessage.text.toString()

            email(email, subject, msg)
        }
    }
}
