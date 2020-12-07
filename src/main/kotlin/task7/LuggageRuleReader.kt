package task7

import utils.FileUtils
import java.io.BufferedReader

class LuggageRuleReader(private val luggageRuleConverter: LuggageRuleConverter) {

    fun getLuggageRules(rulesPath: String): List<LuggageRule> {
        val bufferedReader = FileUtils.getBufferedReader(rulesPath)
        return readLuggageRulesFromFile(bufferedReader)
    }

    private fun readLuggageRulesFromFile(bufferedReader: BufferedReader): List<LuggageRule> {
        val rules = ArrayList<LuggageRule>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val luggageRule = luggageRuleConverter.convertToLuggageRule(it)
                rules.add(luggageRule)
            }
        }
        return rules
    }
}