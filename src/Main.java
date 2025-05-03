

interface Text{
    String format();
}
class PlainText implements Text {
    private final String content;

    public PlainText(String content) {
        this.content = content;
    }

    @Override
    public String format() {
        return content;
    }
}
class BoldDecorator implements Text {
    private final Text wrapped;

    public BoldDecorator(Text wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String format() {
        return "<b>" + wrapped.format() + "</b>";
    }
}
class ItalicDecorator implements Text {
    private final Text wrapped;

    public ItalicDecorator(Text wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String format() {
        return "<i>" + wrapped.format() + "</i>";
    }
}
class UnderlineDecorator implements Text {
    private final Text wrapped;

    public UnderlineDecorator(Text wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String format() {
        return "<u>" + wrapped.format() + "</u>";
    }
}
public class Main {
    public static void main(String[] args) {
        Text text = new PlainText("Hello World");

        text = new BoldDecorator(text);
        System.out.println(text.format());
        text = new ItalicDecorator(text);
        System.out.println(text.format());
        text = new UnderlineDecorator(text);
        System.out.println(text.format());
    }
}
