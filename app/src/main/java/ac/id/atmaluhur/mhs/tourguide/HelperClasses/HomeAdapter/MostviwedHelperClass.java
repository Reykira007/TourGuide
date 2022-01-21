package ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter;

public class MostviwedHelperClass {

    int imageView;
    String textView, description;

    public MostviwedHelperClass(int imageView, String textView, String desciptrion) {
        this.imageView = imageView;
        this.textView = textView;
        this.description = desciptrion;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTextView() {
        return textView;
    }

    public String getDescription() {
        return description;
    }
}
