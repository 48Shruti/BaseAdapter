package com.shruti.ListBaseAdapterApp

interface ActivityInterface {
    fun onDeleteclick(student: Student,position:Int)
    fun onUpdateclick(student: Student , position: Int)
}