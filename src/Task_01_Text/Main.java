package Task_01_Text;

/* Task 01
1. Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class Main {
    public static void main(String[] args) {
        Word word_01 = new Word("Сказка");
        Word word_02 = new Word("про");
        Word word_03 = new Word("репку");
        Word word_04 = new Word("Посадил");
        Word word_05 = new Word("дед");

        Sentence[] sentenceList = new Sentence[2];
        sentenceList[0] = new Sentence('!', word_01, word_02, word_03);
        sentenceList[1] = new Sentence('.', word_04, word_05, word_03);

        Text text = new Text("Репка.", sentenceList);

        Word wordAdd_01 = new Word("Вот");
        Word wordAdd_02 = new Word("и");
        Word wordAdd_03 = new Word("сказке");
        Word wordAdd_04 = new Word("конец");
        Word wordAdd_05 = new Word("А");
        Word wordAdd_06 = new Word("кто");
        Word wordAdd_07 = new Word("слушал");
        Word wordAdd_08 = new Word("молодец");
        Sentence[] sentenceAdd = new Sentence[2];
        sentenceAdd[0] = new Sentence('.', wordAdd_01, wordAdd_02, wordAdd_03, wordAdd_04);
        sentenceAdd[1] = new Sentence('!', wordAdd_05, wordAdd_06, wordAdd_07, wordAdd_08);

        text.printTitle();
        System.out.println("\nИсходный текст: ");
        text.printText();
        System.out.println("\nИзмененный текст: ");
        text.addSentence(sentenceAdd);
        text.printText();
    }
}
