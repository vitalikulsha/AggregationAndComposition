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

    public String createText() {
        StringBuilder text = new StringBuilder();
        for (Sentence sent : sentence) {
            text.append(sent.createSentence() + " ");
        }
        return text.toString().trim();
    }

    public void printTitle() {
        System.out.println("Заголовок текста: " + this.title);
    }

    public void printText() {
        System.out.println(createText());
    }

    public Sentence[] addSentence(Sentence... sentenceAdd) {
        Sentence[] newText = Arrays.copyOf(this.sentence, this.sentence.length + sentenceAdd.length);
        System.arraycopy(sentenceAdd, 0, newText, this.sentence.length, sentenceAdd.length);
        return this.sentence = newText;
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
