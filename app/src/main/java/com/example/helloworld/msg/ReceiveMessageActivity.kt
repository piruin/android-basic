package com.example.helloworld.msg

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.helloworld.R.layout
import kotlinx.android.synthetic.main.activity_receive_message.messageText

class ReceiveMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_receive_message)

        val msg = intent.getCharSequenceExtra("msg")
        messageText.text = msg
    }
}
