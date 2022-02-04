public class Bildkomprimierung {


    public static void main(String[] args) {

        String bildDaten = "QQQQRRRRRRTTTTTTTTTTLLLLLLLLLLLMNNNVVVVVVVVVVVAAAAAAAAAAAAA";

        String out = encodeString(bildDaten);
        System.out.println(out);

    }

    public static String encodeString(String toEncode){
        char currentChar;
        char lastChar = '?';
        int index = 0;
        int count =0;
        StringBuilder bildDatenEncoded = new StringBuilder();

        for(; index < toEncode.length();index++){
            currentChar = toEncode.charAt(index);
            if (currentChar == lastChar || count == 0  || count == 1) {
                lastChar = currentChar;
                count++;
                if (toEncode.length() - 1 == index) {
                    bildDatenEncoded.append("§").append(count).append(lastChar);
                }
            } else if (count < 4) {
                bildDatenEncoded.append(String.valueOf(lastChar).repeat(Math.max(0, count)));
            } else {
                bildDatenEncoded.append("§").append(count).append(lastChar);
                count = 1;
                lastChar = '?';
            }
        }
        return bildDatenEncoded.toString();
    }
}
