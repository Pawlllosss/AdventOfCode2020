package task10

internal object JoltTestUtils {

    fun getJolts(): List<Long> = listOf<Long>(
        28,
        33,
        18,
        42,
        31,
        14,
        46,
        20,
        48,
        47,
        24,
        23,
        49,
        52,
        45,
        19,
        38,
        39,
        0,
        11,
        1,
        32,
        25,
        35,
        8,
        17,
        7,
        9,
        4,
        2,
        34,
        10,
        3
    ).sorted()

    fun getLessJolts(): List<Long> = listOf<Long>(
        16,
        10,
        15,
        5,
        1,
        11,
        7,
        22,
        19,
        6,
        0,
        12,
        4
    ).sorted()
}