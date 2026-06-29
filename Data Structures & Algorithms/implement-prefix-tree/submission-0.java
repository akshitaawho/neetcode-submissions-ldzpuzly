class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean is_end;
    
    public TrieNode() {
        children = new HashMap<>();
        is_end = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i<word.length(); i++){
            char letter = word.charAt(i);
            if(!current.children.containsKey(letter)){
                current.children.put(letter, new TrieNode());
            }
            current = current.children.get(letter);
        }
        current.is_end = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!current.children.containsKey(letter)) {
                return false;
            }
            current = current.children.get(letter);
        }
        return current.is_end;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!current.children.containsKey(letter)) {
                return false;
            }
            current = current.children.get(letter);
        }
        return true;
    }
}
