package pl.adrian.pieper.generator.adventure

import pl.adrian.pieper.aML.Condition
import pl.adrian.pieper.aML.PlayerLogicFormula
import pl.adrian.pieper.aML.PlayerLogicValue
import pl.adrian.pieper.aML.PlayerLogicRightSideExpression
import pl.adrian.pieper.aML.LogicalOperationType
import pl.adrian.pieper.aML.NegativePlayerLogicValue
import pl.adrian.pieper.aML.PlayerLogicBrackets
import pl.adrian.pieper.aML.PlayerLogicValueExpression
import pl.adrian.pieper.aML.ComparatorType
import pl.adrian.pieper.aML.VariableType

class AdventureConditionGenerator {

    def String generate(Condition contition) {

        return generate(contition.formula)
    }

    def String generate(PlayerLogicFormula formula) {
        return generate(formula.value) + generate(formula.rightSide)
    }

    def String generate(PlayerLogicValue value) {
        switch (value) {
            NegativePlayerLogicValue : generate(value)
            PlayerLogicBrackets : generate(value)
            PlayerLogicValueExpression : generate(value)
        }
    }

    def String generate(NegativePlayerLogicValue negValue) {
        return "!("+generate(negValue.value)+")"
    }

    def String generate(PlayerLogicBrackets value) {
        return '(' + generate(value.formula) + ')'
    }

    def String generate(PlayerLogicValueExpression value) {
        return generate(value.variable)+generate(value.comparator)+value.value
    }

    def String generate(PlayerLogicRightSideExpression expression) {
        if (expression == null) return ""
        return
        ''' «generate(expression.operation)» «generate(expression.rightSide)»'''
    }

    def String generate(LogicalOperationType operation) {
        switch(operation) {
            case AND : return "&&"
            case OR : return "||"
        }
    }

    def String generate(ComparatorType comparator) {
        switch(comparator) {
            case LESS : return "<"
            case MORE : return ">"
        }
    }

    def String generate(VariableType variable) {
        return "c.player"+variable.literal.toFirstUpper+"()"
    }
}
