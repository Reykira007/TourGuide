package ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategoriesHelperClass {

    Drawable relativeLayout;
    int imageView;
    String textView;

    public CategoriesHelperClass(Drawable relativeLayout, int imageView, String textView) {
        this.relativeLayout = relativeLayout;
        this.imageView = imageView;
        this.textView = textView;
    }

    public Drawable getGradient() {
        return relativeLayout;
    }

    public int getImage() {
        return imageView;
    }

    public String getTitle() {
        return textView;
    }
}
