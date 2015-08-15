package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //detectAllWords(crossword, "home", "same");
        List<Word> list=detectAllWords(crossword, "home", "same");
        //List<Word> list=detectAllWords(crossword, "home");
        for(Word w:list){
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        //массив найденных слов
        List<Word> list=new ArrayList<Word>();
        //есть ли слово в кроссворде
        boolean check=false;

        //перебираем слова из списка слов
        for (int w = 0; w < words.length; w++) {
            //обнуляем флаг (есть ли слово в кроссворде)--------------------------------------------------------------//
            check=false;

            //пежим по кросворду в поиске первого слова
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    //если в кросворде встречается первая буква из искомого слова
                    if (words[w].charAt(0)==(char)crossword[i][j]){
                        //обнуляем флаг (есть ли слово в кроссворде)--------------------------------------------------//
                        //check=false;
                        //задаем параметры для проверки слова в кроссворде--------------------------------------------//
                        int x1=j,y1=i;
                        int x2=0,y2=0;
                        int lenWords=words[w].length();
                        StringBuilder builderWord=new StringBuilder();
                        //читаем по горизонтали вправо - есть ли слово//////////////////////////////////////////////////
                        for (int gorizPravo = x1; gorizPravo < crossword[y1].length; gorizPravo++) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[y1][gorizPravo]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=gorizPravo;
                                y2=y1;
                                break;
                            }
                        }
                        //проверяем есть ли слово по горизонтали вправо
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0,builderWord.length());/////////////////////////////////////////////////////
                        //читаем по горизонтали влево - есть ли слово
                        for (int gorizLevo = x1; 0 <= gorizLevo; gorizLevo--) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[y1][gorizLevo]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=gorizLevo;
                                y2=y1;
                                break;
                            }
                        }
                        //проверяем есть ли слово по горизонтали влево
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                        //читаем по вертикали вверх - есть ли слово
                        for (int vertikalUp = y1; 0 <= vertikalUp; vertikalUp--) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[vertikalUp][x1]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=x1;
                                y2=vertikalUp;
                                break;
                            }
                        }
                        //проверяем есть ли слово по вертикали вверх
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                        //читаем по вертикали вниз - есть ли слово
                        for (int vertikalUp = y1; vertikalUp < crossword.length; vertikalUp++) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[vertikalUp][x1]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=x1;
                                y2=vertikalUp;
                                break;
                            }
                        }
                        //проверяем есть ли слово по вертикали вниз
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                        //читаем по диагонали вверх влево - есть ли слово
                        for (int diagonalUpLeft = y1, x11=x1; 0 <= diagonalUpLeft && 0<=x11; diagonalUpLeft--, x11--) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[diagonalUpLeft][x11]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=x11;
                                y2=diagonalUpLeft;
                                break;
                            }
                        }
                        //проверяем есть ли слово по диагонали вверх влево
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                        //читаем по диагонали вверх вправо - есть ли слово
                        for (int diagonalUpRight = y1, x11=x1; 0 <= diagonalUpRight && x11<crossword[y1].length; diagonalUpRight--, x11++) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[diagonalUpRight][x11]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=x11;
                                y2=diagonalUpRight;
                                break;
                            }
                        }
                        //проверяем есть ли слово по диагонали вверх вправо
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                        //читаем по диагонали вниз влево - есть ли слово
                        for (int diagonalUpRight = y1, x11=x1; diagonalUpRight < crossword.length && 0 <= x11; diagonalUpRight++, x11--) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[diagonalUpRight][x11]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=x11;
                                y2=diagonalUpRight;
                                break;
                            }
                        }
                        //проверяем есть ли слово по диагонали вниз влево
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                        //читаем по диагонали вниз вправо - есть ли слово
                        for (int diagonalUpRight = y1, x11=x1; diagonalUpRight < crossword.length && x11 < crossword[y1].length; diagonalUpRight++, x11++) {
                            //формируем искомое слово
                            builderWord.append((char)crossword[diagonalUpRight][x11]);
                            //делаем проверку чтобы колво символов слово words не превышало в искомом слове builderWord
                            if (lenWords==builderWord.length()){
                                x2=x11;
                                y2=diagonalUpRight;
                                break;
                            }
                        }
                        //проверяем есть ли слово по диагонали вниз вправо
                        if (words[w].equals(builderWord.toString())){
                            //добавляем слово и его параметры в list
                            Word word=new Word(words[w]);
                            word.setStartPoint(x1,y1);
                            word.setEndPoint(x2,y2);
                            list.add(word);
                            //очищаем builderWord для поиска следуещего слова
                            builderWord.delete(0,builderWord.length());
                            //помечаем флаг истмна - слово есть поэтому выходим
                            check=true;
                            if (check){
                                break;
                            }
                        }
                        //если слова не совподают то очищаем builderWord
                        builderWord.delete(0, builderWord.length());/////////////////////////////////////////////////////
                    }
                }
                //exit - words is contains
                if (check){
                    break;
                }
            }
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
