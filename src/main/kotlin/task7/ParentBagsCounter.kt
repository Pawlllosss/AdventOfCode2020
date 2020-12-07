package task7

class ParentBagsCounter {

    fun countParentBags(bagColor: String, bagsHierarchy: Map<String, Set<Pair<String, Int>>>): Int {
        val parentColors = mutableSetOf<String>()
        findAllBagAscendants(bagColor, parentColors, bagsHierarchy)

        return parentColors.size
    }

    private fun findAllBagAscendants(
        bagColor: String,
        parentColors: MutableSet<String>,
        bagsHierarchy: Map<String, Set<Pair<String, Int>>>
    ) {
        bagsHierarchy[bagColor]?.forEach {
            val color = it.first
            parentColors.add(color)
            findAllBagAscendants(color, parentColors, bagsHierarchy)
        }
    }
}