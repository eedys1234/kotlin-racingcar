package racing.domain

import racing.ui.InputView
import racing.ui.ResultView

class RacingGame {

    fun start() {

        val carNames = InputView.requireRacingCarNames()
        val cars = CarFactory.create(carNames)
        var numberOfGames = InputView.requireNumberOfGames()

        ResultView.printRacingGameGuideText()
        while (numberOfGames-- > 0) {
            cars.race { RandomGenerator.generate() }
            ResultView.printRacingGameResult(ResultView.toRaceResult(cars))
        }
        val winner = Winner(cars)
        ResultView.printRacingGameWinner(winner.win())
    }
}
