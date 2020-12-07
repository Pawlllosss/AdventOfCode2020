package task7.part1

import task7.LuggageRuleConverter
import task7.LuggageRuleReader
import task7.ParentBagsCounter
import task7.ParentBagsHierarchyCreator

fun main() {
    val rulesPath = "src/main/kotlin/task7/resource/input"
    val converter = LuggageRuleConverter()
    val rulesReader = LuggageRuleReader(converter)
    val hierarchyCreator = ParentBagsHierarchyCreator()
    val counter = ParentBagsCounter()
    val luggageRules = rulesReader.getLuggageRules(rulesPath)
    val hierarchy = hierarchyCreator.createParentHierarchy(luggageRules)
    println(counter.countParentBags("shiny gold", hierarchy))
}