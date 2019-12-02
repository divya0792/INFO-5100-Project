package m1.team2;

import dataproto.RichText;

class HTMLGenerator {
    /**
     * **
     * @param richText - object of RichText class
     * @return - returns empty string if plaintext is null, else returns plaintext, font style and font size in html format
     */
    public static String generateHTML(RichText richText)
    {
        // retrieve plainText from richText object
        String plainText = richText.getPlainText();

        // if plainText is empty or null, return an empty string
        if(plainText.equals("") || plainText.equals(null))
            return "";

        // replace new line(s) with <br> tag
        plainText = plainText.replaceAll("(\r\n|\n\r|\r|\n)", "<br>");

        StringBuilder script = new StringBuilder(plainText);

        // insert opening and closing <font size> tag
        script.insert(0, "<font size=\""+richText.getFontSize()+"\">").append("</font>");

        // if isItalic() method returns true, insert opening and closing italic tag
        if(richText.isItalic())
            script.insert(0, "<i>").append("</i>");

        // if isBold() method returns true, insert opening and closing bold tag
        if(richText.isBold())
            script.insert(0, "<b>").append("</b>");

        // insert opening and closing <html> tag
        script.insert(0, "<html>").append("</html>");

        // convert the generated html stript to string and return it
        return script.toString();
    }
}