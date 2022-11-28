package edu.asu.agupt385.cse564.assignment4.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines behavior of a listener for a parse tree produced by
 * {@link DOTParser}.
 * <p>
 * Generated from DOT.g4 by ANTLR 4.11.1
 */
public interface DOTListener extends ParseTreeListener {
    void enterGraph(DOTParser.GraphContext var1);

    void exitGraph(DOTParser.GraphContext var1);

    void enterStmt_list(DOTParser.Stmt_listContext var1);

    void exitStmt_list(DOTParser.Stmt_listContext var1);

    void enterStmt(DOTParser.StmtContext var1);

    void exitStmt(DOTParser.StmtContext var1);

    void enterAttr_stmt(DOTParser.Attr_stmtContext var1);

    void exitAttr_stmt(DOTParser.Attr_stmtContext var1);

    void enterAttr_list(DOTParser.Attr_listContext var1);

    void exitAttr_list(DOTParser.Attr_listContext var1);

    void enterA_list(DOTParser.A_listContext var1);

    void exitA_list(DOTParser.A_listContext var1);

    void enterEdge_stmt(DOTParser.Edge_stmtContext var1);

    void exitEdge_stmt(DOTParser.Edge_stmtContext var1);

    void enterEdgeRHS(DOTParser.EdgeRHSContext var1);

    void exitEdgeRHS(DOTParser.EdgeRHSContext var1);

    void enterEdgeop(DOTParser.EdgeopContext var1);

    void exitEdgeop(DOTParser.EdgeopContext var1);

    void enterNode_stmt(DOTParser.Node_stmtContext var1);

    void exitNode_stmt(DOTParser.Node_stmtContext var1);

    void enterNode_id(DOTParser.Node_idContext var1);

    void exitNode_id(DOTParser.Node_idContext var1);

    void enterPort(DOTParser.PortContext var1);

    void exitPort(DOTParser.PortContext var1);

    void enterSubgraph(DOTParser.SubgraphContext var1);

    void exitSubgraph(DOTParser.SubgraphContext var1);

    void enterId_(DOTParser.Id_Context var1);

    void exitId_(DOTParser.Id_Context var1);
}
