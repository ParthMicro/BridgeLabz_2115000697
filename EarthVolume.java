public class EarthVolume{
public static void main(String args[]){
double earthRadiusKm = 6378;
double earthRadiusMiles = 0.621371 * 6378;
double volumeCubicKilometers = (4.0 / 3.0) * Math.PI * Math.pow(earthRadiusKm,3);
double volumeCubicMiles = (4.0 / 3.0) * Math.PI * Math.pow(earthRadiusMiles,3);
System.out.print("The volume of earth in cubic kilometers is " + volumeCubicKilometers + " and cubic miles is " + volumeCubicMiles);
}
}
