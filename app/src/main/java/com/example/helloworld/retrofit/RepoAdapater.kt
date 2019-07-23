package com.example.helloworld.retrofit

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.helloworld.R
import com.example.helloworld.recycler.inflate
import kotlinx.android.synthetic.main.repo_item.view.descript
import kotlinx.android.synthetic.main.repo_item.view.fullname
import kotlinx.android.synthetic.main.repo_item.view.issue
import kotlinx.android.synthetic.main.repo_item.view.lang
import kotlinx.android.synthetic.main.repo_item.view.license
import kotlinx.android.synthetic.main.repo_item.view.name
import kotlinx.android.synthetic.main.repo_item.view.star

class RepoAdapater(
        val repos: List<Repo>,
        val limit: Int = Int.MAX_VALUE
) : RecyclerView.Adapter<RepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int) = RepoViewHolder(parent)

    override fun getItemCount(): Int = repos.size.takeIf { it < limit } ?: limit

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }
}

class RepoViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(parent.inflate(R.layout.repo_item, false)) {

    fun bind(repo: Repo) {
        with(itemView) {
            fullname.text = repo.full_name
            name.text = repo.name
            descript.text = repo.description
            descript.goneIfBlank()
            lang.text = repo.language
            lang.goneIfBlank()
            star.text = repo.stargazers_count.toString()
            issue.text = repo.open_issues.toString()
            license.text = repo.license?.name
            license.goneIfBlank()
        }
    }

    fun TextView.goneIfBlank() {
        this.visibility = if (this.text.isNullOrBlank()) View.GONE else View.VISIBLE
    }
}