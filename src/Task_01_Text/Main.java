package Task_01_Text;

/* Task 01
1. Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class Main {
    public static void main(String[] args) {
        Text text = new Text("Репка.", sentencesList);
        text.printTitle();
        System.out.println("\nИсходный текст: ");
        text.printText();
        System.out.println("\nИзмененный текст: ");
        text.completeText(sentencesAdd);
        text.printText();
    }

    private static Word[] createArrWords(String str) {
        String[] strArr = str.split(" ");
        Word[] words = new Word[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            words[i] = new Word(strArr[i]);
        }
        return words;
    }

    private static Word[] words_01 = createArrWords("Сказка про репку");
    private static Word[] words_02 = createArrWords("Посадил дед репку");
    private static Word[] wordsAdd_01 = createArrWords("Вот и сказке конец");
    private static Word[] wordsAdd_02 = createArrWords("А кто слушал молодец");
    private static Sentence[] sentencesList = new Sentence[]{new Sentence('!', words_01),
            new Sentence('.', words_02)};
    private static Sentence[] sentencesAdd = new Sentence[]{new Sentence('.', wordsAdd_01),
            new Sentence('!', wordsAdd_02)};
}
