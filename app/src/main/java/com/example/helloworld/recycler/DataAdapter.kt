package com.example.helloworld.recycler

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.helloworld.R
import kotlinx.android.synthetic.main.data_item.view.descriptionText
import kotlinx.android.synthetic.main.data_item.view.titleText

class DataAdapter(
        val datas: List<Data>,
        val limit: Int = Int.MAX_VALUE
) : RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(view: ViewGroup, type: Int) = DataViewHolder(view)

    override fun getItemCount() = datas.size.takeIf { it < limit } ?: limit

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(context).inflate(resource, this, attachToRoot)

class DataViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(parent.inflate(R.layout.data_item, false)) {

    fun bind(data: Data) {
        with(itemView) {
            titleText.text = data.title
            descriptionText.text = data.description
        }
    }
}
