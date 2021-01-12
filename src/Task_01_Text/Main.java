package Task_01_Text;

import java.util.Arrays;

/* Task 01
1. Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

/*
1. Доработать метод addText - добавление текста
2. Доработать метод printTitle - вывод в консоль заголовка
3. Добавить private static для конструкторов Text и Sentence (для удобства ввода текста)
 */
public class Main {
    public static void main(String[] args) {
        Text text = new Text(new Sentence('.', new Word('Р', 'е', 'п', 'к', 'а')),
                new Sentence[]{new Sentence('!', new Word('С', 'к', 'а', 'з', 'к', 'а'))});

        Sentence sentence = new Sentence('.', new Word('В', 'о', 'т'), new Word('и'),
                new Word('с', 'к', 'а', 'з', 'к', 'е'), new Word('к', 'о', 'н', 'е', 'ц'));
        printText(text);
        text = addText(text, sentence);
        printText(text);
        printTitle(text);
    }

    //доработать добавление текста
    public static Text addText(Text text, Sentence sentence) {
        Sentence[] newText = new Sentence[text.getSentence().length + 1];
        newText = Arrays.copyOf(text.getSentence(), text.getSentence().length);
        newText[newText.length - 1] = sentence;
        text.setSentence(newText);
        text.setTitle(text.getTitle());
        return text;
    }

    public static void printText(Text text) {
        System.out.println(text.createText(text.getSentence()));
    }

    //доработать вывод в консоль заголовок
    public static void printTitle(Text text) {
        System.out.println();
    }
}
