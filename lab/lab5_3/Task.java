package lab5_3;

public class Task implements Priority, Comparable<Task> {
  private static int numTasks=0;

  private String name;
  private String description;
  private int priority;
  public Task(String name, String desc, int priority) {
    this.name = name;
    this.description = desc;
    this.priority = priority;

    numTasks++;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  @Override
  public int getPriority() {
    return this.priority;
  }
  @Override
  public void setPriority(int p) {
    this.priority = p;
  }

  public static int getNumTasks() {
    return numTasks;
  }

  @Override
  public int compareTo(Task o) {
    return this.priority-o.getPriority();
  }
}
