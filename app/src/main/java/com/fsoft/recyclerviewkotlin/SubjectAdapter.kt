package com.fsoft.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fsoft.recyclerviewkotlin.databinding.ItemSubjectBinding

class SubjectAdapter(private val listSubject: List<String>) :
    RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    inner class ViewHolder(private val binding: ItemSubjectBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
   
        fun bindData(subject: String) {
            mBinding.textViewSubject.text = subject
            mBinding.root.rootView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener.onItemClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSubjectBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(listSubject[position])
    }

    override fun getItemCount() = listSubject.size
}
