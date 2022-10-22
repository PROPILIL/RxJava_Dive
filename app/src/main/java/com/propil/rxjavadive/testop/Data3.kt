package com.propil.rxjavadive.testop

data class Data3 (
    val uno: String,
    val dos: String,
    val tres: Double,
): SortInterface {

    override val razraz: String
        get() = uno
    override val dvadva: String
        get() = dos
    override val tritri: Double
        get() = tres

}