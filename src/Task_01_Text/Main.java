package Task_01_Text;

import java.util.Arrays;

/* Task 01
1. Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class Main {
    public static void main(String[] args) {
        Word word_01 = new Word('С', 'к', 'а', 'з', 'к', 'а');
        Word word_02 = new Word('п', 'р', 'о');
        Word word_03 = new Word('р', 'е', 'п', 'к', 'у');
        Word word_04 = new Word('П', 'о', 'с', 'а', 'д', 'и', 'л');
        Word word_05 = new Word('д', 'е', 'д');

        Sentence[] sentenceArr = new Sentence[2];
        sentenceArr[0] = new Sentence('!', word_01, word_02, word_03);
        sentenceArr[1] = new Sentence('.', word_04, word_05, word_03);

        Text text = new Text("Репка", sentenceArr);

        Word wordAdd_01 = new Word('В', 'о', 'т');
        Word wordAdd_02 = new Word('и');
        Word wordAdd_03 = new Word('с', 'к', 'а', 'з', 'к', 'е');
        Word wordAdd_04 = new Word('к', 'о', 'н', 'е', 'ц');
        Sentence sentenceAdd = new Sentence('.', wordAdd_01, wordAdd_02, wordAdd_03, wordAdd_04);

        printTitle(text);
        System.out.println("\nИсходный текст: ");
        printText(text);
        System.out.println("\nИзмененный текст: ");
        text = addText(text, sentenceAdd);
        printText(text);
    }

    //дополнить текст в существующий объект класса Text
    public static Text addText(Text text, Sentence sentence) {
        Sentence[] newText = new Sentence[text.getSentence().length + 1];
        newText = Arrays.copyOf(text.getSentence(), text.getSentence().length + 1);
        newText[newText.length - 1] = sentence;
        text.setSentence(newText);
        text.setTitle(text.getTitle());
        return text;
    }

    //Вывод текста на консоль
    public static void printText(Text text) {
        System.out.println(text.createText(text.getSentence()));
    }

    //Вывод заголовка текста на консоль
    public static void printTitle(Text text) {
        System.out.println("Заголовок текста: " + text.getTitle());
    }
}
