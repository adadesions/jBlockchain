import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static javax.xml.crypto.dsig.DigestMethod.SHA3_256;

public class BlockChain implements CoreBlockChain {
    private String name;
    private String grade;
    private String prvHash;
    private String blockHash;


    public BlockChain(String name, String grade) throws NoSuchAlgorithmException {
        this(name, grade, "");
    }

    public BlockChain(String name, String grade, String prvHash) throws NoSuchAlgorithmException {
        this.name = name;
        this.grade = grade;
        this.prvHash = prvHash;
        this.blockHash = this.calHash();
    }

    public String calHash() throws NoSuchAlgorithmException {
        String orignalText = this.name+this.grade+this.prvHash;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashByte = digest.digest(
                orignalText.getBytes(StandardCharsets.UTF_8)
        );

        BigInteger number = new BigInteger(1, hashByte);
        StringBuilder hexStr = new StringBuilder(number.toString(16));

        return hexStr.toString();
    }



    public void printBlock() {
        System.out.println("===========================");
        System.out.println("Name: " + this.name);
        System.out.println("Grade: " + this.grade);
        System.out.println("PrvHash: " + this.prvHash);
        System.out.println("Hash: " + this.blockHash);
        System.out.println("===========================");
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String getPrvHash() {
        return prvHash;
    }

    public void setPrvHash(String prvHash) {
        this.prvHash = prvHash;
    }

    @Override
    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash() throws NoSuchAlgorithmException {
        this.blockHash = this.calHash();
    }
}
