package pattern.adapter.clazz;

import pattern.adapter.Adaptee;
import pattern.adapter.Target;

public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}
