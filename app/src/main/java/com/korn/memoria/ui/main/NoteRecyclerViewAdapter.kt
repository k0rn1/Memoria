package com.korn.memoria.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.korn.memoria.R


import com.korn.memoria.ui.main.NoteFragment.OnListFragmentInteractionListener
import com.korn.memoria.ui.main.dummy.DummyContent.DummyItem
import kotlinx.android.synthetic.main.activity_main.view.*

import kotlinx.android.synthetic.main.fragment_note.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class NoteRecyclerViewAdapter(
    private val mValues: List<DummyItem> = listOf(DummyItem("1", "test", "detail")),
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.tvTitle.text = item.title
        holder.tvDetails.text = item.details

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val tvTitle: TextView = mView.tv_note_title
        val tvDetails: TextView = mView.tv_note_details

        override fun toString(): String {
            return super.toString() + " '" + tvDetails.text + "'"
        }
    }
}
