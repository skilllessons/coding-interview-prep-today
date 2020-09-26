package main.java.designPattern.visitor;

abstract class FileVisitor {
    abstract void visitWord(WordFile f);
    abstract void visitPicture(PictureFile f);


}


abstract class File {
    abstract void visit(FileVisitor fv);

}

class WordFile extends File {
    @Override
    void visit(FileVisitor fv) {
        fv.visitWord(this);

    }
}


class PictureFile extends File {
    @Override
    void visit(FileVisitor fv) {
        fv.visitPicture(this);

    }
}


class PrintFileVisitor extends FileVisitor {
    @Override
    void visitWord(WordFile f) {
        System.out.println("Open word and print word document");
    }

    @Override
    void visitPicture(PictureFile f) {
        System.out.println("Open word and open the picture file");

    }
}

class Test {
    public static void main(String[] args) {
        File[] files = {new PictureFile(), new WordFile()};
        FileVisitor v = new PrintFileVisitor();
        for (File file : files) {
            file.visit(v);

        }
    }

}







