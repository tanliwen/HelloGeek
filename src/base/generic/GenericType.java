package base.generic;

public class GenericType<T> {
    T data;

    public void setData(T t){
        this.data = t;
    }

    public T getData(){
        return data;
    }
}
