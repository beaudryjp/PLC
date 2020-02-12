import java_cup.runtime.*;
%%
//%debug
%cup
%%

"if"                    { return new Symbol(sym.IF); }                  // IF statement
"else"                  { return new Symbol(sym.ELSE); }                // ELSE statement
"while"                 { return new Symbol(sym.WHILE); }               // WHILE loop
"do"                    { return new Symbol(sym.DO); }                  // DO-WHILE loop
"for"                   { return new Symbol(sym.FOR); }                 // FOR loop
"print"                 { return new Symbol(sym.PRINT); }               // PRINT var
"("                     { return new Symbol(sym.OP); }                  // Open parenthesis
")"                     { return new Symbol(sym.CP); }                  // Close parenthesis
"{"                     { return new Symbol(sym.OB); }                  // Open bracket
"}"                     { return new Symbol(sym.CB); }                  // Close bracket
";"                     { return new Symbol(sym.SC); }                  // Semicolon
"="                     { return new Symbol(sym.ASIG); }                // Assign var
"+"                     { return new Symbol(sym.PLUS); }                // Addition
"-"                     { return new Symbol(sym.MINUS); }               // Substraction
"*"                     { return new Symbol(sym.MUL); }                 // Multiplication
"/"                     { return new Symbol(sym.DIV); }                 // Division
"<"                     { return new Symbol(sym.LT); }                  // Less than
">"                     { return new Symbol(sym.GT); }                  // Greater than
"<="                    { return new Symbol(sym.LTOREQ); }              // Less than or equal to
">="                    { return new Symbol(sym.GTOREQ); }              // Greater than or equal to
"=="                    { return new Symbol(sym.EQ); }                  // Equal to
"!="                    { return new Symbol(sym.NOTEQ); }               // Not Equal to
"&&"                    { return new Symbol(sym.AND); }                 // AND comparator
"||"                    { return new Symbol(sym.OR); }                  // OR comparator
"!"                     { return new Symbol(sym.NOT); }                 // Negation
0|[1-9][0-9]*           { return new Symbol(sym.NUMBER, yytext()); }    // Integer
[a-zA-Z_][a-zA-Z0-9]*   { return new Symbol(sym.VAR, yytext()); }       // Variable
[^]                     {}                                              // Everything else