package main.java.designPattern.command;

public class Document {

    String text = "";
}

abstract class DocumentCommand {
    Document document;

    public DocumentCommand(Document document) {
        this.document = document;
    }

    abstract void execute();
}

class AddCharCommand extends DocumentCommand {
    char c;

    public AddCharCommand(Document document, char c) {
        super(document);
        this.c = c;
    }

    @Override
    void execute() {
        document.text += c;
    }
}

class DeleteCommand extends DocumentCommand {


    public DeleteCommand(Document document) {
        super(document);
    }

    @Override
    void execute() {
        document.text = document.text.substring(0, document.text.length() - 1);
    }
}


class test {
    public static void main(String[] args) {
        Document d = new Document();
        DocumentCommand[] dc = {new AddCharCommand(d, 'A'), new AddCharCommand(d, 'p'), new AddCharCommand(d, 'p'),
                new AddCharCommand(d, 'l'), new AddCharCommand(d, 'e'), new DeleteCommand(d)};

        for (DocumentCommand c : dc) {
            c.execute();
        }
        System.out.println("After Execution:>>>>"+d.text);

    }
}

