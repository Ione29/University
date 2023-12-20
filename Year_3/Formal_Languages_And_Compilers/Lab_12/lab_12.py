from sly import Lexer, Parser
import math

class CalcLexer(Lexer):
    tokens = { NAME, NUMBER, PLUS, MINUS, MULT, DIV, POW, FACT, LPAREN, RPAREN, ASSIGN }
    ignore = ' \t'

    # Tokens
    NAME = r'[a-zA-Z_][a-zA-Z0-9_]*'
    NUMBER = r'\d+'

    # Special symbols
    PLUS = r'\+'
    MINUS = r'\-'
    MULT = r'\*'
    DIV = r'\/'
    POW = r'\^'
    FACT = r'\!'
    LPAREN  = r'\('
    RPAREN = r'\)'


    # Ignored pattern
    ignore_newline = r'\n+'

    # Extra action for newlines
    def ignore_newline(self, t):
        self.lineno += t.value.count('\n')

    def error(self, t):
        print("Illegal character '%s'" % t.value[0])
        self.index += 1

class CalcParser(Parser):
    tokens = CalcLexer.tokens

    precedence = (
        ('left', PLUS, MINUS),
        ('left', MULT, DIV),
        ('nonassoc', LPAREN, RPAREN))
    def __init__(self):
        self.names = { }

    @_('NAME ASSIGN expr')
    def statement(self, p):
        self.names[p.NAME] = p.expr

    @_('expr')
    def statement(self, p):
        print(p.expr)

    @_('expr PLUS expr',
       'expr MINUS expr',
       'expr MULT expr',
       'expr DIV expr',
       'expr POW expr',
       'expr FACT'
    )
    def expr(self, p):
        if p[1] == '+':
            return p.expr0 + p.expr1
        elif p[1] == '-':
            return p.expr0 - p.expr1
        elif p[1] == '*':
            return p.expr0 * p.expr1
        elif p[1] == '/':
            return p.expr0 / p.expr1
        elif p[1] == '^':
            return math.pow(p.expr0, p.expr1)
        elif p[1] == '!':
            return math.factorial(p.expr)
    
    @_('LPAREN expr RPAREN')
    def expr(self, p):
        return p.expr

    @_('NUMBER')
    def expr(self, p):
        return int(p.NUMBER)

    @_('NAME')
    def expr(self, p):
        try:
            return self.names[p.NAME]
        except LookupError:
            print(f'Undefined name {p.NAME!r}')
            return 0

if __name__ == '__main__':
    lexer = CalcLexer()
    parser = CalcParser()
    while True:
        try:
            text = input('calc > ')
        except EOFError:
            break
        if text:
            parser.parse(lexer.tokenize(text))