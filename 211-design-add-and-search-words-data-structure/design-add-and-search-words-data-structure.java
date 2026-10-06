class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;

        public TrieNode() {}
    }

    TrieNode head;

    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {//abc
        TrieNode root = head;
        for(int i=0;i<word.length();i++){
            char it = word.charAt(i);
            if(!root.children.containsKey(it)){
                root.children.put(it, new TrieNode());
            }
            root = root.children.get(it);
        }
        root.word = true;
    }

    public boolean searchWord(String word,int idx, TrieNode root){
        for(int i=idx;i<word.length();i++){
            char it = word.charAt(i);
            if(!root.children.containsKey(it)){
                if(it == '.'){
                    for(char x: root.children.keySet()){
                        if(searchWord(word,i+1, root.children.get(x)))
                            return true;
                    }
                    return false;
                }else{
                    return false;
                }
            }else{
                root = root.children.get(it);
            }
        }
        return root.word;
    }
    
    public boolean search(String word) {
        TrieNode root = head;
        return searchWord(word,0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */