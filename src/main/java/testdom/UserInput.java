package testdom;

public class UserInput {

    public static class TextInput {
        protected StringBuilder inputSb;

        public TextInput() {
            this.inputSb = new StringBuilder();
        }

        public String getValue() {
            return this.inputSb.toString();
        }
        public void add(char value) {
            this.inputSb.append(value);
        }
    }

    public static class NumericInput extends TextInput{
        public NumericInput() {
            super();
        }

        @Override
        public void add(char value) {
            if(!Character.isDigit(value)){
                this.inputSb.append(value);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        System.out.println(input.getValue());
        input.add('a');
        System.out.println(input.getValue());
        input.add('0');
        System.out.println(input.getValue());
    }
}
