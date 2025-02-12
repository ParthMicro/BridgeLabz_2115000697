class TextNode { 
    String textState; 
    TextNode prev, next; 
    public TextNode(String textState) { 
        this.textState = textState; 
        this.prev = null; 
        this.next = null; 
    } 
} 
class TextEditor { 
    private TextNode head, tail, current; 
    private int historySize, historyCount; 
    public TextEditor(int historySize) { 
        this.head = this.tail = this.current = null; 
        this.historySize = historySize; 
        this.historyCount = 0; 
    } 
    public void addTextState(String text) { 
        TextNode newNode = new TextNode(text); 
        if (historyCount >= historySize) { 
            removeOldestState(); 
        } 
        if (head == null) { 
            head = tail = current = newNode; 
        } else { 
            tail.next = newNode; 
            newNode.prev = tail; 
            tail = newNode; 
            current = tail; 
        } 
        historyCount++; 
 
    } 
    private void removeOldestState() { 
        if (head != null) { 
            head = head.next; 
            if (head != null) { 
                head.prev = null; 
            } 
            historyCount--; 
        } 
    } 
    public void undo() { 
        if (current != null && current.prev != null) { 
            current = current.prev; 
            System.out.println("Undo: " + current.textState); 
        } else { 
            System.out.println("No more undo steps available."); 
        } 
    } 
    public void redo() { 
        if (current != null && current.next != null) { 
            current = current.next; 
            System.out.println("Redo: " + current.textState); 
        } else { 
            System.out.println("No more redo steps available."); 
        } 
    } 
    public void displayCurrentState() { 
        if (current != null) { 
            System.out.println("Current State: " + current.textState); 
        } else { 
            System.out.println("No text state available."); 
        } 
    } 
    public static void main(String[] args) { 
        TextEditor editor = new TextEditor(5); 
        editor.addTextState("Initial text."); 
        editor.displayCurrentState(); 
        editor.addTextState("Added more text."); 
        editor.displayCurrentState(); 
        editor.addTextState("Added even more text."); 
        editor.displayCurrentState(); 
editor.undo(); 
editor.undo(); 
editor.addTextState("Final text."); 
editor.displayCurrentState(); 
editor.redo(); 
editor.redo(); 
editor.undo(); 
editor.displayCurrentState(); 
} 
} 
