package com.jordanbunke.stipple_effect.scripting.ast.nodes.expression.literal;

import com.jordanbunke.stipple_effect.scripting.TextPosition;
import com.jordanbunke.stipple_effect.scripting.ast.nodes.types.ScrippleTypeNode;
import com.jordanbunke.stipple_effect.scripting.ast.nodes.types.SimpleTypeNode;
import com.jordanbunke.stipple_effect.scripting.ast.symbol_table.SymbolTable;

public final class CharLiteralNode extends LiteralNode {
    private final char value;

    public CharLiteralNode(
            final TextPosition position,
            final char value
    ) {
        super(position);

        this.value = value;
    }

    @Override
    public Character evaluate(final SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ScrippleTypeNode getType(final SymbolTable symbolTable) {
        return new SimpleTypeNode(SimpleTypeNode.Type.CHAR);
    }
}
