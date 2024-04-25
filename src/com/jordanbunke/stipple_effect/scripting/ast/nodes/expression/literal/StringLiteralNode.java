package com.jordanbunke.stipple_effect.scripting.ast.nodes.expression.literal;

import com.jordanbunke.stipple_effect.scripting.TextPosition;
import com.jordanbunke.stipple_effect.scripting.ast.nodes.types.ScrippleTypeNode;
import com.jordanbunke.stipple_effect.scripting.ast.nodes.types.SimpleTypeNode;
import com.jordanbunke.stipple_effect.scripting.ast.symbol_table.SymbolTable;

public final class StringLiteralNode extends LiteralNode {
    private final String value;

    public StringLiteralNode(
            final TextPosition position,
            final String value
    ) {
        super(position);

        this.value = value;
    }

    @Override
    public String evaluate(final SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ScrippleTypeNode getType(final SymbolTable symbolTable) {
        return new SimpleTypeNode(SimpleTypeNode.Type.STRING);
    }
}
