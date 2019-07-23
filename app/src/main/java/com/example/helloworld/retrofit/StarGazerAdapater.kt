package com.example.helloworld.retrofit

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.helloworld.R
import com.example.helloworld.recycler.inflate
import kotlinx.android.synthetic.main.stargazer_item.view.avatar
import kotlinx.android.synthetic.main.stargazer_item.view.username

class StartGazerAdapater(
        val users: List<User>,
        val limit: Int = Int.MAX_VALUE
) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int) = UserViewHolder(parent)

    override fun getItemCount(): Int = users.size.takeIf { it < limit } ?: limit

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }
}

class UserViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(parent.inflate(R.layout.stargazer_item, false)) {

    fun bind(user: User) {
        with(itemView) {
            Glide.with(this)
                    .load(user.avatar_url)
                    .error(R.drawable.ic_info_black_16dp)
                    .into(avatar)
            username.text = user.login
        }
    }
}