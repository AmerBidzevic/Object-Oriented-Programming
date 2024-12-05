package Lab10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song {
    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Genre: " + genre;
    }
}

class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getGenre().equalsIgnoreCase(targetGenre)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more songs with the specified genre.");
        }
        return playlist.get(currentIndex++);
    }
}
class Main {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Raining Blood", "Slayer", "TRASHHHHHH!!!!"));
        playlist.add(new Song("うっせぇわ", "Ado", "J-POP"));
        playlist.add(new Song("One Last Breath", "Creed", "Rock"));
        playlist.add(new Song("Polaris", "Megadeth", "Metal"));
        playlist.add(new Song("The Ring of Fire", "Johnny Cash", "Country"));

        String targetGenre = "Rock";
        GenreFilterIterator genreIterator = new GenreFilterIterator(playlist, targetGenre);

        System.out.println("Songs in the genre " + targetGenre + ":");
        while (genreIterator.hasNext()) {
            System.out.println(genreIterator.next());
        }
    }
}
