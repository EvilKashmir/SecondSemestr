package inf.lesson1;

public class Tree {

    private double length;
    private String treeType;

    public Tree(double length, String treeType) {
        this.length = length;
        this.treeType = treeType;
    }

    public int compareTo(Tree newTree) {
        return (this.treeType.equals(newTree.treeType)) ? 0 : (this.treeType.length() > newTree.treeType.length()) ? 1 : -1;
    }
}
