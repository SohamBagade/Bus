package com.example.bus.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ccpp.shared.entities.BookingList
import com.example.bus.R

class BookingAdapter(private val bookingListList: ArrayList<BookingList>) : RecyclerView.Adapter<BookingAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: BookingAdapter.ViewHolder, position: Int) {
        holder.bindItems(bookingListList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return bookingListList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(bookingList: BookingList) {
            val imgBooking = itemView.findViewById(R.id.img_booking) as ImageView
            val tvBooking  = itemView.findViewById(R.id.tv_booking) as TextView

            imgBooking.setImageResource(bookingList.imgIcon!!)
            tvBooking.text = bookingList.name
        }
    }
}