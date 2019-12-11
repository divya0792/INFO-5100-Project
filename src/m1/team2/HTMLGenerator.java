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
        // if richtext is null, return an empty string
        if(richText == null)
            return "";

        // retrieve plainText from richText object
        String plainText = richText.getPlainText();

        // if plainText is empty or null, return an empty string
        if(plainText == null || plainText.equals(""))
            return "";

        // replace new line(s) with <br> tag
        plainText = plainText.replaceAll("(\r\n|\n\r|\r|\n)", "<br>");

        StringBuilder script = new StringBuilder(plainText);

        // insert opening and closing <font size> tag
        if(richText.getFontSize() != null) {
            script.insert(0, "<font size=\""+richText.getFontSize()+"\">").append("</font>");
        }


        // if isItalic() method returns true, insert opening and closing italic tag
        if(richText.isItalic())
            script.insert(0, "<i>").append("</i>");

        // if isBold() method returns true, insert opening and closing bold tag
        if(richText.isBold())
            script.insert(0, "<b>").append("</b>");



        if(richText.getFontColor() != null) {
            script.insert(0, "<font color=\""+richText.getFontColor()+"\">").append("</font>");
        }

        // background color should be the outest
        if(richText.getBackgroundColor() != null) {
            script.insert(0, "<body bgcolor=\""+richText.getBackgroundColor()+"\">").append("</body>");
        }

        // insert opening and closing <html> tag
        script.insert(0, "<html>").append("</html>");



        // convert the generated html stript to string and return it
        System.out.println("gen html string \n" + script.toString());
        return script.toString();
    }
}