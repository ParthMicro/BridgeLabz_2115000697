public class PenDistribution{
public static void main(String args[]){
int totalPens = 14;
int totalStudents = 3;
int penPerStudent = totalPens / totalStudents;
int remainingPens = totalPens % totalStudents;
System.out.print("The Pen Per Student is " + penPerStudent + " and the remaining pen non distributed is " + remainingPens);
}
}
