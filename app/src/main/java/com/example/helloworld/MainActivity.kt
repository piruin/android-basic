package com.example.helloworld

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_login.login
import kotlinx.android.synthetic.main.content_login.password
import kotlinx.android.synthetic.main.content_login.username

class MainActivity : AppCompatActivity() {

    private val userPassMap = mapOf(
            "admin" to "@dm1n555",
            "user1" to "helloworld@tu",
            "android" to "12341234"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        login.setOnClickListener {
            val inputUser = username.text.toString()
            val inputPass = password.text.toString()

            val pass = userPassMap[inputUser]
            if (pass == inputPass) {
                Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                username.text = null
                password.text = null
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
