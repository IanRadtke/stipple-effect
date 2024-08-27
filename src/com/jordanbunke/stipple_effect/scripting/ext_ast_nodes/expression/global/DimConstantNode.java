package com.jordanbunke.stipple_effect.scripting.ext_ast_nodes.expression.global;

import com.jordanbunke.delta_time.scripting.ast.nodes.types.TypeNode;
import com.jordanbunke.delta_time.scripting.ast.symbol_table.SymbolTable;
import com.jordanbunke.delta_time.scripting.util.TextPosition;

public final class DimConstantNode extends ConstantNode {
    public static final String HORZ = "HORZ", VERT = "VERT";

    private final boolean horizontal;

    public DimConstantNode(
            final TextPosition position, final boolean horizontal
    ) {
        super(position);

        this.horizontal = horizontal;
    }

    @Override
    public Boolean evaluate(final SymbolTable symbolTable) {
        return horizontal;
    }

    @Override
    public TypeNode getType(final SymbolTable symbolTable) {
        return TypeNode.getBool();
    }

    @Override
    protected String callName() {
        return horizontal ? HORZ : VERT;
    }
}
