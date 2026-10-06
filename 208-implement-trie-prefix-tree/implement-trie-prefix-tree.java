class Trie {
    class TrieNode{
        char c;
        TrieNode[] children;
        boolean endOfWord;

        public TrieNode(char c){
            this.c = c;
            this.children = new TrieNode[26];
            this.endOfWord = false;
        }
    }

    TrieNode head;

    public Trie() {
        head = new TrieNode('a');
    }
    
    public void insert(String word) {
        TrieNode root = head;
        int n = word.length();
        for(int i=0;i<n;i++){
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null){
                root.children[index] = new TrieNode(word.charAt(i));
            }

            if(i == n-1){
                root.children[index].endOfWord = true;
            }

            root = root.children[index];
        }
    }
    
    public boolean search(String word) {
        TrieNode root = head;
        int n = word.length();
        for(int i=0;i<n;i++){
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null){
                return false;
            }

            if(i == n-1 && root.children[index].endOfWord){
                return true;
            }

            root = root.children[index];
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode root = head;
        int n = prefix.length();
        for(int i=0;i<n;i++){
            int index = prefix.charAt(i) - 'a';
            if(root.children[index] == null){
                return false;
            }

            if(i == n-1 ){
                return true;
            }

            root = root.children[index];
        }
        return false;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */