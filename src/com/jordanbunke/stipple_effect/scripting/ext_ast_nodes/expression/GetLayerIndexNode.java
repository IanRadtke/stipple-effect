package com.jordanbunke.stipple_effect.scripting.ext_ast_nodes.expression;

import com.jordanbunke.delta_time.scripting.ast.nodes.expression.ExpressionNode;
import com.jordanbunke.delta_time.scripting.ast.nodes.types.BaseTypeNode;
import com.jordanbunke.delta_time.scripting.ast.nodes.types.TypeNode;
import com.jordanbunke.delta_time.scripting.ast.symbol_table.SymbolTable;
import com.jordanbunke.delta_time.scripting.util.TextPosition;
import com.jordanbunke.stipple_effect.project.SEContext;

public final class GetLayerIndexNode extends TrivialProjectGetterNode {
    public static final String NAME = "get_layer_index";

    public GetLayerIndexNode(
            final TextPosition position, final ExpressionNode[] args
    ) {
        super(position, args);
    }

    @Override
    protected Integer getter(final SEContext project) {
        return project.getState().getLayerEditIndex();
    }

    @Override
    public BaseTypeNode getType(final SymbolTable symbolTable) {
        return TypeNode.getInt();
    }

    @Override
    protected String callName() {
        return NAME;
    }
}
