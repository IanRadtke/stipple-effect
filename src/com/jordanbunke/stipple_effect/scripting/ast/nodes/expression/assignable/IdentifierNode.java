package com.jordanbunke.stipple_effect.scripting.ast.nodes.expression.assignable;

import com.jordanbunke.stipple_effect.scripting.TextPosition;
import com.jordanbunke.stipple_effect.scripting.ast.nodes.types.ScrippleTypeNode;
import com.jordanbunke.stipple_effect.scripting.ast.symbol_table.SymbolTable;

public final class IdentifierNode extends AssignableNode {
    public IdentifierNode(
            final TextPosition position, final String name
    ) {
        super(position, name);
    }

    @Override
    public void semanticErrorCheck(final SymbolTable symbolTable) {
        // TODO
    }

    @Override
    public Object evaluate(final SymbolTable symbolTable) {
        // TODO
        return null;
    }

    @Override
    public ScrippleTypeNode getType(final SymbolTable symbolTable) {
        // TODO
        return null;
    }
}
