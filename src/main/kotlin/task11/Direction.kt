package task11

enum class Direction(val moveToNext: (coordinates: Pair<Int, Int>) -> Pair<Int, Int>) {
    UP({ coordinates: Pair<Int, Int> -> coordinates.first - 1 to coordinates.second }),
    UP_LEFT({ coordinates: Pair<Int, Int> -> coordinates.first - 1 to coordinates.second - 1 }),
    UP_RIGHT({ coordinates: Pair<Int, Int> -> coordinates.first - 1 to coordinates.second + 1 }),
    DOWN({ coordinates: Pair<Int, Int> -> coordinates.first + 1 to coordinates.second }),
    DOWN_LEFT({ coordinates: Pair<Int, Int> -> coordinates.first + 1 to coordinates.second - 1 }),
    DOWN_RIGHT({ coordinates: Pair<Int, Int> -> coordinates.first + 1 to coordinates.second + 1 }),
    LEFT({ coordinates: Pair<Int, Int> -> coordinates.first to coordinates.second - 1 }),
    RIGHT({ coordinates: Pair<Int, Int> -> coordinates.first to coordinates.second + 1 }),
}