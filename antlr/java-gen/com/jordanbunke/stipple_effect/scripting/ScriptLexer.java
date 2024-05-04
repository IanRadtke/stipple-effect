// Generated from C:/Users/Jordan Bunke/Documents/Java/2022/stipple-effect/antlr/ScriptLexer.g4 by ANTLR 4.13.1
package com.jordanbunke.stipple_effect.scripting;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, LINE_COMMENT=2, MULTILINE_COMMENT=3, LPAREN=4, RPAREN=5, LBRACKET=6, 
		RBRACKET=7, LCURLY=8, RCURLY=9, SEMICOLON=10, COLON=11, COMMA=12, PERIOD=13, 
		PIPE=14, QUESTION=15, ASSIGN=16, INCREMENT=17, DECREMENT=18, ADD_ASSIGN=19, 
		SUB_ASSIGN=20, MUL_ASSIGN=21, DIV_ASSIGN=22, MOD_ASSIGN=23, AND_ASSIGN=24, 
		OR_ASSIGN=25, ARROW=26, EQUAL=27, NOT_EQUAL=28, GT=29, LT=30, GEQ=31, 
		LEQ=32, RAISE=33, PLUS=34, MINUS=35, TIMES=36, DIVIDE=37, MOD=38, AND=39, 
		OR=40, NOT=41, SIZE=42, IN=43, FUNC=44, FINAL=45, BOOL=46, FLOAT=47, INT=48, 
		CHAR=49, COLOR=50, IMAGE=51, STRING=52, RETURN=53, DO=54, WHILE=55, FOR=56, 
		IF=57, ELSE=58, TRUE=59, FALSE=60, NEW=61, FROM=62, RGBA=63, RGB=64, BLANK=65, 
		TEX_COL_REPL=66, RED=67, GREEN=68, BLUE=69, ALPHA=70, WIDTH=71, HEIGHT=72, 
		HAS=73, LOOKUP=74, KEYS=75, PIXEL=76, ADD=77, REMOVE=78, DEFINE=79, DRAW=80, 
		AT=81, SUB=82, DOT=83, LINE=84, FILL=85, SECTION=86, BOOL_LIT=87, FLOAT_LIT=88, 
		DEC_LIT=89, HEX_LIT=90, CHAR_QUOTE=91, STR_QUOTE=92, STRING_LIT=93, CHAR_LIT=94, 
		ESC_CHAR=95, IDENTIFIER=96;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "LINE_COMMENT", "MULTILINE_COMMENT", "LPAREN", "RPAREN", "LBRACKET", 
			"RBRACKET", "LCURLY", "RCURLY", "SEMICOLON", "COLON", "COMMA", "PERIOD", 
			"PIPE", "QUESTION", "ASSIGN", "INCREMENT", "DECREMENT", "ADD_ASSIGN", 
			"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "ARROW", "EQUAL", "NOT_EQUAL", "GT", "LT", "GEQ", "LEQ", 
			"RAISE", "PLUS", "MINUS", "TIMES", "DIVIDE", "MOD", "AND", "OR", "NOT", 
			"SIZE", "IN", "FUNC", "FINAL", "BOOL", "FLOAT", "INT", "CHAR", "COLOR", 
			"IMAGE", "STRING", "RETURN", "DO", "WHILE", "FOR", "IF", "ELSE", "TRUE", 
			"FALSE", "NEW", "FROM", "RGBA", "RGB", "BLANK", "TEX_COL_REPL", "RED", 
			"GREEN", "BLUE", "ALPHA", "WIDTH", "HEIGHT", "HAS", "LOOKUP", "KEYS", 
			"PIXEL", "ADD", "REMOVE", "DEFINE", "DRAW", "AT", "SUB", "DOT", "LINE", 
			"FILL", "SECTION", "BOOL_LIT", "DIGIT", "HEX_DIGIT", "FLOAT_LIT", "DEC_LIT", 
			"HEX_LIT", "CHAR_QUOTE", "STR_QUOTE", "RESTRICTED_ASCII", "STRING_LIT", 
			"CHARACTER", "CHAR_LIT", "ESC_CHAR", "IDENTIFIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", 
			"':'", "','", "'.'", "'|'", "'?'", "'='", "'++'", "'--'", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'&='", "'|='", "'->'", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='", "'^'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", 
			"'||'", "'!'", "'#'", "'in'", "'func'", "'final'", "'bool'", "'float'", 
			"'int'", "'char'", "'color'", "'image'", "'string'", "'return'", "'do'", 
			"'while'", "'for'", "'if'", "'else'", "'true'", "'false'", "'new'", "'from'", 
			"'rgba'", "'rgb'", "'blank'", "'tex_col_repl'", null, null, null, null, 
			null, null, "'.has'", "'.lookup'", "'.keys'", "'.pixel'", "'.add'", "'.remove'", 
			"'.define'", "'.draw'", "'.at'", "'.sub'", "'.dot'", "'.line'", "'.fill'", 
			"'.section'", null, null, null, null, "'''", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "LINE_COMMENT", "MULTILINE_COMMENT", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "LCURLY", "RCURLY", "SEMICOLON", "COLON", "COMMA", 
			"PERIOD", "PIPE", "QUESTION", "ASSIGN", "INCREMENT", "DECREMENT", "ADD_ASSIGN", 
			"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "ARROW", "EQUAL", "NOT_EQUAL", "GT", "LT", "GEQ", "LEQ", 
			"RAISE", "PLUS", "MINUS", "TIMES", "DIVIDE", "MOD", "AND", "OR", "NOT", 
			"SIZE", "IN", "FUNC", "FINAL", "BOOL", "FLOAT", "INT", "CHAR", "COLOR", 
			"IMAGE", "STRING", "RETURN", "DO", "WHILE", "FOR", "IF", "ELSE", "TRUE", 
			"FALSE", "NEW", "FROM", "RGBA", "RGB", "BLANK", "TEX_COL_REPL", "RED", 
			"GREEN", "BLUE", "ALPHA", "WIDTH", "HEIGHT", "HAS", "LOOKUP", "KEYS", 
			"PIXEL", "ADD", "REMOVE", "DEFINE", "DRAW", "AT", "SUB", "DOT", "LINE", 
			"FILL", "SECTION", "BOOL_LIT", "FLOAT_LIT", "DEC_LIT", "HEX_LIT", "CHAR_QUOTE", 
			"STR_QUOTE", "STRING_LIT", "CHAR_LIT", "ESC_CHAR", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ScriptLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000`\u02a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007"+
		"D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007"+
		"I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007"+
		"N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007"+
		"S\u0002T\u0007T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007"+
		"X\u0002Y\u0007Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007"+
		"]\u0002^\u0007^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007"+
		"b\u0002c\u0007c\u0001\u0000\u0004\u0000\u00cb\b\u0000\u000b\u0000\f\u0000"+
		"\u00cc\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u00d5\b\u0001\n\u0001\f\u0001\u00d8\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00e0\b\u0002\n\u0002\f\u0002\u00e3\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001"+
		")\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001"+
		"0\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00012\u00012\u00012\u00012\u00012\u00012\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00014\u0001"+
		"4\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"7\u00017\u00017\u00017\u00018\u00018\u00018\u00019\u00019\u00019\u0001"+
		"9\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001"+
		"?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0003B\u01ce\bB\u0001C\u0001C\u0001C\u0001"+
		"C\u0001C\u0001C\u0001C\u0003C\u01d7\bC\u0001D\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0003D\u01df\bD\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001"+
		"E\u0003E\u01e8\bE\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0003"+
		"F\u01f1\bF\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003"+
		"G\u01fb\bG\u0001H\u0001H\u0001H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0001R\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001T\u0001T\u0001T\u0001T\u0001T\u0001"+
		"T\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"V\u0001V\u0003V\u0257\bV\u0001W\u0001W\u0001X\u0001X\u0003X\u025d\bX\u0001"+
		"Y\u0004Y\u0260\bY\u000bY\fY\u0261\u0001Y\u0001Y\u0004Y\u0266\bY\u000b"+
		"Y\fY\u0267\u0001Y\u0004Y\u026b\bY\u000bY\fY\u026c\u0001Y\u0001Y\u0003"+
		"Y\u0271\bY\u0001Z\u0004Z\u0274\bZ\u000bZ\fZ\u0275\u0001[\u0001[\u0001"+
		"[\u0001[\u0004[\u027c\b[\u000b[\f[\u027d\u0001\\\u0001\\\u0001]\u0001"+
		"]\u0001^\u0001^\u0001_\u0001_\u0001_\u0001_\u0005_\u028a\b_\n_\f_\u028d"+
		"\t_\u0001_\u0001_\u0001`\u0001`\u0003`\u0293\b`\u0001a\u0001a\u0001a\u0001"+
		"a\u0001b\u0001b\u0001b\u0001c\u0001c\u0005c\u029e\bc\nc\fc\u02a1\tc\u0001"+
		"\u00e1\u0000d\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9s:u;w<y={>}?\u007f"+
		"@\u0081A\u0083B\u0085C\u0087D\u0089E\u008bF\u008dG\u008fH\u0091I\u0093"+
		"J\u0095K\u0097L\u0099M\u009bN\u009dO\u009fP\u00a1Q\u00a3R\u00a5S\u00a7"+
		"T\u00a9U\u00abV\u00adW\u00af\u0000\u00b1\u0000\u00b3X\u00b5Y\u00b7Z\u00b9"+
		"[\u00bb\\\u00bd\u0000\u00bf]\u00c1\u0000\u00c3^\u00c5_\u00c7`\u0001\u0000"+
		"\u0006\u0002\u0000\t\n  \u0002\u0000\n\n\r\r\u0003\u0000\"\"\'\'\\\\\t"+
		"\u0000\"\"\'\'00\\\\bbffnnrrtt\u0003\u0000AZ__az\u0004\u000009AZ__az\u02b3"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K"+
		"\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000"+
		"\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000"+
		"\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y"+
		"\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000"+
		"\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000"+
		"\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g"+
		"\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000"+
		"\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000"+
		"\u0000q\u0001\u0000\u0000\u0000\u0000s\u0001\u0000\u0000\u0000\u0000u"+
		"\u0001\u0000\u0000\u0000\u0000w\u0001\u0000\u0000\u0000\u0000y\u0001\u0000"+
		"\u0000\u0000\u0000{\u0001\u0000\u0000\u0000\u0000}\u0001\u0000\u0000\u0000"+
		"\u0000\u007f\u0001\u0000\u0000\u0000\u0000\u0081\u0001\u0000\u0000\u0000"+
		"\u0000\u0083\u0001\u0000\u0000\u0000\u0000\u0085\u0001\u0000\u0000\u0000"+
		"\u0000\u0087\u0001\u0000\u0000\u0000\u0000\u0089\u0001\u0000\u0000\u0000"+
		"\u0000\u008b\u0001\u0000\u0000\u0000\u0000\u008d\u0001\u0000\u0000\u0000"+
		"\u0000\u008f\u0001\u0000\u0000\u0000\u0000\u0091\u0001\u0000\u0000\u0000"+
		"\u0000\u0093\u0001\u0000\u0000\u0000\u0000\u0095\u0001\u0000\u0000\u0000"+
		"\u0000\u0097\u0001\u0000\u0000\u0000\u0000\u0099\u0001\u0000\u0000\u0000"+
		"\u0000\u009b\u0001\u0000\u0000\u0000\u0000\u009d\u0001\u0000\u0000\u0000"+
		"\u0000\u009f\u0001\u0000\u0000\u0000\u0000\u00a1\u0001\u0000\u0000\u0000"+
		"\u0000\u00a3\u0001\u0000\u0000\u0000\u0000\u00a5\u0001\u0000\u0000\u0000"+
		"\u0000\u00a7\u0001\u0000\u0000\u0000\u0000\u00a9\u0001\u0000\u0000\u0000"+
		"\u0000\u00ab\u0001\u0000\u0000\u0000\u0000\u00ad\u0001\u0000\u0000\u0000"+
		"\u0000\u00b3\u0001\u0000\u0000\u0000\u0000\u00b5\u0001\u0000\u0000\u0000"+
		"\u0000\u00b7\u0001\u0000\u0000\u0000\u0000\u00b9\u0001\u0000\u0000\u0000"+
		"\u0000\u00bb\u0001\u0000\u0000\u0000\u0000\u00bf\u0001\u0000\u0000\u0000"+
		"\u0000\u00c3\u0001\u0000\u0000\u0000\u0000\u00c5\u0001\u0000\u0000\u0000"+
		"\u0000\u00c7\u0001\u0000\u0000\u0000\u0001\u00ca\u0001\u0000\u0000\u0000"+
		"\u0003\u00d0\u0001\u0000\u0000\u0000\u0005\u00db\u0001\u0000\u0000\u0000"+
		"\u0007\u00e9\u0001\u0000\u0000\u0000\t\u00eb\u0001\u0000\u0000\u0000\u000b"+
		"\u00ed\u0001\u0000\u0000\u0000\r\u00ef\u0001\u0000\u0000\u0000\u000f\u00f1"+
		"\u0001\u0000\u0000\u0000\u0011\u00f3\u0001\u0000\u0000\u0000\u0013\u00f5"+
		"\u0001\u0000\u0000\u0000\u0015\u00f7\u0001\u0000\u0000\u0000\u0017\u00f9"+
		"\u0001\u0000\u0000\u0000\u0019\u00fb\u0001\u0000\u0000\u0000\u001b\u00fd"+
		"\u0001\u0000\u0000\u0000\u001d\u00ff\u0001\u0000\u0000\u0000\u001f\u0101"+
		"\u0001\u0000\u0000\u0000!\u0103\u0001\u0000\u0000\u0000#\u0106\u0001\u0000"+
		"\u0000\u0000%\u0109\u0001\u0000\u0000\u0000\'\u010c\u0001\u0000\u0000"+
		"\u0000)\u010f\u0001\u0000\u0000\u0000+\u0112\u0001\u0000\u0000\u0000-"+
		"\u0115\u0001\u0000\u0000\u0000/\u0118\u0001\u0000\u0000\u00001\u011b\u0001"+
		"\u0000\u0000\u00003\u011e\u0001\u0000\u0000\u00005\u0121\u0001\u0000\u0000"+
		"\u00007\u0124\u0001\u0000\u0000\u00009\u0127\u0001\u0000\u0000\u0000;"+
		"\u0129\u0001\u0000\u0000\u0000=\u012b\u0001\u0000\u0000\u0000?\u012e\u0001"+
		"\u0000\u0000\u0000A\u0131\u0001\u0000\u0000\u0000C\u0133\u0001\u0000\u0000"+
		"\u0000E\u0135\u0001\u0000\u0000\u0000G\u0137\u0001\u0000\u0000\u0000I"+
		"\u0139\u0001\u0000\u0000\u0000K\u013b\u0001\u0000\u0000\u0000M\u013d\u0001"+
		"\u0000\u0000\u0000O\u0140\u0001\u0000\u0000\u0000Q\u0143\u0001\u0000\u0000"+
		"\u0000S\u0145\u0001\u0000\u0000\u0000U\u0147\u0001\u0000\u0000\u0000W"+
		"\u014a\u0001\u0000\u0000\u0000Y\u014f\u0001\u0000\u0000\u0000[\u0155\u0001"+
		"\u0000\u0000\u0000]\u015a\u0001\u0000\u0000\u0000_\u0160\u0001\u0000\u0000"+
		"\u0000a\u0164\u0001\u0000\u0000\u0000c\u0169\u0001\u0000\u0000\u0000e"+
		"\u016f\u0001\u0000\u0000\u0000g\u0175\u0001\u0000\u0000\u0000i\u017c\u0001"+
		"\u0000\u0000\u0000k\u0183\u0001\u0000\u0000\u0000m\u0186\u0001\u0000\u0000"+
		"\u0000o\u018c\u0001\u0000\u0000\u0000q\u0190\u0001\u0000\u0000\u0000s"+
		"\u0193\u0001\u0000\u0000\u0000u\u0198\u0001\u0000\u0000\u0000w\u019d\u0001"+
		"\u0000\u0000\u0000y\u01a3\u0001\u0000\u0000\u0000{\u01a7\u0001\u0000\u0000"+
		"\u0000}\u01ac\u0001\u0000\u0000\u0000\u007f\u01b1\u0001\u0000\u0000\u0000"+
		"\u0081\u01b5\u0001\u0000\u0000\u0000\u0083\u01bb\u0001\u0000\u0000\u0000"+
		"\u0085\u01c8\u0001\u0000\u0000\u0000\u0087\u01cf\u0001\u0000\u0000\u0000"+
		"\u0089\u01d8\u0001\u0000\u0000\u0000\u008b\u01e0\u0001\u0000\u0000\u0000"+
		"\u008d\u01e9\u0001\u0000\u0000\u0000\u008f\u01f2\u0001\u0000\u0000\u0000"+
		"\u0091\u01fc\u0001\u0000\u0000\u0000\u0093\u0201\u0001\u0000\u0000\u0000"+
		"\u0095\u0209\u0001\u0000\u0000\u0000\u0097\u020f\u0001\u0000\u0000\u0000"+
		"\u0099\u0216\u0001\u0000\u0000\u0000\u009b\u021b\u0001\u0000\u0000\u0000"+
		"\u009d\u0223\u0001\u0000\u0000\u0000\u009f\u022b\u0001\u0000\u0000\u0000"+
		"\u00a1\u0231\u0001\u0000\u0000\u0000\u00a3\u0235\u0001\u0000\u0000\u0000"+
		"\u00a5\u023a\u0001\u0000\u0000\u0000\u00a7\u023f\u0001\u0000\u0000\u0000"+
		"\u00a9\u0245\u0001\u0000\u0000\u0000\u00ab\u024b\u0001\u0000\u0000\u0000"+
		"\u00ad\u0256\u0001\u0000\u0000\u0000\u00af\u0258\u0001\u0000\u0000\u0000"+
		"\u00b1\u025c\u0001\u0000\u0000\u0000\u00b3\u0270\u0001\u0000\u0000\u0000"+
		"\u00b5\u0273\u0001\u0000\u0000\u0000\u00b7\u0277\u0001\u0000\u0000\u0000"+
		"\u00b9\u027f\u0001\u0000\u0000\u0000\u00bb\u0281\u0001\u0000\u0000\u0000"+
		"\u00bd\u0283\u0001\u0000\u0000\u0000\u00bf\u0285\u0001\u0000\u0000\u0000"+
		"\u00c1\u0292\u0001\u0000\u0000\u0000\u00c3\u0294\u0001\u0000\u0000\u0000"+
		"\u00c5\u0298\u0001\u0000\u0000\u0000\u00c7\u029b\u0001\u0000\u0000\u0000"+
		"\u00c9\u00cb\u0007\u0000\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0006\u0000\u0000\u0000\u00cf\u0002\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0005/\u0000\u0000\u00d1\u00d2\u0005/\u0000\u0000\u00d2\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d5\b\u0001\u0000\u0000\u00d4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u0006"+
		"\u0001\u0000\u0000\u00da\u0004\u0001\u0000\u0000\u0000\u00db\u00dc\u0005"+
		"/\u0000\u0000\u00dc\u00dd\u0005*\u0000\u0000\u00dd\u00e1\u0001\u0000\u0000"+
		"\u0000\u00de\u00e0\t\u0000\u0000\u0000\u00df\u00de\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005*\u0000\u0000\u00e5"+
		"\u00e6\u0005/\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8"+
		"\u0006\u0002\u0000\u0000\u00e8\u0006\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0005(\u0000\u0000\u00ea\b\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005"+
		")\u0000\u0000\u00ec\n\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005[\u0000"+
		"\u0000\u00ee\f\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005]\u0000\u0000"+
		"\u00f0\u000e\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005{\u0000\u0000\u00f2"+
		"\u0010\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005}\u0000\u0000\u00f4\u0012"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005;\u0000\u0000\u00f6\u0014\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005:\u0000\u0000\u00f8\u0016\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0005,\u0000\u0000\u00fa\u0018\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0005.\u0000\u0000\u00fc\u001a\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0005|\u0000\u0000\u00fe\u001c\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0005?\u0000\u0000\u0100\u001e\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0005=\u0000\u0000\u0102 \u0001\u0000\u0000\u0000\u0103\u0104\u0005+"+
		"\u0000\u0000\u0104\u0105\u0005+\u0000\u0000\u0105\"\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0005-\u0000\u0000\u0107\u0108\u0005-\u0000\u0000\u0108"+
		"$\u0001\u0000\u0000\u0000\u0109\u010a\u0005+\u0000\u0000\u010a\u010b\u0005"+
		"=\u0000\u0000\u010b&\u0001\u0000\u0000\u0000\u010c\u010d\u0005-\u0000"+
		"\u0000\u010d\u010e\u0005=\u0000\u0000\u010e(\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0005*\u0000\u0000\u0110\u0111\u0005=\u0000\u0000\u0111*\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0005/\u0000\u0000\u0113\u0114\u0005=\u0000"+
		"\u0000\u0114,\u0001\u0000\u0000\u0000\u0115\u0116\u0005%\u0000\u0000\u0116"+
		"\u0117\u0005=\u0000\u0000\u0117.\u0001\u0000\u0000\u0000\u0118\u0119\u0005"+
		"&\u0000\u0000\u0119\u011a\u0005=\u0000\u0000\u011a0\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0005|\u0000\u0000\u011c\u011d\u0005=\u0000\u0000\u011d"+
		"2\u0001\u0000\u0000\u0000\u011e\u011f\u0005-\u0000\u0000\u011f\u0120\u0005"+
		">\u0000\u0000\u01204\u0001\u0000\u0000\u0000\u0121\u0122\u0005=\u0000"+
		"\u0000\u0122\u0123\u0005=\u0000\u0000\u01236\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0005!\u0000\u0000\u0125\u0126\u0005=\u0000\u0000\u01268\u0001"+
		"\u0000\u0000\u0000\u0127\u0128\u0005>\u0000\u0000\u0128:\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0005<\u0000\u0000\u012a<\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0005>\u0000\u0000\u012c\u012d\u0005=\u0000\u0000\u012d>\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0005<\u0000\u0000\u012f\u0130\u0005=\u0000"+
		"\u0000\u0130@\u0001\u0000\u0000\u0000\u0131\u0132\u0005^\u0000\u0000\u0132"+
		"B\u0001\u0000\u0000\u0000\u0133\u0134\u0005+\u0000\u0000\u0134D\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0005-\u0000\u0000\u0136F\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005*\u0000\u0000\u0138H\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\u0005/\u0000\u0000\u013aJ\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"%\u0000\u0000\u013cL\u0001\u0000\u0000\u0000\u013d\u013e\u0005&\u0000"+
		"\u0000\u013e\u013f\u0005&\u0000\u0000\u013fN\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0005|\u0000\u0000\u0141\u0142\u0005|\u0000\u0000\u0142P\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005!\u0000\u0000\u0144R\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0005#\u0000\u0000\u0146T\u0001\u0000\u0000\u0000\u0147"+
		"\u0148\u0005i\u0000\u0000\u0148\u0149\u0005n\u0000\u0000\u0149V\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0005f\u0000\u0000\u014b\u014c\u0005u\u0000"+
		"\u0000\u014c\u014d\u0005n\u0000\u0000\u014d\u014e\u0005c\u0000\u0000\u014e"+
		"X\u0001\u0000\u0000\u0000\u014f\u0150\u0005f\u0000\u0000\u0150\u0151\u0005"+
		"i\u0000\u0000\u0151\u0152\u0005n\u0000\u0000\u0152\u0153\u0005a\u0000"+
		"\u0000\u0153\u0154\u0005l\u0000\u0000\u0154Z\u0001\u0000\u0000\u0000\u0155"+
		"\u0156\u0005b\u0000\u0000\u0156\u0157\u0005o\u0000\u0000\u0157\u0158\u0005"+
		"o\u0000\u0000\u0158\u0159\u0005l\u0000\u0000\u0159\\\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0005f\u0000\u0000\u015b\u015c\u0005l\u0000\u0000\u015c"+
		"\u015d\u0005o\u0000\u0000\u015d\u015e\u0005a\u0000\u0000\u015e\u015f\u0005"+
		"t\u0000\u0000\u015f^\u0001\u0000\u0000\u0000\u0160\u0161\u0005i\u0000"+
		"\u0000\u0161\u0162\u0005n\u0000\u0000\u0162\u0163\u0005t\u0000\u0000\u0163"+
		"`\u0001\u0000\u0000\u0000\u0164\u0165\u0005c\u0000\u0000\u0165\u0166\u0005"+
		"h\u0000\u0000\u0166\u0167\u0005a\u0000\u0000\u0167\u0168\u0005r\u0000"+
		"\u0000\u0168b\u0001\u0000\u0000\u0000\u0169\u016a\u0005c\u0000\u0000\u016a"+
		"\u016b\u0005o\u0000\u0000\u016b\u016c\u0005l\u0000\u0000\u016c\u016d\u0005"+
		"o\u0000\u0000\u016d\u016e\u0005r\u0000\u0000\u016ed\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0005i\u0000\u0000\u0170\u0171\u0005m\u0000\u0000\u0171"+
		"\u0172\u0005a\u0000\u0000\u0172\u0173\u0005g\u0000\u0000\u0173\u0174\u0005"+
		"e\u0000\u0000\u0174f\u0001\u0000\u0000\u0000\u0175\u0176\u0005s\u0000"+
		"\u0000\u0176\u0177\u0005t\u0000\u0000\u0177\u0178\u0005r\u0000\u0000\u0178"+
		"\u0179\u0005i\u0000\u0000\u0179\u017a\u0005n\u0000\u0000\u017a\u017b\u0005"+
		"g\u0000\u0000\u017bh\u0001\u0000\u0000\u0000\u017c\u017d\u0005r\u0000"+
		"\u0000\u017d\u017e\u0005e\u0000\u0000\u017e\u017f\u0005t\u0000\u0000\u017f"+
		"\u0180\u0005u\u0000\u0000\u0180\u0181\u0005r\u0000\u0000\u0181\u0182\u0005"+
		"n\u0000\u0000\u0182j\u0001\u0000\u0000\u0000\u0183\u0184\u0005d\u0000"+
		"\u0000\u0184\u0185\u0005o\u0000\u0000\u0185l\u0001\u0000\u0000\u0000\u0186"+
		"\u0187\u0005w\u0000\u0000\u0187\u0188\u0005h\u0000\u0000\u0188\u0189\u0005"+
		"i\u0000\u0000\u0189\u018a\u0005l\u0000\u0000\u018a\u018b\u0005e\u0000"+
		"\u0000\u018bn\u0001\u0000\u0000\u0000\u018c\u018d\u0005f\u0000\u0000\u018d"+
		"\u018e\u0005o\u0000\u0000\u018e\u018f\u0005r\u0000\u0000\u018fp\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\u0005i\u0000\u0000\u0191\u0192\u0005f\u0000"+
		"\u0000\u0192r\u0001\u0000\u0000\u0000\u0193\u0194\u0005e\u0000\u0000\u0194"+
		"\u0195\u0005l\u0000\u0000\u0195\u0196\u0005s\u0000\u0000\u0196\u0197\u0005"+
		"e\u0000\u0000\u0197t\u0001\u0000\u0000\u0000\u0198\u0199\u0005t\u0000"+
		"\u0000\u0199\u019a\u0005r\u0000\u0000\u019a\u019b\u0005u\u0000\u0000\u019b"+
		"\u019c\u0005e\u0000\u0000\u019cv\u0001\u0000\u0000\u0000\u019d\u019e\u0005"+
		"f\u0000\u0000\u019e\u019f\u0005a\u0000\u0000\u019f\u01a0\u0005l\u0000"+
		"\u0000\u01a0\u01a1\u0005s\u0000\u0000\u01a1\u01a2\u0005e\u0000\u0000\u01a2"+
		"x\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005n\u0000\u0000\u01a4\u01a5\u0005"+
		"e\u0000\u0000\u01a5\u01a6\u0005w\u0000\u0000\u01a6z\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a8\u0005f\u0000\u0000\u01a8\u01a9\u0005r\u0000\u0000\u01a9"+
		"\u01aa\u0005o\u0000\u0000\u01aa\u01ab\u0005m\u0000\u0000\u01ab|\u0001"+
		"\u0000\u0000\u0000\u01ac\u01ad\u0005r\u0000\u0000\u01ad\u01ae\u0005g\u0000"+
		"\u0000\u01ae\u01af\u0005b\u0000\u0000\u01af\u01b0\u0005a\u0000\u0000\u01b0"+
		"~\u0001\u0000\u0000\u0000\u01b1\u01b2\u0005r\u0000\u0000\u01b2\u01b3\u0005"+
		"g\u0000\u0000\u01b3\u01b4\u0005b\u0000\u0000\u01b4\u0080\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b6\u0005b\u0000\u0000\u01b6\u01b7\u0005l\u0000\u0000\u01b7"+
		"\u01b8\u0005a\u0000\u0000\u01b8\u01b9\u0005n\u0000\u0000\u01b9\u01ba\u0005"+
		"k\u0000\u0000\u01ba\u0082\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005t\u0000"+
		"\u0000\u01bc\u01bd\u0005e\u0000\u0000\u01bd\u01be\u0005x\u0000\u0000\u01be"+
		"\u01bf\u0005_\u0000\u0000\u01bf\u01c0\u0005c\u0000\u0000\u01c0\u01c1\u0005"+
		"o\u0000\u0000\u01c1\u01c2\u0005l\u0000\u0000\u01c2\u01c3\u0005_\u0000"+
		"\u0000\u01c3\u01c4\u0005r\u0000\u0000\u01c4\u01c5\u0005e\u0000\u0000\u01c5"+
		"\u01c6\u0005p\u0000\u0000\u01c6\u01c7\u0005l\u0000\u0000\u01c7\u0084\u0001"+
		"\u0000\u0000\u0000\u01c8\u01cd\u0005.\u0000\u0000\u01c9\u01ca\u0005r\u0000"+
		"\u0000\u01ca\u01cb\u0005e\u0000\u0000\u01cb\u01ce\u0005d\u0000\u0000\u01cc"+
		"\u01ce\u0005r\u0000\u0000\u01cd\u01c9\u0001\u0000\u0000\u0000\u01cd\u01cc"+
		"\u0001\u0000\u0000\u0000\u01ce\u0086\u0001\u0000\u0000\u0000\u01cf\u01d6"+
		"\u0005.\u0000\u0000\u01d0\u01d1\u0005g\u0000\u0000\u01d1\u01d2\u0005r"+
		"\u0000\u0000\u01d2\u01d3\u0005e\u0000\u0000\u01d3\u01d4\u0005e\u0000\u0000"+
		"\u01d4\u01d7\u0005n\u0000\u0000\u01d5\u01d7\u0005g\u0000\u0000\u01d6\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000\u01d7\u0088"+
		"\u0001\u0000\u0000\u0000\u01d8\u01de\u0005.\u0000\u0000\u01d9\u01da\u0005"+
		"b\u0000\u0000\u01da\u01db\u0005l\u0000\u0000\u01db\u01dc\u0005u\u0000"+
		"\u0000\u01dc\u01df\u0005e\u0000\u0000\u01dd\u01df\u0005b\u0000\u0000\u01de"+
		"\u01d9\u0001\u0000\u0000\u0000\u01de\u01dd\u0001\u0000\u0000\u0000\u01df"+
		"\u008a\u0001\u0000\u0000\u0000\u01e0\u01e7\u0005.\u0000\u0000\u01e1\u01e2"+
		"\u0005a\u0000\u0000\u01e2\u01e3\u0005l\u0000\u0000\u01e3\u01e4\u0005p"+
		"\u0000\u0000\u01e4\u01e5\u0005h\u0000\u0000\u01e5\u01e8\u0005a\u0000\u0000"+
		"\u01e6\u01e8\u0005a\u0000\u0000\u01e7\u01e1\u0001\u0000\u0000\u0000\u01e7"+
		"\u01e6\u0001\u0000\u0000\u0000\u01e8\u008c\u0001\u0000\u0000\u0000\u01e9"+
		"\u01f0\u0005.\u0000\u0000\u01ea\u01eb\u0005w\u0000\u0000\u01eb\u01ec\u0005"+
		"i\u0000\u0000\u01ec\u01ed\u0005d\u0000\u0000\u01ed\u01ee\u0005t\u0000"+
		"\u0000\u01ee\u01f1\u0005h\u0000\u0000\u01ef\u01f1\u0005w\u0000\u0000\u01f0"+
		"\u01ea\u0001\u0000\u0000\u0000\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f1"+
		"\u008e\u0001\u0000\u0000\u0000\u01f2\u01fa\u0005.\u0000\u0000\u01f3\u01f4"+
		"\u0005h\u0000\u0000\u01f4\u01f5\u0005e\u0000\u0000\u01f5\u01f6\u0005i"+
		"\u0000\u0000\u01f6\u01f7\u0005g\u0000\u0000\u01f7\u01f8\u0005h\u0000\u0000"+
		"\u01f8\u01fb\u0005t\u0000\u0000\u01f9\u01fb\u0005h\u0000\u0000\u01fa\u01f3"+
		"\u0001\u0000\u0000\u0000\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fb\u0090"+
		"\u0001\u0000\u0000\u0000\u01fc\u01fd\u0005.\u0000\u0000\u01fd\u01fe\u0005"+
		"h\u0000\u0000\u01fe\u01ff\u0005a\u0000\u0000\u01ff\u0200\u0005s\u0000"+
		"\u0000\u0200\u0092\u0001\u0000\u0000\u0000\u0201\u0202\u0005.\u0000\u0000"+
		"\u0202\u0203\u0005l\u0000\u0000\u0203\u0204\u0005o\u0000\u0000\u0204\u0205"+
		"\u0005o\u0000\u0000\u0205\u0206\u0005k\u0000\u0000\u0206\u0207\u0005u"+
		"\u0000\u0000\u0207\u0208\u0005p\u0000\u0000\u0208\u0094\u0001\u0000\u0000"+
		"\u0000\u0209\u020a\u0005.\u0000\u0000\u020a\u020b\u0005k\u0000\u0000\u020b"+
		"\u020c\u0005e\u0000\u0000\u020c\u020d\u0005y\u0000\u0000\u020d\u020e\u0005"+
		"s\u0000\u0000\u020e\u0096\u0001\u0000\u0000\u0000\u020f\u0210\u0005.\u0000"+
		"\u0000\u0210\u0211\u0005p\u0000\u0000\u0211\u0212\u0005i\u0000\u0000\u0212"+
		"\u0213\u0005x\u0000\u0000\u0213\u0214\u0005e\u0000\u0000\u0214\u0215\u0005"+
		"l\u0000\u0000\u0215\u0098\u0001\u0000\u0000\u0000\u0216\u0217\u0005.\u0000"+
		"\u0000\u0217\u0218\u0005a\u0000\u0000\u0218\u0219\u0005d\u0000\u0000\u0219"+
		"\u021a\u0005d\u0000\u0000\u021a\u009a\u0001\u0000\u0000\u0000\u021b\u021c"+
		"\u0005.\u0000\u0000\u021c\u021d\u0005r\u0000\u0000\u021d\u021e\u0005e"+
		"\u0000\u0000\u021e\u021f\u0005m\u0000\u0000\u021f\u0220\u0005o\u0000\u0000"+
		"\u0220\u0221\u0005v\u0000\u0000\u0221\u0222\u0005e\u0000\u0000\u0222\u009c"+
		"\u0001\u0000\u0000\u0000\u0223\u0224\u0005.\u0000\u0000\u0224\u0225\u0005"+
		"d\u0000\u0000\u0225\u0226\u0005e\u0000\u0000\u0226\u0227\u0005f\u0000"+
		"\u0000\u0227\u0228\u0005i\u0000\u0000\u0228\u0229\u0005n\u0000\u0000\u0229"+
		"\u022a\u0005e\u0000\u0000\u022a\u009e\u0001\u0000\u0000\u0000\u022b\u022c"+
		"\u0005.\u0000\u0000\u022c\u022d\u0005d\u0000\u0000\u022d\u022e\u0005r"+
		"\u0000\u0000\u022e\u022f\u0005a\u0000\u0000\u022f\u0230\u0005w\u0000\u0000"+
		"\u0230\u00a0\u0001\u0000\u0000\u0000\u0231\u0232\u0005.\u0000\u0000\u0232"+
		"\u0233\u0005a\u0000\u0000\u0233\u0234\u0005t\u0000\u0000\u0234\u00a2\u0001"+
		"\u0000\u0000\u0000\u0235\u0236\u0005.\u0000\u0000\u0236\u0237\u0005s\u0000"+
		"\u0000\u0237\u0238\u0005u\u0000\u0000\u0238\u0239\u0005b\u0000\u0000\u0239"+
		"\u00a4\u0001\u0000\u0000\u0000\u023a\u023b\u0005.\u0000\u0000\u023b\u023c"+
		"\u0005d\u0000\u0000\u023c\u023d\u0005o\u0000\u0000\u023d\u023e\u0005t"+
		"\u0000\u0000\u023e\u00a6\u0001\u0000\u0000\u0000\u023f\u0240\u0005.\u0000"+
		"\u0000\u0240\u0241\u0005l\u0000\u0000\u0241\u0242\u0005i\u0000\u0000\u0242"+
		"\u0243\u0005n\u0000\u0000\u0243\u0244\u0005e\u0000\u0000\u0244\u00a8\u0001"+
		"\u0000\u0000\u0000\u0245\u0246\u0005.\u0000\u0000\u0246\u0247\u0005f\u0000"+
		"\u0000\u0247\u0248\u0005i\u0000\u0000\u0248\u0249\u0005l\u0000\u0000\u0249"+
		"\u024a\u0005l\u0000\u0000\u024a\u00aa\u0001\u0000\u0000\u0000\u024b\u024c"+
		"\u0005.\u0000\u0000\u024c\u024d\u0005s\u0000\u0000\u024d\u024e\u0005e"+
		"\u0000\u0000\u024e\u024f\u0005c\u0000\u0000\u024f\u0250\u0005t\u0000\u0000"+
		"\u0250\u0251\u0005i\u0000\u0000\u0251\u0252\u0005o\u0000\u0000\u0252\u0253"+
		"\u0005n\u0000\u0000\u0253\u00ac\u0001\u0000\u0000\u0000\u0254\u0257\u0003"+
		"u:\u0000\u0255\u0257\u0003w;\u0000\u0256\u0254\u0001\u0000\u0000\u0000"+
		"\u0256\u0255\u0001\u0000\u0000\u0000\u0257\u00ae\u0001\u0000\u0000\u0000"+
		"\u0258\u0259\u000209\u0000\u0259\u00b0\u0001\u0000\u0000\u0000\u025a\u025d"+
		"\u0003\u00afW\u0000\u025b\u025d\u0002af\u0000\u025c\u025a\u0001\u0000"+
		"\u0000\u0000\u025c\u025b\u0001\u0000\u0000\u0000\u025d\u00b2\u0001\u0000"+
		"\u0000\u0000\u025e\u0260\u0003\u00afW\u0000\u025f\u025e\u0001\u0000\u0000"+
		"\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u025f\u0001\u0000\u0000"+
		"\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262\u0263\u0001\u0000\u0000"+
		"\u0000\u0263\u0265\u0005.\u0000\u0000\u0264\u0266\u0003\u00afW\u0000\u0265"+
		"\u0264\u0001\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267"+
		"\u0265\u0001\u0000\u0000\u0000\u0267\u0268\u0001\u0000\u0000\u0000\u0268"+
		"\u0271\u0001\u0000\u0000\u0000\u0269\u026b\u0003\u00afW\u0000\u026a\u0269"+
		"\u0001\u0000\u0000\u0000\u026b\u026c\u0001\u0000\u0000\u0000\u026c\u026a"+
		"\u0001\u0000\u0000\u0000\u026c\u026d\u0001\u0000\u0000\u0000\u026d\u026e"+
		"\u0001\u0000\u0000\u0000\u026e\u026f\u0005f\u0000\u0000\u026f\u0271\u0001"+
		"\u0000\u0000\u0000\u0270\u025f\u0001\u0000\u0000\u0000\u0270\u026a\u0001"+
		"\u0000\u0000\u0000\u0271\u00b4\u0001\u0000\u0000\u0000\u0272\u0274\u0003"+
		"\u00afW\u0000\u0273\u0272\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000"+
		"\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0275\u0276\u0001\u0000"+
		"\u0000\u0000\u0276\u00b6\u0001\u0000\u0000\u0000\u0277\u0278\u00050\u0000"+
		"\u0000\u0278\u0279\u0005x\u0000\u0000\u0279\u027b\u0001\u0000\u0000\u0000"+
		"\u027a\u027c\u0003\u00b1X\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027c"+
		"\u027d\u0001\u0000\u0000\u0000\u027d\u027b\u0001\u0000\u0000\u0000\u027d"+
		"\u027e\u0001\u0000\u0000\u0000\u027e\u00b8\u0001\u0000\u0000\u0000\u027f"+
		"\u0280\u0005\'\u0000\u0000\u0280\u00ba\u0001\u0000\u0000\u0000\u0281\u0282"+
		"\u0005\"\u0000\u0000\u0282\u00bc\u0001\u0000\u0000\u0000\u0283\u0284\b"+
		"\u0002\u0000\u0000\u0284\u00be\u0001\u0000\u0000\u0000\u0285\u028b\u0005"+
		"\"\u0000\u0000\u0286\u028a\u0003\u00bd^\u0000\u0287\u028a\u0003\u00c5"+
		"b\u0000\u0288\u028a\u0003\u00b9\\\u0000\u0289\u0286\u0001\u0000\u0000"+
		"\u0000\u0289\u0287\u0001\u0000\u0000\u0000\u0289\u0288\u0001\u0000\u0000"+
		"\u0000\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u0289\u0001\u0000\u0000"+
		"\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c\u028e\u0001\u0000\u0000"+
		"\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028e\u028f\u0005\"\u0000\u0000"+
		"\u028f\u00c0\u0001\u0000\u0000\u0000\u0290\u0293\u0003\u00bd^\u0000\u0291"+
		"\u0293\u0003\u00c5b\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292\u0291"+
		"\u0001\u0000\u0000\u0000\u0293\u00c2\u0001\u0000\u0000\u0000\u0294\u0295"+
		"\u0005\'\u0000\u0000\u0295\u0296\u0003\u00c1`\u0000\u0296\u0297\u0005"+
		"\'\u0000\u0000\u0297\u00c4\u0001\u0000\u0000\u0000\u0298\u0299\u0005\\"+
		"\u0000\u0000\u0299\u029a\u0007\u0003\u0000\u0000\u029a\u00c6\u0001\u0000"+
		"\u0000\u0000\u029b\u029f\u0007\u0004\u0000\u0000\u029c\u029e\u0007\u0005"+
		"\u0000\u0000\u029d\u029c\u0001\u0000\u0000\u0000\u029e\u02a1\u0001\u0000"+
		"\u0000\u0000\u029f\u029d\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000"+
		"\u0000\u0000\u02a0\u00c8\u0001\u0000\u0000\u0000\u02a1\u029f\u0001\u0000"+
		"\u0000\u0000\u0016\u0000\u00cc\u00d6\u00e1\u01cd\u01d6\u01de\u01e7\u01f0"+
		"\u01fa\u0256\u025c\u0261\u0267\u026c\u0270\u0275\u027d\u0289\u028b\u0292"+
		"\u029f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}