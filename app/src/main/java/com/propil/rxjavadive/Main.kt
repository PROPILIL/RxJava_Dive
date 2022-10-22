package com.propil.rxjavadive

import com.propil.rxjavadive.testop.*


fun main(){

    val data1 = Data1()

    val sorter = Sorter<Any>()

    val list1 = listOf(Data1())


    val list2 = listOf(Data2())

//    val list3 = listOf(Data3())


    sorter.sort(list1)
    sorter.sort(list2)

    println(data1.tri)
    }
