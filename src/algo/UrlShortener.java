package algo;

public class UrlShortener {

    public static void shorten(String url) {
        char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shortUrl = new StringBuffer();

        // Convert given integer id to a base 62 number
        long n = 916132832;

        while (n > 0)
        {
            // use above map to store actual character
            // in short url
            shortUrl.append(map[(int) (n % 62L)]);
            n = n / 62;
        }

        System.out.println(shortUrl.reverse());
    }

    public static void main(String[] args) {
        shorten("www.google.com");
    }
}
