package note4_2;

public class Student {
  String name, email;
  double gpa, energy;
  int grade, classes=0;
  public Student(String n, int gr, double gp, int c, String e) {
    name = n;
    email = e;
    grade = gr;
    gpa = gp;
    classes = c;
    energy = 30;
  }
  public void addClass(int c) {
    if (classes+c<=7) {
      classes+=c;
    }
    energy-=3;
  }
  public void dropClass(int c) {
    if (classes-c>=6) {
      classes-=c;
    }
    energy-=3;
  }
  public void advanceGrade() {
    grade+=1;
    energy-=3;
  }
  public String getName() {return name;}
  public int getGrade() {return grade;}
  public double getGpa() {return  gpa;}
  public int getClasses() {return classes;}
  public String getEmail() {return email;}
  public double getEnergy() {return energy;}
  public String toString() {return name+" ("+email+") Grade "+grade+" gpa "+gpa+" | "+classes+" Classes";}
}
