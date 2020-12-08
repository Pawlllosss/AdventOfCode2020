package task7

class BagsCounter {

    fun countParentBags(bagColor: String, bagsParentHierarchy: Map<String, Set<Pair<String, Int>>>): Int {
        val parentColors = mutableSetOf<String>()
        findAllBagAscendants(bagColor, parentColors, bagsParentHierarchy)

        return parentColors.size
    }

    fun countChildBagsRequiredInBag(bagColor: String, bagsChildrenHierarchy: Map<String, Set<Pair<String, Int>>>): Int {
        return countChildBagsRequiredInBag(1, bagColor, bagsChildrenHierarchy)
    }

    private fun findAllBagAscendants(
        bagColor: String,
        parentColors: MutableSet<String>,
        bagsParentHierarchy: Map<String, Set<Pair<String, Int>>>
    ) {
        bagsParentHierarchy[bagColor]?.forEach {
            val color = it.first
            parentColors.add(color)
            findAllBagAscendants(color, parentColors, bagsParentHierarchy)
        }
    }

    private fun countChildBagsRequiredInBag(
        bagsNumber: Int,
        parentColorColor: String,
        bagsChildrenHierarchy: Map<String, Set<Pair<String, Int>>>
    ): Int {
        var sum = 0
        bagsChildrenHierarchy[parentColorColor]?.forEach {
            val (childrenColor, childrenCount) = it
            sum += bagsNumber * childrenCount + countChildBagsRequiredInBag(
                bagsNumber * childrenCount,
                childrenColor,
                bagsChildrenHierarchy
            )
        }

        return sum
    }
}