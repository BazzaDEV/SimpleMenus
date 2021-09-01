package dev.bazza.simplemenus.objects;

import org.apache.commons.lang3.StringUtils;

public class MenuText {

    //********************** Class Variables **********************//

    private final String text;

    //************************ Constructors ***********************//

    public static MenuTextFactory create() {
        return new MenuTextFactory();
    }

    private MenuText(String text) {
        this.text = text;
    }

    //************************** Methods **************************//

    @Override
    public String toString() {
        return text;
    }



    /*************************************************************************************************************/

    public static class MenuTextFactory {

        //********************** Class Variables **********************//

        private final StringBuilder builder;

        //************************ Constructors ***********************//

        private MenuTextFactory() {
            this.builder = new StringBuilder();
        }

        //************************** Methods **************************//

        public MenuTextFactory newLine(String line) {
            builder.append(line);
            builder.append("\n");

            return this;
        }

        public MenuTextFactory spacer() {
            builder.append("\n");

            return this;
        }

        public MenuText build() {
            return new MenuText(StringUtils.chomp(builder.toString()));
        }

    }

}
