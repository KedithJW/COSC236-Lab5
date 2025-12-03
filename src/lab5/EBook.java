public class EBook implements Book {

    private String title;
    private boolean isAvailable = true;

    public EBook(String title) {
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
        return "EBook: " + title;
    }
}


