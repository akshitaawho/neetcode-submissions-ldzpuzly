class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class WordDictionary {
    TrieNode root = new TrieNode();
    public WordDictionary() {}

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    private boolean dfs(TrieNode node, String word, int i) {
        if (i == word.length()){
            return node.isEnd;
        }
        if (word.charAt(i) == '.'){
            for (int j = 0; j<26; j++){
                if (node.children[j] != null && dfs(node.children[j], word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
        else{
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) return false;
            return dfs(node.children[index], word, i + 1);
        }
        // i == word.length() → return curr.isEnd
        // word.charAt(i) == '.' → loop through all 26 children, recurse on each that exists
        // Otherwise → normal search, return false if child missing, else recurse
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }
}
