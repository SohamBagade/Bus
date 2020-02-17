package com.example.bus.ui.home

import com.ccpp.shared.entities.BookingList
import com.example.bus.R
import com.example.bus.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor():BaseViewModel()
{

    public fun getBookArrayList():ArrayList<BookingList>
    {
        val list: ArrayList<BookingList> = ArrayList()
        val bookingList1 = BookingList(R.drawable.ic_car,"rPool")
        val bookingList2 = BookingList(R.drawable.ic_car,"Bus Hire")
        val bookingList3 = BookingList(R.drawable.ic_car,"Food & Fun")
        val bookingList4 = BookingList(R.drawable.ic_car,"Packages")
        val bookingList5 = BookingList(R.drawable.ic_car,"Recharge")

        list.add(bookingList1)
        list.add(bookingList2)
        list.add(bookingList3)
        list.add(bookingList4)
        list.add(bookingList5)

        return list

    }

}