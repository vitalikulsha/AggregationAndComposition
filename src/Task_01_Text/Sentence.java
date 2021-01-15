package Task_01_Text;

public class Sentence {
    private Word[] word;
    private char symbolEndSentence;

    public Sentence(char symbolEndSentence, Word... word) {
        this.word = word;
        this.symbolEndSentence = symbolEndSentence;
        StringBuilder sb = new StringBuilder();
    }

    public String createSentence() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word w : this.word) {
            sb.append(w.getWord() + " ");
        }
        return sb.toString().trim() + this.symbolEndSentence;
    }
}
