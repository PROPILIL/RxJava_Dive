package com.propil.rxjavadive.testop

class Sorter<T>() {

    fun sort( list: List<DataS>) {
        when(list[0]) {
            is Data1 -> println(list[0].raz)
            is Data2 -> println(list[0].raz)
        }
    }
}