class Word {
    String word;
    int count;

    Word(String word) {
        this.word = word;
        this.count = 1;
    }
}

// Priority Queue implemented like your Item example (array + linear search for max)
class WordPriorityQueue {
    Word[] pq;
    int size;

    WordPriorityQueue(int capacity) {
        pq = new Word[capacity];
        size = 0;
    }

    // Insert a word into PQ
    void enqueue(Word w) {
        pq[size++] = w;
    }

    // Get index of word with highest count
    int peek() {
        int ind = -1;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (pq[i].count > maxCount || 
                (pq[i].count == maxCount && pq[i].word.compareTo(pq[ind].word) < 0)) {
                maxCount = pq[i].count;
                ind = i;
            }
        }
        return ind;
    }

    // Remove the word with highest count
    void dequeue() {
        int ind = peek();
        if (ind != -1) {
            pq[ind] = pq[size - 1];
            size--;
        }
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class WordCounter {

    public static void countWord(String text) {
        String[] words = text.toLowerCase()
                             .replaceAll("[^a-z0-9\\s]", "")
                             .split("\\s+");

        Word[] q = new Word[words.length];

        // Wrap into Word objects
        for (int i = 0; i < words.length; i++) {
            q[i] = new Word(words[i]);
        }

        // Count duplicates
        for (int i = 0; i < q.length; i++) {
            if (!q[i].word.equals("")) {
                for (int j = i + 1; j < q.length; j++) {
                    if (!q[j].word.equals("") && q[i].word.equals(q[j].word)) {
                        q[i].count++;
                        q[j].word = "";
                    }
                }
            }
        }

        // Insert into Priority Queue
        WordPriorityQueue pq = new WordPriorityQueue(q.length);
        for (int i = 0; i < q.length; i++) {
            if (!q[i].word.equals("")) {
                pq.enqueue(q[i]);
            }
        }

        // Extract and print words by frequency
        System.out.println("Words by frequency (high -> low):");
        while (!pq.isEmpty()) {
            Word w = pq.pq[pq.peek()];
            System.out.println(w.word + " : " + w.count);
            pq.dequeue();
        }
    }

    public static void main(String[] args) {
        String w1 = "My Name is Sumit and Sumit is a good Boy. Java is good and Sumit loves Java.";
        countWord(w1);
    }
}
