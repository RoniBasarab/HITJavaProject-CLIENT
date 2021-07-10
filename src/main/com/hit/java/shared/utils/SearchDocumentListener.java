package main.com.hit.java.shared.utils;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchDocumentListener  implements DocumentListener {
    private final Runnable runnable;

    public SearchDocumentListener(Runnable runnable) {
        this.runnable = runnable;
    }
    private void textChangeEventHandler() {
        runnable.run();
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        textChangeEventHandler();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        textChangeEventHandler();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        textChangeEventHandler();
    }


}
