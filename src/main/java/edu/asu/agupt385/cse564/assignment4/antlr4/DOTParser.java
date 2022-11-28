package edu.asu.agupt385.cse564.assignment4.antlr4;

import java.util.List;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Generated from DOT.g4 by ANTLR 4.11.1
 */
public class DOTParser extends Parser {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache;
    public static final int T__0 = 1;
    public static final int T__1 = 2;
    public static final int T__2 = 3;
    public static final int T__3 = 4;
    public static final int T__4 = 5;
    public static final int T__5 = 6;
    public static final int T__6 = 7;
    public static final int T__7 = 8;
    public static final int T__8 = 9;
    public static final int T__9 = 10;
    public static final int STRICT = 11;
    public static final int GRAPH = 12;
    public static final int DIGRAPH = 13;
    public static final int NODE = 14;
    public static final int EDGE = 15;
    public static final int SUBGRAPH = 16;
    public static final int NUMBER = 17;
    public static final int STRING = 18;
    public static final int ID = 19;
    public static final int HTML_STRING = 20;
    public static final int COMMENT = 21;
    public static final int LINE_COMMENT = 22;
    public static final int PREPROC = 23;
    public static final int WS = 24;
    public static final int RULE_graph = 0;
    public static final int RULE_stmt_list = 1;
    public static final int RULE_stmt = 2;
    public static final int RULE_attr_stmt = 3;
    public static final int RULE_attr_list = 4;
    public static final int RULE_a_list = 5;
    public static final int RULE_edge_stmt = 6;
    public static final int RULE_edgeRHS = 7;
    public static final int RULE_edgeop = 8;
    public static final int RULE_node_stmt = 9;
    public static final int RULE_node_id = 10;
    public static final int RULE_port = 11;
    public static final int RULE_subgraph = 12;
    public static final int RULE_id_ = 13;
    public static final String[] ruleNames;
    private static final String[] _LITERAL_NAMES;
    private static final String[] _SYMBOLIC_NAMES;
    public static final Vocabulary VOCABULARY;
    /** @deprecated */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN = "\u0004\u0001\u0018\u0081\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0003\u0000\u001e\b\u0000\u0001\u0000\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004\u0001\u0004\u0004\u0004D\b\u0004\u000b\u0004\f\u0004E\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005K\b\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0004\u0005P\b\u0005\u000b\u0005\f\u0005Q\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007_\b\u0007\u0004\u0007a\b\u0007\u000b\u0007\f\u0007b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\ti\b\t\u0001\n\u0001\n\u0003\nm\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bs\b\u000b\u0001\f\u0001\f\u0003\fw\b\f\u0003\fy\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\f\r\u0002\u0000\f\f\u000e\u000f\u0001\u0000\b\t\u0001\u0000\u0011\u0014\u0088\u0000\u001d\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010d\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016n\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c\u001e\u0005\u000b\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0007\u0000\u0000\u0000 \"\u0003\u001a\r\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0005\u0001\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0002\u0000\u0000&'\u0005\u0000\u0000\u0001'\u0001\u0001\u0000\u0000\u0000(*\u0003\u0004\u0002\u0000)+\u0005\u0003\u0000\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0003\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00001:\u0003\u0012\t\u00002:\u0003\f\u0006\u00003:\u0003\u0006\u0003\u000045\u0003\u001a\r\u000056\u0005\u0004\u0000\u000067\u0003\u001a\r\u00007:\u0001\u0000\u0000\u00008:\u0003\u0018\f\u000091\u0001\u0000\u0000\u000092\u0001\u0000\u0000\u000093\u0001\u0000\u0000\u000094\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;<\u0007\u0001\u0000\u0000<=\u0003\b\u0004\u0000=\u0007\u0001\u0000\u0000\u0000>@\u0005\u0005\u0000\u0000?A\u0003\n\u0005\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0005\u0006\u0000\u0000C>\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\t\u0001\u0000\u0000\u0000GJ\u0003\u001a\r\u0000HI\u0005\u0004\u0000\u0000IK\u0003\u001a\r\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LN\u0005\u0007\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u000b\u0001\u0000\u0000\u0000SV\u0003\u0014\n\u0000TV\u0003\u0018\f\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0003\u000e\u0007\u0000XZ\u0003\b\u0004\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\r\u0001\u0000\u0000\u0000[^\u0003\u0010\b\u0000\\_\u0003\u0014\n\u0000]_\u0003\u0018\f\u0000^\\\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`[\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\u000f\u0001\u0000\u0000\u0000de\u0007\u0002\u0000\u0000e\u0011\u0001\u0000\u0000\u0000fh\u0003\u0014\n\u0000gi\u0003\b\u0004\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jl\u0003\u001a\r\u0000km\u0003\u0016\u000b\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0015\u0001\u0000\u0000\u0000no\u0005\n\u0000\u0000or\u0003\u001a\r\u0000pq\u0005\n\u0000\u0000qs\u0003\u001a\r\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0017\u0001\u0000\u0000\u0000tv\u0005\u0010\u0000\u0000uw\u0003\u001a\r\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0001\u0000\u0000{|\u0003\u0002\u0001\u0000|}\u0005\u0002\u0000\u0000}\u0019\u0001\u0000\u0000\u0000~\u007f\u0007\u0003\u0000\u0000\u007f\u001b\u0001\u0000\u0000\u0000\u0013\u001d!*.9@EJMQUY^bhlrvx";
    public static final ATN _ATN;

    private static String[] makeRuleNames() {
        return new String[]{"graph", "stmt_list", "stmt", "attr_stmt", "attr_list", "a_list", "edge_stmt", "edgeRHS", "edgeop", "node_stmt", "node_id", "port", "subgraph", "id_"};
    }

    private static String[] makeLiteralNames() {
        return new String[]{null, "'{'", "'}'", "';'", "'='", "'['", "']'", "','", "'->'", "'--'", "':'"};
    }

    private static String[] makeSymbolicNames() {
        return new String[]{null, null, null, null, null, null, null, null, null, null, null, "STRICT", "GRAPH", "DIGRAPH", "NODE", "EDGE", "SUBGRAPH", "NUMBER", "STRING", "ID", "HTML_STRING", "COMMENT", "LINE_COMMENT", "PREPROC", "WS"};
    }

    /** @deprecated */
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    public String getGrammarFileName() {
        return "java-escape";
    }

    public String[] getRuleNames() {
        return ruleNames;
    }

    public String getSerializedATN() {
        return "\u0004\u0001\u0018\u0081\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0003\u0000\u001e\b\u0000\u0001\u0000\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004\u0001\u0004\u0004\u0004D\b\u0004\u000b\u0004\f\u0004E\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005K\b\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0004\u0005P\b\u0005\u000b\u0005\f\u0005Q\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007_\b\u0007\u0004\u0007a\b\u0007\u000b\u0007\f\u0007b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\ti\b\t\u0001\n\u0001\n\u0003\nm\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bs\b\u000b\u0001\f\u0001\f\u0003\fw\b\f\u0003\fy\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\f\r\u0002\u0000\f\f\u000e\u000f\u0001\u0000\b\t\u0001\u0000\u0011\u0014\u0088\u0000\u001d\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010d\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016n\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c\u001e\u0005\u000b\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0007\u0000\u0000\u0000 \"\u0003\u001a\r\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0005\u0001\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0002\u0000\u0000&'\u0005\u0000\u0000\u0001'\u0001\u0001\u0000\u0000\u0000(*\u0003\u0004\u0002\u0000)+\u0005\u0003\u0000\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0003\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00001:\u0003\u0012\t\u00002:\u0003\f\u0006\u00003:\u0003\u0006\u0003\u000045\u0003\u001a\r\u000056\u0005\u0004\u0000\u000067\u0003\u001a\r\u00007:\u0001\u0000\u0000\u00008:\u0003\u0018\f\u000091\u0001\u0000\u0000\u000092\u0001\u0000\u0000\u000093\u0001\u0000\u0000\u000094\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;<\u0007\u0001\u0000\u0000<=\u0003\b\u0004\u0000=\u0007\u0001\u0000\u0000\u0000>@\u0005\u0005\u0000\u0000?A\u0003\n\u0005\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0005\u0006\u0000\u0000C>\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\t\u0001\u0000\u0000\u0000GJ\u0003\u001a\r\u0000HI\u0005\u0004\u0000\u0000IK\u0003\u001a\r\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LN\u0005\u0007\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u000b\u0001\u0000\u0000\u0000SV\u0003\u0014\n\u0000TV\u0003\u0018\f\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0003\u000e\u0007\u0000XZ\u0003\b\u0004\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\r\u0001\u0000\u0000\u0000[^\u0003\u0010\b\u0000\\_\u0003\u0014\n\u0000]_\u0003\u0018\f\u0000^\\\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`[\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\u000f\u0001\u0000\u0000\u0000de\u0007\u0002\u0000\u0000e\u0011\u0001\u0000\u0000\u0000fh\u0003\u0014\n\u0000gi\u0003\b\u0004\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jl\u0003\u001a\r\u0000km\u0003\u0016\u000b\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0015\u0001\u0000\u0000\u0000no\u0005\n\u0000\u0000or\u0003\u001a\r\u0000pq\u0005\n\u0000\u0000qs\u0003\u001a\r\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0017\u0001\u0000\u0000\u0000tv\u0005\u0010\u0000\u0000uw\u0003\u001a\r\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0001\u0000\u0000{|\u0003\u0002\u0001\u0000|}\u0005\u0002\u0000\u0000}\u0019\u0001\u0000\u0000\u0000~\u007f\u0007\u0003\u0000\u0000\u007f\u001b\u0001\u0000\u0000\u0000\u0013\u001d!*.9@EJMQUY^bhlrvx";
    }

    public ATN getATN() {
        return _ATN;
    }

    public DOTParser(TokenStream input) {
        super(input);
        this._interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public final GraphContext graph() throws RecognitionException {
        GraphContext _localctx = new GraphContext(this._ctx, this.getState());
        this.enterRule(_localctx, 0, 0);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(29);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);
            if (_la == 11) {
                this.setState(28);
                this.match(11);
            }

            this.setState(31);
            _la = this._input.LA(1);
            if (_la != 12 && _la != 13) {
                this._errHandler.recoverInline(this);
            } else {
                if (this._input.LA(1) == -1) {
                    this.matchedEOF = true;
                }

                this._errHandler.reportMatch(this);
                this.consume();
            }

            this.setState(33);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if ((_la & -64) == 0 && (1L << _la & 1966080L) != 0L) {
                this.setState(32);
                this.id_();
            }

            this.setState(35);
            this.match(1);
            this.setState(36);
            this.stmt_list();
            this.setState(37);
            this.match(2);
            this.setState(38);
            this.match(-1);
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Stmt_listContext stmt_list() throws RecognitionException {
        Stmt_listContext _localctx = new Stmt_listContext(this._ctx, this.getState());
        this.enterRule(_localctx, 2, 1);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(46);
            this._errHandler.sync(this);

            for(int _la = this._input.LA(1); (_la & -64) == 0 && (1L << _la & 2084866L) != 0L; _la = this._input.LA(1)) {
                this.setState(40);
                this.stmt();
                this.setState(42);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la == 3) {
                    this.setState(41);
                    this.match(3);
                }

                this.setState(48);
                this._errHandler.sync(this);
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(this._ctx, this.getState());
        this.enterRule(_localctx, 4, 2);

        try {
            this.setState(57);
            this._errHandler.sync(this);
            switch (((ParserATNSimulator)this.getInterpreter()).adaptivePredict(this._input, 4, this._ctx)) {
                case 1:
                    this.enterOuterAlt(_localctx, 1);
                    this.setState(49);
                    this.node_stmt();
                    break;
                case 2:
                    this.enterOuterAlt(_localctx, 2);
                    this.setState(50);
                    this.edge_stmt();
                    break;
                case 3:
                    this.enterOuterAlt(_localctx, 3);
                    this.setState(51);
                    this.attr_stmt();
                    break;
                case 4:
                    this.enterOuterAlt(_localctx, 4);
                    this.setState(52);
                    this.id_();
                    this.setState(53);
                    this.match(4);
                    this.setState(54);
                    this.id_();
                    break;
                case 5:
                    this.enterOuterAlt(_localctx, 5);
                    this.setState(56);
                    this.subgraph();
            }
        } catch (RecognitionException var6) {
            _localctx.exception = var6;
            this._errHandler.reportError(this, var6);
            this._errHandler.recover(this, var6);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Attr_stmtContext attr_stmt() throws RecognitionException {
        Attr_stmtContext _localctx = new Attr_stmtContext(this._ctx, this.getState());
        this.enterRule(_localctx, 6, 3);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(59);
            int _la = this._input.LA(1);
            if ((_la & -64) == 0 && (1L << _la & 53248L) != 0L) {
                if (this._input.LA(1) == -1) {
                    this.matchedEOF = true;
                }

                this._errHandler.reportMatch(this);
                this.consume();
            } else {
                this._errHandler.recoverInline(this);
            }

            this.setState(60);
            this.attr_list();
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Attr_listContext attr_list() throws RecognitionException {
        Attr_listContext _localctx = new Attr_listContext(this._ctx, this.getState());
        this.enterRule(_localctx, 8, 4);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(67);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);

            do {
                this.setState(62);
                this.match(5);
                this.setState(64);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if ((_la & -64) == 0 && (1L << _la & 1966080L) != 0L) {
                    this.setState(63);
                    this.a_list();
                }

                this.setState(66);
                this.match(6);
                this.setState(69);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            } while(_la == 5);
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final A_listContext a_list() throws RecognitionException {
        A_listContext _localctx = new A_listContext(this._ctx, this.getState());
        this.enterRule(_localctx, 10, 5);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(79);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);

            do {
                this.setState(71);
                this.id_();
                this.setState(74);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la == 4) {
                    this.setState(72);
                    this.match(4);
                    this.setState(73);
                    this.id_();
                }

                this.setState(77);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if (_la == 7) {
                    this.setState(76);
                    this.match(7);
                }

                this.setState(81);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            } while((_la & -64) == 0 && (1L << _la & 1966080L) != 0L);
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Edge_stmtContext edge_stmt() throws RecognitionException {
        Edge_stmtContext _localctx = new Edge_stmtContext(this._ctx, this.getState());
        this.enterRule(_localctx, 12, 6);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(85);
            this._errHandler.sync(this);
            switch (this._input.LA(1)) {
                case 1:
                case 16:
                    this.setState(84);
                    this.subgraph();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                default:
                    throw new NoViableAltException(this);
                case 17:
                case 18:
                case 19:
                case 20:
                    this.setState(83);
                    this.node_id();
            }

            this.setState(87);
            this.edgeRHS();
            this.setState(89);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);
            if (_la == 5) {
                this.setState(88);
                this.attr_list();
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final EdgeRHSContext edgeRHS() throws RecognitionException {
        EdgeRHSContext _localctx = new EdgeRHSContext(this._ctx, this.getState());
        this.enterRule(_localctx, 14, 7);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(96);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);

            do {
                do {
                    this.setState(91);
                    this.edgeop();
                    this.setState(94);
                    this._errHandler.sync(this);
                    switch (this._input.LA(1)) {
                        case 1:
                        case 16:
                            this.setState(93);
                            this.subgraph();
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        default:
                            throw new NoViableAltException(this);
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                            this.setState(92);
                            this.node_id();
                    }

                    this.setState(98);
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                } while(_la == 8);
            } while(_la == 9);
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final EdgeopContext edgeop() throws RecognitionException {
        EdgeopContext _localctx = new EdgeopContext(this._ctx, this.getState());
        this.enterRule(_localctx, 16, 8);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(100);
            int _la = this._input.LA(1);
            if (_la != 8 && _la != 9) {
                this._errHandler.recoverInline(this);
            } else {
                if (this._input.LA(1) == -1) {
                    this.matchedEOF = true;
                }

                this._errHandler.reportMatch(this);
                this.consume();
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Node_stmtContext node_stmt() throws RecognitionException {
        Node_stmtContext _localctx = new Node_stmtContext(this._ctx, this.getState());
        this.enterRule(_localctx, 18, 9);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(102);
            this.node_id();
            this.setState(104);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);
            if (_la == 5) {
                this.setState(103);
                this.attr_list();
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Node_idContext node_id() throws RecognitionException {
        Node_idContext _localctx = new Node_idContext(this._ctx, this.getState());
        this.enterRule(_localctx, 20, 10);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(106);
            this.id_();
            this.setState(108);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);
            if (_la == 10) {
                this.setState(107);
                this.port();
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final PortContext port() throws RecognitionException {
        PortContext _localctx = new PortContext(this._ctx, this.getState());
        this.enterRule(_localctx, 22, 11);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(110);
            this.match(10);
            this.setState(111);
            this.id_();
            this.setState(114);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);
            if (_la == 10) {
                this.setState(112);
                this.match(10);
                this.setState(113);
                this.id_();
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final SubgraphContext subgraph() throws RecognitionException {
        SubgraphContext _localctx = new SubgraphContext(this._ctx, this.getState());
        this.enterRule(_localctx, 24, 12);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(120);
            this._errHandler.sync(this);
            int _la = this._input.LA(1);
            if (_la == 16) {
                this.setState(116);
                this.match(16);
                this.setState(118);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                if ((_la & -64) == 0 && (1L << _la & 1966080L) != 0L) {
                    this.setState(117);
                    this.id_();
                }
            }

            this.setState(122);
            this.match(1);
            this.setState(123);
            this.stmt_list();
            this.setState(124);
            this.match(2);
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    public final Id_Context id_() throws RecognitionException {
        Id_Context _localctx = new Id_Context(this._ctx, this.getState());
        this.enterRule(_localctx, 26, 13);

        try {
            this.enterOuterAlt(_localctx, 1);
            this.setState(126);
            int _la = this._input.LA(1);
            if ((_la & -64) == 0 && (1L << _la & 1966080L) != 0L) {
                if (this._input.LA(1) == -1) {
                    this.matchedEOF = true;
                }

                this._errHandler.reportMatch(this);
                this.consume();
            } else {
                this._errHandler.recoverInline(this);
            }
        } catch (RecognitionException var7) {
            _localctx.exception = var7;
            this._errHandler.reportError(this, var7);
            this._errHandler.recover(this, var7);
        } finally {
            this.exitRule();
        }

        return _localctx;
    }

    static {
        RuntimeMetaData.checkVersion("4.11.1", "4.11.1");
        _sharedContextCache = new PredictionContextCache();
        ruleNames = makeRuleNames();
        _LITERAL_NAMES = makeLiteralNames();
        _SYMBOLIC_NAMES = makeSymbolicNames();
        VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
        tokenNames = new String[_SYMBOLIC_NAMES.length];

        int i;
        for(i = 0; i < tokenNames.length; ++i) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }

        _ATN = (new ATNDeserializer()).deserialize("\u0004\u0001\u0018\u0081\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0003\u0000\u001e\b\u0000\u0001\u0000\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004\u0001\u0004\u0004\u0004D\b\u0004\u000b\u0004\f\u0004E\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005K\b\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0004\u0005P\b\u0005\u000b\u0005\f\u0005Q\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007_\b\u0007\u0004\u0007a\b\u0007\u000b\u0007\f\u0007b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\ti\b\t\u0001\n\u0001\n\u0003\nm\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bs\b\u000b\u0001\f\u0001\f\u0003\fw\b\f\u0003\fy\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\f\r\u0002\u0000\f\f\u000e\u000f\u0001\u0000\b\t\u0001\u0000\u0011\u0014\u0088\u0000\u001d\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010d\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016n\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c\u001e\u0005\u000b\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0007\u0000\u0000\u0000 \"\u0003\u001a\r\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0005\u0001\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0002\u0000\u0000&'\u0005\u0000\u0000\u0001'\u0001\u0001\u0000\u0000\u0000(*\u0003\u0004\u0002\u0000)+\u0005\u0003\u0000\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0003\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00001:\u0003\u0012\t\u00002:\u0003\f\u0006\u00003:\u0003\u0006\u0003\u000045\u0003\u001a\r\u000056\u0005\u0004\u0000\u000067\u0003\u001a\r\u00007:\u0001\u0000\u0000\u00008:\u0003\u0018\f\u000091\u0001\u0000\u0000\u000092\u0001\u0000\u0000\u000093\u0001\u0000\u0000\u000094\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;<\u0007\u0001\u0000\u0000<=\u0003\b\u0004\u0000=\u0007\u0001\u0000\u0000\u0000>@\u0005\u0005\u0000\u0000?A\u0003\n\u0005\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0005\u0006\u0000\u0000C>\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\t\u0001\u0000\u0000\u0000GJ\u0003\u001a\r\u0000HI\u0005\u0004\u0000\u0000IK\u0003\u001a\r\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LN\u0005\u0007\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u000b\u0001\u0000\u0000\u0000SV\u0003\u0014\n\u0000TV\u0003\u0018\f\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0003\u000e\u0007\u0000XZ\u0003\b\u0004\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\r\u0001\u0000\u0000\u0000[^\u0003\u0010\b\u0000\\_\u0003\u0014\n\u0000]_\u0003\u0018\f\u0000^\\\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`[\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\u000f\u0001\u0000\u0000\u0000de\u0007\u0002\u0000\u0000e\u0011\u0001\u0000\u0000\u0000fh\u0003\u0014\n\u0000gi\u0003\b\u0004\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jl\u0003\u001a\r\u0000km\u0003\u0016\u000b\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0015\u0001\u0000\u0000\u0000no\u0005\n\u0000\u0000or\u0003\u001a\r\u0000pq\u0005\n\u0000\u0000qs\u0003\u001a\r\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0017\u0001\u0000\u0000\u0000tv\u0005\u0010\u0000\u0000uw\u0003\u001a\r\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0001\u0000\u0000{|\u0003\u0002\u0001\u0000|}\u0005\u0002\u0000\u0000}\u0019\u0001\u0000\u0000\u0000~\u007f\u0007\u0003\u0000\u0000\u007f\u001b\u0001\u0000\u0000\u0000\u0013\u001d!*.9@EJMQUY^bhlrvx".toCharArray());
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];

        for(i = 0; i < _ATN.getNumberOfDecisions(); ++i) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }

    }

    public static class GraphContext extends ParserRuleContext {
        public Stmt_listContext stmt_list() {
            return (Stmt_listContext)this.getRuleContext(Stmt_listContext.class, 0);
        }

        public TerminalNode EOF() {
            return this.getToken(-1, 0);
        }

        public TerminalNode GRAPH() {
            return this.getToken(12, 0);
        }

        public TerminalNode DIGRAPH() {
            return this.getToken(13, 0);
        }

        public TerminalNode STRICT() {
            return this.getToken(11, 0);
        }

        public Id_Context id_() {
            return (Id_Context)this.getRuleContext(Id_Context.class, 0);
        }

        public GraphContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 0;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterGraph(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitGraph(this);
            }

        }
    }

    public static class Id_Context extends ParserRuleContext {
        public TerminalNode ID() {
            return this.getToken(19, 0);
        }

        public TerminalNode STRING() {
            return this.getToken(18, 0);
        }

        public TerminalNode HTML_STRING() {
            return this.getToken(20, 0);
        }

        public TerminalNode NUMBER() {
            return this.getToken(17, 0);
        }

        public Id_Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 13;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterId_(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitId_(this);
            }

        }
    }

    public static class Stmt_listContext extends ParserRuleContext {
        public List<StmtContext> stmt() {
            return this.getRuleContexts(StmtContext.class);
        }

        public StmtContext stmt(int i) {
            return (StmtContext)this.getRuleContext(StmtContext.class, i);
        }

        public Stmt_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 1;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterStmt_list(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitStmt_list(this);
            }

        }
    }

    public static class StmtContext extends ParserRuleContext {
        public Node_stmtContext node_stmt() {
            return (Node_stmtContext)this.getRuleContext(Node_stmtContext.class, 0);
        }

        public Edge_stmtContext edge_stmt() {
            return (Edge_stmtContext)this.getRuleContext(Edge_stmtContext.class, 0);
        }

        public Attr_stmtContext attr_stmt() {
            return (Attr_stmtContext)this.getRuleContext(Attr_stmtContext.class, 0);
        }

        public List<Id_Context> id_() {
            return this.getRuleContexts(Id_Context.class);
        }

        public Id_Context id_(int i) {
            return (Id_Context)this.getRuleContext(Id_Context.class, i);
        }

        public SubgraphContext subgraph() {
            return (SubgraphContext)this.getRuleContext(SubgraphContext.class, 0);
        }

        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 2;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterStmt(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitStmt(this);
            }

        }
    }

    public static class Node_stmtContext extends ParserRuleContext {
        public Node_idContext node_id() {
            return (Node_idContext)this.getRuleContext(Node_idContext.class, 0);
        }

        public Attr_listContext attr_list() {
            return (Attr_listContext)this.getRuleContext(Attr_listContext.class, 0);
        }

        public Node_stmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 9;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterNode_stmt(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitNode_stmt(this);
            }

        }
    }

    public static class Edge_stmtContext extends ParserRuleContext {
        public EdgeRHSContext edgeRHS() {
            return (EdgeRHSContext)this.getRuleContext(EdgeRHSContext.class, 0);
        }

        public Node_idContext node_id() {
            return (Node_idContext)this.getRuleContext(Node_idContext.class, 0);
        }

        public SubgraphContext subgraph() {
            return (SubgraphContext)this.getRuleContext(SubgraphContext.class, 0);
        }

        public Attr_listContext attr_list() {
            return (Attr_listContext)this.getRuleContext(Attr_listContext.class, 0);
        }

        public Edge_stmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 6;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterEdge_stmt(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitEdge_stmt(this);
            }

        }
    }

    public static class Attr_stmtContext extends ParserRuleContext {
        public Attr_listContext attr_list() {
            return (Attr_listContext)this.getRuleContext(Attr_listContext.class, 0);
        }

        public TerminalNode GRAPH() {
            return this.getToken(12, 0);
        }

        public TerminalNode NODE() {
            return this.getToken(14, 0);
        }

        public TerminalNode EDGE() {
            return this.getToken(15, 0);
        }

        public Attr_stmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 3;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterAttr_stmt(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitAttr_stmt(this);
            }

        }
    }

    public static class SubgraphContext extends ParserRuleContext {
        public Stmt_listContext stmt_list() {
            return (Stmt_listContext)this.getRuleContext(Stmt_listContext.class, 0);
        }

        public TerminalNode SUBGRAPH() {
            return this.getToken(16, 0);
        }

        public Id_Context id_() {
            return (Id_Context)this.getRuleContext(Id_Context.class, 0);
        }

        public SubgraphContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 12;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterSubgraph(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitSubgraph(this);
            }

        }
    }

    public static class Attr_listContext extends ParserRuleContext {
        public List<A_listContext> a_list() {
            return this.getRuleContexts(A_listContext.class);
        }

        public A_listContext a_list(int i) {
            return (A_listContext)this.getRuleContext(A_listContext.class, i);
        }

        public Attr_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 4;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterAttr_list(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitAttr_list(this);
            }

        }
    }

    public static class A_listContext extends ParserRuleContext {
        public List<Id_Context> id_() {
            return this.getRuleContexts(Id_Context.class);
        }

        public Id_Context id_(int i) {
            return (Id_Context)this.getRuleContext(Id_Context.class, i);
        }

        public A_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 5;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterA_list(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitA_list(this);
            }

        }
    }

    public static class Node_idContext extends ParserRuleContext {
        public Id_Context id_() {
            return (Id_Context)this.getRuleContext(Id_Context.class, 0);
        }

        public PortContext port() {
            return (PortContext)this.getRuleContext(PortContext.class, 0);
        }

        public Node_idContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 10;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterNode_id(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitNode_id(this);
            }

        }
    }

    public static class EdgeRHSContext extends ParserRuleContext {
        public List<EdgeopContext> edgeop() {
            return this.getRuleContexts(EdgeopContext.class);
        }

        public EdgeopContext edgeop(int i) {
            return (EdgeopContext)this.getRuleContext(EdgeopContext.class, i);
        }

        public List<Node_idContext> node_id() {
            return this.getRuleContexts(Node_idContext.class);
        }

        public Node_idContext node_id(int i) {
            return (Node_idContext)this.getRuleContext(Node_idContext.class, i);
        }

        public List<SubgraphContext> subgraph() {
            return this.getRuleContexts(SubgraphContext.class);
        }

        public SubgraphContext subgraph(int i) {
            return (SubgraphContext)this.getRuleContext(SubgraphContext.class, i);
        }

        public EdgeRHSContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 7;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterEdgeRHS(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitEdgeRHS(this);
            }

        }
    }

    public static class EdgeopContext extends ParserRuleContext {
        public EdgeopContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 8;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterEdgeop(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitEdgeop(this);
            }

        }
    }

    public static class PortContext extends ParserRuleContext {
        public List<Id_Context> id_() {
            return this.getRuleContexts(Id_Context.class);
        }

        public Id_Context id_(int i) {
            return (Id_Context)this.getRuleContext(Id_Context.class, i);
        }

        public PortContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public int getRuleIndex() {
            return 11;
        }

        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).enterPort(this);
            }

        }

        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DOTListener) {
                ((DOTListener)listener).exitPort(this);
            }

        }
    }
}
