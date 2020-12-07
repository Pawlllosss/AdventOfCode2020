package task7

class ParentBagsHierarchyCreator {

    fun createParentHierarchy(luggageRules: List<LuggageRule>): Map<String, Set<Pair<String, Int>>> {
        val childByParent = HashMap<String, MutableSet<Pair<String, Int>>>()

        for ((parentColor, childBags) in luggageRules) {
            for (child in childBags) {
                val childColor = child.first
                val quantity = child.second
                val parentInfo = parentColor to quantity
                childByParent[childColor]?.add(parentInfo) ?: childByParent.put(childColor, mutableSetOf(parentInfo))
            }
        }

        return childByParent
    }
}