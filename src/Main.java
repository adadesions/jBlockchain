import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        BlockChain b1 = new BlockChain("Ada", "A", "000");
        BlockChain b2 = new BlockChain("Task", "B", b1.getBlockHash());
        BlockChain b3 = new BlockChain("Peter", "D", b2.getBlockHash());
        BlockChain b4 = new BlockChain("Steve", "SS", b3.getBlockHash());

        BlockChain[] chain = {b1, b2, b3, b4};
        System.out.println("!!! BEFORE !!!");
        ChainOperation.printChain(chain);

        System.out.println("!!! AFTER !!!");
        BlockChain updateBlock = new BlockChain("Task", "B-");
        ChainOperation.update(updateBlock, b2, chain);
        ChainOperation.printChain(chain);

    }
}
