package Task_01_Text;

import java.util.Arrays;

/* Task 01
1. Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */
public class Text {
    private String title;
    private Sentence[] sentence;

    public Text() {
    }

    public Text(Sentence[] sentence) {
        this.sentence = sentence;
    }

    public Text(String title, Sentence[] sentence) {
        this.title = title;
        this.sentence = sentence;
    }

    public String createText(Sentence[] sentence) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < sentence.length; i++) {
            text.append(sentence[i].createSentence(sentence[i].getWord(), sentence[i].getSymbolEndSentence()) + " ");
        }
        return text.toString().trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Sentence[] getSentence() {
        return sentence;
    }

    public void setSentence(Sentence[] sentence) {
        this.sentence = sentence;
    }

}
