package com.company;

public class Main {

    public static char cryptChar(char ch, int shift) {
	    char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s',
                't','u','v','w','x','y','z'};
	    int index = 0;
        for (int i = 0; i < letters.length; i++) {
            index = i;
            if (letters[i] == ch){
                break;
            }
        }
        index = (index + shift) % letters.length;
        char result = letters[index];

	    return result;
    }

    public static String cryptWord(String word, int shift){
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = cryptChar(word.charAt(i), shift);
            result += ch;
        }
        return  result;
    }

    public static char decryptChar(char ch,int shift){
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s',
                't','u','v','w','x','y','z'};
        int index = 0;
        for (int i = 0; i < letters.length; i++) {
            index = i;
            if (letters[i] == ch){
                break;
            }
        }
        index -= shift;
        if (index < 0){
            index = index + letters.length;
        }
        char result = letters[index];
        return result;
    }

    public static String decryptWord(String word, int shift){
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = decryptChar(word.charAt(i), shift);
            result += ch;
        }
        return  result;
    }

    public static char cryptSign(char ch, int shift){
        int index = (int) ch;
        index += shift;
        char result = (char) index;
        return result;
    }

    public static char decryptSign(char ch, int shift){
        int index = (int) ch;
        index -= shift;
        char result = (char) index;
        return result;
    }

    public static String cryptText(String text, int shift){
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = cryptSign(text.charAt(i), shift);
            result += ch;
        }
        return  result;
    }

    public static String decryptText(String text, int shift){
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = decryptSign(text.charAt(i), shift);
            result += ch;
        }
        return  result;
    }

    public static String oneTimePad(String text, String key){
        String cryptograma = "";

        for (int i = 0; i < text.length(); i++) {
            int j = (i + key.length()) % key.length();
            char ch = (char) (((int)text.charAt(i)) + ((int) key.charAt(j)));
            cryptograma += ch;
        }

        return cryptograma;
    }

    public static void main(String[] args){

        System.out.println(cryptChar('b', 1));
        System.out.println(cryptWord("hello",1));
        System.out.println(decryptWord("ifmmp", 1));
        System.out.println(cryptSign((char) 255, 2));
        System.out.println(cryptText("Hello world!", 5));
        System.out.println(decryptText("Mjqqt%|twqi&", 5));
        /*String text = "Деление c остатком — арифметическая операция, играющая большую роль в арифметике, теории чисел, алгебре и криптографии. Чаще всего эта операция определяется для целых или натуральных чисел следующим образом[1]. Пусть a {\\displaystyle a} a и b {\\displaystyle b} b — целые числа, причём b ≠ 0. {\\displaystyle b\\neq 0.} b\\neq 0. Деление с остатком a {\\displaystyle a} a («делимого») на b {\\displaystyle b} b («делитель») означает нахождение таких целых чисел q {\\displaystyle q} q и r {\\displaystyle r} r, что выполняется равенство:\n" +
                "\n" +
                "    a = b ⋅ q + r {\\displaystyle a=b\\cdot q+r} a=b\\cdot q+r\n" +
                "\n" +
                "Таким образом, результатами деления с остатком являются два целых числа: q {\\displaystyle q} q называется неполным частным от деления, а r {\\displaystyle r} r — остатком от деления. На остаток налагается дополнительное условие: 0 ⩽ r < | b | , {\\displaystyle 0\\leqslant r<|b|,} {\\displaystyle 0\\leqslant r<|b|,} то есть остаток от деления должен быть неотрицательным числом и по абсолютной величине меньше делителя. Это условие обеспечивает однозначность результатов деления с остатком для всех целых чисел, то есть существует единственное решение уравнения a = b ⋅ q + r {\\displaystyle a=b\\cdot q+r} a=b\\cdot q+r при заданных выше условиях. Если остаток равен нулю, говорят, что a {\\displaystyle a} a нацело делится на b . {\\displaystyle b.} b.\n" +
                "\n" +
                "Нахождение неполного частного также называют целочисленным делением, а нахождение остатка от деления называют взятием остатка или, неформально, делением по модулю (однако последний термин стоит избегать, так как он может привести к путанице с делением в кольце или группе вычетов по аналогии со сложением или умножением по модулю).\n" +
                "\n" +
                "Примеры\n" +
                "\n" +
                "    При делении с остатком положительного числа a = 78 {\\displaystyle a=78} a=78 на b = 33 {\\displaystyle b=33} b=33 получаем неполное частное q = 2 {\\displaystyle q=2} q=2 и остаток r = 12 {\\displaystyle r=12} r=12.\n" +
                "\n" +
                "        Проверка: 78 = 33 ⋅ 2 + 12. {\\displaystyle 78=33\\cdot 2+12.} 78=33\\cdot 2+12.\n" +
                "\n" +
                "    При делении с остатком отрицательного числа a = − 78 {\\displaystyle a=-78} a=-78 на b = 33 {\\displaystyle b=33} b=33 получаем неполное частное q = − 3 {\\displaystyle q=-3} q=-3 и остаток r = 21 {\\displaystyle r=21} r=21.\n" +
                "\n" +
                "        Проверка: − 78 = 33 ⋅ ( − 3 ) + 21. {\\displaystyle -78=33\\cdot (-3)+21.} -78=33\\cdot (-3)+21.\n" +
                "\n" +
                "    При делении с остатком отрицательного числа a = − 9 {\\displaystyle a=-9} {\\displaystyle a=-9} на b = − 13 {\\displaystyle b=-13} {\\displaystyle b=-13} получаем неполное частное q = 1 {\\displaystyle q=1} {\\displaystyle q=1} и остаток r = 4 {\\displaystyle r=4} r = 4.\n" +
                "\n" +
                "        Проверка: − 9 = 1 ⋅ ( − 13 ) + 4. {\\displaystyle -9=1\\cdot (-13)+4.} {\\displaystyle -9=1\\cdot (-13)+4.}\n" +
                "\n" +
                "    При делении с остатком положительного числа a = 9 {\\displaystyle a=9} {\\displaystyle a=9} на b = 90 {\\displaystyle b=90} {\\displaystyle b=90} получаем неполное частное q = 0 {\\displaystyle q=0} q=0 и остаток r = 9 {\\displaystyle r=9} {\\displaystyle r=9}.\n" +
                "\n" +
                "        Проверка: 9 = 90 ⋅ 0 + 9. {\\displaystyle 9=90\\cdot 0+9.} {\\displaystyle 9=90\\cdot 0+9.}\n" +
                "\n";
        System.out.println(cryptText(text, 5));
        String cryptogramma = cryptText(text, 5);
        String decrypt = decryptText(cryptogramma, 5);
        System.out.println(decrypt);

        int a = (int) '\n';
        System.out.println(a);*/

        System.out.println(decryptWord("aaa", 1));

        System.out.println(oneTimePad("Hello World", "qdg"));
    }
}
// 20 % 26 = 0 i 20 в залишку
// 29 % 26 = 1 і 3 в залишку
// 29 % 26 = (26 + 3) % 26 -----> 0 + 3
/*
* Hello World
* scorpions forever
* 1 буква = код "H" + код "S"
* 2 буква = код "E"+ код "C"
 */