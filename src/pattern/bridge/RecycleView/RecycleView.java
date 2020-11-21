package pattern.bridge.RecycleView;

class ViewGroup{

}

public class RecycleView {

    public abstract static class Adapter<VH extends ViewHolder>{
        public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

        public final VH createViewHolder(ViewGroup parent, int viewType){
            VH vh = onCreateViewHolder(parent, viewType);
            return vh;
        }
    }

    public static class ViewHolder{
        //
    }
}
