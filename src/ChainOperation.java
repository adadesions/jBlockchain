import java.security.NoSuchAlgorithmException;

public class ChainOperation {

    public static void update(BlockChain updateBlock, BlockChain targetBlock, BlockChain[] chain) throws NoSuchAlgorithmException {
        int idxTarget = -1;
        for (int i=0; i<=chain.length; i++) {
            if (targetBlock.getBlockHash().equals(chain[i].getBlockHash())) {
                idxTarget = i;
                break;
            }
        }

        BlockChain tempBlock = chain[idxTarget];
        tempBlock.setName(updateBlock.getName());
        tempBlock.setGrade(updateBlock.getGrade());
        tempBlock.setBlockHash();
        chain[idxTarget] = tempBlock;

        // UPDATE NEXT BLOCKS
       for (int i=idxTarget; i<chain.length; i++) {
           boolean isLast = (i == chain.length - 1);
           if (isLast)
               break;

           chain[i+1].setPrvHash(chain[i].getBlockHash());
           chain[i+1].setBlockHash();
       }
    }

    public static void printChain(BlockChain[] chain) {
        for (BlockChain block : chain) {
            block.printBlock();
        }
    }
}
