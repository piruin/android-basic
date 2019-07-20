package com.example.helloworld.msg

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.helloworld.R.layout
import kotlinx.android.synthetic.main.activity_message.message
import kotlinx.android.synthetic.main.activity_message.sendButton

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_message)

        sendButton.setOnClickListener {
            val msg = message.text
            if (msg.isNotBlank()) {
                val intent = Intent(this, ReceiveMessageActivity::class.java)
                intent.putExtra("msg", msg)
                startActivity(intent)
            }
        }
    }
}
