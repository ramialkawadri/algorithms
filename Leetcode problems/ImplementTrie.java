class Trie {
    private final Node root;
    
    public Trie() {
        root = new Node('-');
    }
    
    public void insert(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            Node child = currentNode.find(current);
            
            if (child == null) {
                Node node = new Node(current);
                currentNode.add(node);
                currentNode = node;
            } else {
                currentNode = child;
            }
        }
        
        currentNode.isEnd = true;
    }
    
    public boolean search(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            Node child = currentNode.find(current);
            
            if (child == null) return false;
            else currentNode = child;
        }
        
        return currentNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            Node child = currentNode.find(current);
            boolean found = false;
            
            if (child == null) return false;
            else currentNode = child;
        }
        
        return true;
    }
}

class Node {
    public char value;
    public boolean isEnd;
    private Map<Character, Node> children;
    
    public Node(char value) {
        this.value = value;
        children = new HashMap<>();
        isEnd = false;
    }
    
    public void add(Node child) {
        children.put(child.value, child);
    }
    
    public Node find(char c) {
        if (children.containsKey(c)) return children.get(c);
        else return null;
    }
}


