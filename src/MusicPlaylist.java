/**
 * Represents the doubly linked list for the music playlist.
 *
 * Your Name:        Ahmet Tunahan Atmaca
 * Your Student ID:  240444018
 * Your Date:        19.10.2026
 */


public class MusicPlaylist {


    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // Constructor: Initialize head, tail, and current to null
    public MusicPlaylist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    public void addSong(String title){
        SongNode newNode = new SongNode(title);
        if(head == null){
            head = newNode;
            tail = newNode;
            current = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeSong(String title){
        SongNode temp = head;

        while(temp != null && !temp.title.equals(title)){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("The song is not in the playlist");
            return;
        }
        if (head == tail && temp == head) {
            head = null;
            tail = null;
            current = null;
        }
        else if(temp == tail){
            tail = tail.prev;
            tail.next = tail;
            if(current == temp){
                current = tail;
            }
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            if(current == temp){
                current = temp.next;
            }
        }
    }
    public void nextSong(){
        if(current != null && current.prev == null){
            current = current.prev;
            System.out.println("Playing: " + current.title);
        }
        else{
            System.out.println("Already at the first song of the playlist.");
        }
    }
    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }
    public void displayCurrentSong(){
        if (current != null){
            System.out.println("Current Song: " + current.title);
        }
        else{
            System.out.println("Playlist is empty");
        }
    }
    public void displayPlaylist() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

