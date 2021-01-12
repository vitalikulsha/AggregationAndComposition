package Task_01_Text;

import java.util.Arrays;

public class Sentence {
    private Word[] word;
    private char symbolEndSentence;


    public Sentence(char symbolEndSentence, Word... word) {
        this.word = word;
        this.symbolEndSentence = symbolEndSentence;
        StringBuilder sb = new StringBuilder();

    }

    public String createSentence(Word[] word, char symbolEndSentence) {
        StringBuilder sb = new StringBuilder();
        for (Word str : word) {
            sb.append(str.getWord() + " ");
        }
        return sb.toString().trim() + symbolEndSentence;
    }

    public Word[] getWord() {
        return word;
    }

    public void setWord(Word[] word) {
        this.word = word;
    }

    public char getSymbolEndSentence() {
        return symbolEndSentence;
    }

    public void setSymbolEndSentence(char symbolEndSentence) {
        this.symbolEndSentence = symbolEndSentence;
    }
}
