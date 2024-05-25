package com.jordanbunke.stipple_effect.scripting.ext_ast_nodes.expression.palette;

import com.jordanbunke.delta_time.scripting.ast.nodes.expression.ExpressionNode;
import com.jordanbunke.delta_time.scripting.ast.nodes.types.TypeNode;
import com.jordanbunke.delta_time.scripting.ast.symbol_table.SymbolTable;
import com.jordanbunke.delta_time.scripting.util.TextPosition;
import com.jordanbunke.stipple_effect.palette.Palette;
import com.jordanbunke.stipple_effect.scripting.ext_ast_nodes.expression.ScopedExpressionNode;
import com.jordanbunke.stipple_effect.scripting.ext_ast_nodes.type.PaletteTypeNode;

public abstract class PaletteExpressionNode extends ScopedExpressionNode {
    public PaletteExpressionNode(
            final TextPosition position, final ExpressionNode scope,
            final ExpressionNode[] args, final TypeNode... expectedArgTypes
    ) {
        super(position, scope, PaletteTypeNode.get(), args, expectedArgTypes);
    }

    protected final Palette getPalette(final SymbolTable symbolTable) {
        return (Palette) scope.evaluate(symbolTable);
    }
}
