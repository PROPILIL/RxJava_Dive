package com.propil.rxjavadive.testop

data class Data2(
    val one: String = "raz",
    val two: String = "dva",
    val three: Double = 0.2
): DataS() {

    override val raz: String
        get() = one
    override val dva: String
        get() = two
    override val tri: Double
        get() = three
}