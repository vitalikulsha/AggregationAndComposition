package Task_01_Text;

import java.util.Arrays;

public class Word {
    private char[] symbol;
    private String word;
    private int lengthWord;

    public Word() {
    }

    public Word(char... symbol) {
        this.symbol = symbol;
        StringBuilder sb = new StringBuilder();
        for (char c : symbol) {
            sb.append(c);
        }
        this.word = sb.toString();
        this.lengthWord = symbol.length;
    }

    public Word(String word) {
        this.symbol = word.toCharArray();
        this.word = word;
        this.lengthWord = word.length();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char[] getSymbol() {
        return symbol;
    }

    public int getLengthWord() {
        return lengthWord;
    }

    public void setSymbol(char[] symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Word: {" + "word = '" + word + '\'' + ", symbols = " + Arrays.toString(symbol)
                + ", word length = " + lengthWord + '}';
    }
}
