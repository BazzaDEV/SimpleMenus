public class MenuOption {

    //********************** Class Variables **********************//

    private char key;
    private String text;
    private MenuAction action;

    //************************ Constructors ************************//
    public static MenuOptionFactory create() {
        return new MenuOptionFactory();
    }

    private MenuOption(char key, String text, MenuAction action) {
        this.key = key;
        this.text = text;
        this.action = action;
    }

    //************************** Methods **************************//
    @Override
    public String toString() {
        return key + " - " + text;
    }

    //************************** Getters **************************//

    public char getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public void performAction() {
        action.run();
    }


/*************************************************************************************************************/


    public static class MenuOptionFactory {

    //********************** Class Variables **********************//

    private char key;
    private String text;
    private MenuAction action;

    //************************ Constructors ***********************//

    private MenuOptionFactory() {
        //
    }

    //************************** Methods **************************//

    public MenuOptionFactory setKey(char key) {
            this.key = key;

            return this;
        }

        public MenuOptionFactory setText(String text) {
            this.text = text;

            return this;
        }

        public MenuOptionFactory setAction(MenuAction action) {
            this.action = action;

            return this;
        }

        public MenuOption build() {
            return new MenuOption(key, text, action);
        }


    }


}

