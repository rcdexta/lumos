package strings;

public class ReverseSentence {

    public static void reverseWords (char[] sentence) {
        reverse(sentence, 0, sentence.length - 1);

         int start = 0;
         for(int i=0;i<sentence.length;i++) {
           if (sentence[i] == ' ') {
             reverse(sentence, start, i - 1);
             start = i + 1;
           }
         }
         reverse(sentence, start, sentence.length - 1);
    }

    static void reverse(char [] word, int i, int j) {
        while(i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char [] s = "We love Java".toCharArray();
        ReverseSentence.reverseWords(s);
        System.out.println(s);
    }
}
