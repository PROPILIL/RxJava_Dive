package com.propil.rxjavadive

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit
import kotlin.random.Random


class Creation {


    //Выполнить
    fun exec() {
        Consumer(Producer()).execFromCallable()
    }

    //ИБД
    fun randomOperation(): Boolean {
        Thread.sleep(Random.nextLong(1000))
        return listOf(true, false, true) [Random.nextInt(2)]
    }

    //Производитель
    class Producer {
        val creation = Creation()

        fun just(): Observable<String> {
            return Observable.just("1", "2", "3")
        }
        fun fromIterable(): Observable<String> {
            return Observable.fromIterable(listOf("1", "2", "3"))
        }
        fun interval() = Observable.interval(5, TimeUnit.SECONDS)

        fun timer() = Observable.timer(5, TimeUnit.SECONDS)

        fun range() = Observable.range(1, 10)

        fun fromCallable() = Observable.fromCallable {
            val result = creation.randomOperation()
            return@fromCallable result
        }
    }

    //Потребитель
    class Consumer(val producer: Producer) {
        val stringObserver = object : Observer<String> {
            var disposable: Disposable? = null

            override fun onSubscribe(d: Disposable) {
                disposable = d
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                println("onNext $t")
            }

            override fun onError(e: Throwable) {
                println("OnError ${e.message}")
            }

            override fun onComplete() {
                println("OnComplete")
            }
        }

        fun exec() {
            execJust()
        }

        fun execJust() {
            producer.just()
                .subscribe(stringObserver)
        }

        // Заменяет execJust() и 4 коллбэка сверху
        fun execJustLambda() {
            val disposable = producer.just()
                .subscribe({ s ->
                    println("OnNext $s")
                }, { e ->
                    println("OnError ${e.message}")
                }, {
                    println("OnComplete")
                })
        }

        fun execFromIterable(){
            producer.fromIterable()
                .subscribe(stringObserver)
        }

        fun execInterval(){
            producer.interval()
                .subscribe {
                    println("onNext $it")
                }
        }

        fun execTimer(){
            producer.timer()
                .subscribe {
                    println("onNext $it")
                }
        }

        fun execRange(){
            producer.range()
                .subscribe {
                    println("OnNext $it")
                }
        }

        fun execFromCallable() {
            producer.fromCallable()
                .subscribe {
                    println("OnNext $it")
                }
        }
    }
}