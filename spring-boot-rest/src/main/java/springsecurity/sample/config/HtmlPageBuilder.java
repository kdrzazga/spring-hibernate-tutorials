package springsecurity.sample.config;

import java.util.List;
import java.util.Vector;

public class HtmlPageBuilder {

    private final StringBuilder content;

    private String title;
    private List<String> paragraphs;

    public HtmlPageBuilder() {
        content = new StringBuilder();
        paragraphs = new Vector<>();
    }

    public HtmlPageBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public HtmlPageBuilder withParagraph(String content) {
        this.paragraphs.add(content);
        return this;
    }

    public HtmlPageBuilder withTable(char[][] content) {

        var tableParagraph = new StringBuilder();
        tableParagraph.append("<table style='border: 1px solid black;'>");

        for (char[] chars : content) {

            tableParagraph.append("<tr style='border: 1px solid black;'>");
            for (int col = 0; col < content[0].length; col++) {
                tableParagraph.append("<td>").append(chars[col]).append(".</td>");
            }
            tableParagraph.append("</tr>");
        }
        tableParagraph.append("</table>");

        this.paragraphs.add(tableParagraph.toString());
        return this;
    }

    public HtmlPageBuilder withLink(String URL, String caption) {
        this.paragraphs.add("<a href='" + URL + "'>" + caption + "</a>");
        return this;
    }

    public String build() {
        content.append("<!DOCTYPE html>\n");
        content.append("<html>\n");
        content.append("<head>\n");
        if (!title.equals(""))
            content.append("<title>").append(title).append("</title>\n");
        content.append("</head>\n");

        content.append("<body>\n");
        this.paragraphs.forEach(p -> content.append("<p>").append(p).append("</p>\n"));
        content.append("</body>\n");
        content.append("</html>\n");

        return content.toString();
    }
}
