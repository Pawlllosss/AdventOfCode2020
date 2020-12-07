package task7

import java.lang.IllegalArgumentException

class LuggageRuleConverter {

    private val parentChildSeparateRegex = Regex("([a-zA-Z ]+) bags contain (.*)")
    private val childRegex = Regex("([\\d]+) ([a-z ]+) bag")
    private val noChildBagsInformation = "no other bags."
    private val parentDelimiter = "  bags contain "
    private val childDelimiter = ", "

    fun convertToLuggageRule(rule: String): LuggageRule {
        val (parent, child) = getParentBagAndChildPart(rule)
        val parentColor = getParentBagColor(parent)
        val childBags = getChildBags(child)

        return LuggageRule(parentColor, childBags)
    }

    private fun getParentBagAndChildPart(rule: String): Pair<String, String> {
        val (parent, child) = parentChildSeparateRegex.find(rule)?.destructured
            ?: throw IllegalArgumentException("$rule is not properly formatted")
        return Pair(parent, child)
    }

    private fun getParentBagColor(parent: String): String {
        return parent.split(parentDelimiter)[0]
    }

    private fun getChildBags(child: String): Set<Pair<String, Int>> {
        if (containsNoChildBags(child)) {
            return setOf()
        }

        return getChildBagsInformation(child)
    }

    private fun containsNoChildBags(child: String) = child == noChildBagsInformation

    private fun getChildBagsInformation(child: String): Set<Pair<String, Int>> {
        val childBags = child.split(childDelimiter)
        return childBags.map {
            val (quantity, color) = childRegex.find(it)?.destructured
                ?: throw IllegalArgumentException("Child rule $it is not properly formatted")
            Pair(color, quantity.toInt())
        }.toSet()
    }
}