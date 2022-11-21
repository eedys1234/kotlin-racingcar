package racing.domain

class Cars : Iterable<Car> {

    private val list: List<Car>

    constructor(names: String) {
        list = names.split(SEPARATOR).map {
            Car.produce(it)
        }
    }
    constructor(carList: List<Car>) {
        list = carList
    }

    fun count() = list.size

    fun race(movable: () -> Int) {
        list.forEach {
            car ->
            car.move(movable())
        }
    }
    override fun iterator(): Iterator<Car> = list.iterator()

    companion object {
        const val SEPARATOR = ","
    }
}
