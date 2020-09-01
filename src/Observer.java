public interface Observer {
    public void update(Object o); //push
    public void update(Subject s); //pull
}
