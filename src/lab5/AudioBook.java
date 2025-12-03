package lab5;

public class AudioBook implements Book {

    private String title;
    private boolean isAvailable = true;

    public AudioBook(String title) {
        this.title = title;
    }

    @Override
    public boolean getIsAvailable() {
        return isAvailable;
    }

    @Override
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
		this.title = title;
	}

    @Override
    public String toString() {
        return "AudioBook: " + title;
    }
}
