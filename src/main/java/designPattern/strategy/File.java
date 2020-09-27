package main.java.designPattern.strategy;

public class File {
    CompressionStrategy strategy;

    void compress(){
        strategy.compress();
    }
}


abstract class CompressionStrategy {
    abstract void compress();
}

class ZipCompression extends CompressionStrategy {
    @Override
    void compress() {
        System.out.println("Compression on Zip");
    }
}

class TarCompression extends CompressionStrategy {
    @Override
    void compress() {
        System.out.println("Compression on RAR");
    }
}

class Test {
    public static void main(String[] args) {
        File f = new File();
        f.strategy = new ZipCompression();
        f.compress();
    }

}
