public abstract class Subject {
    public abstract void addObserver(Observer o);

    public abstract void removeObserver(Observer o);

    public abstract void notifyAllObservers();

}
