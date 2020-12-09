package task8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class InstructionConverterTest {

    private val instructionRepository = InstructionRepository()
    private val converter = InstructionConverter(instructionRepository)

    @ParameterizedTest
    @CsvSource(
        "nop +0, 0, nop",
        "acc +12, 12, acc",
        "acc -12, -12, acc",
        "jmp +534, 534, jmp"
    )
    fun shouldReturnInstruction(instructionLine: String, argument: Int, operationKey: String) {
        // WHEN
        val instruction = converter.convertToInstruction(instructionLine)

        // THEN
        val expectedInstruction = createExpectedInstruction(operationKey, argument)
        assertThat(instruction).isEqualTo(expectedInstruction)
    }

    private fun createExpectedInstruction(operationKey: String, argument: Int): Instruction {
        val operation = instructionRepository.getInstructionsOperations()[operationKey]!!
        return Instruction(operationKey, argument, operation)
    }
}