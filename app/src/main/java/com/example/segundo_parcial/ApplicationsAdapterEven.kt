package com.example.segundo_parcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApplicationsAdapterEven(context: Context, feedEntries: ArrayList<Id_Par>): RecyclerView.Adapter<ApplicationsAdapterOdd.ViewHolder>() {

    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<Id_Par>? = null
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ApplicationsAdapterOdd.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.activity_peliculas_impar, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ApplicationsAdapterOdd.ViewHolder, position: Int) {
        val currentFeedEntry: Id_Par = localFeedEntries!![position]
        holder.textViewTitleEven.text = currentFeedEntry.title
        holder.textViewYear.text = currentFeedEntry.year
        holder.textViewDirector.text = currentFeedEntry.director
        holder.textViewLanguages.text = currentFeedEntry.language
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0
    }

    class ViewHolder(v: View, listener: onItemClickListener) : RecyclerView.ViewHolder(v) {

        val textTitulo: TextView = v.findViewById(R.id.textViewTitleEven)
        val textAño: TextView = v.findViewById(R.id.textViewYear)
        val textDirector: TextView = v.findViewById(R.id.textViewDirector)
        val textLenguajes: TextView = v.findViewById(R.id.textViewLanguages)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}