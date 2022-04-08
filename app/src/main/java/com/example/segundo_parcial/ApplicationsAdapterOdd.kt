package com.example.segundo_parcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApplicationsAdapterOdd(context: Context, feedEntries: ArrayList<Id_Impar>): RecyclerView.Adapter<ApplicationsAdapterOdd.ViewHolder>() {

    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<Id_Impar>? = null
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationsAdapterOdd.ViewHolder{
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.activity_peliculas_impar, parent, false)
        return ViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ApplicationsAdapterOdd.ViewHolder, position: Int) {
        val currentFeedEntry: Id_Impar  = localFeedEntries!![position]
        holder.textViewTitleOdd.text = currentFeedEntry.title
        holder.textViewRating.text = currentFeedEntry.imdbRating
        holder.textViewVotes.text = currentFeedEntry.imdbVotes
        holder.textViewMetascore.text = currentFeedEntry.metascore
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0
    }

    class ViewHolder(v: View, listener: onItemClickListener): RecyclerView.ViewHolder(v) {

        val textTitulo: TextView = v.findViewById(R.id.textViewTitleOdd)
        val textRating: TextView = v.findViewById(R.id.textViewRating)
        val textVotes: TextView = v.findViewById(R.id.textViewVotes)
        val textMetascore: TextView = v.findViewById(R.id.textViewMetascore)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}