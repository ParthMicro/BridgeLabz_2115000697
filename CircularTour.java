public class CircularTour { 
    public static int findStartingPoint(int[] petrol, int[] distance) { 
        int n = petrol.length; 
        int totalSurplus = 0, currentSurplus = 0, start = 0; 
        for (int i = 0; i < n; i++) { 
            int diff = petrol[i] - distance[i]; 
            totalSurplus += diff; 
            currentSurplus += diff; 
            if (currentSurplus < 0) { 
                start = i + 1; 
                currentSurplus = 0; 
            } 
        } 
        return (totalSurplus >= 0) ? start : -1; 
    } 

    public static void main(String[] args) { 
        int[] petrol = {4, 6, 7, 4}; 
        int[] distance = {6, 5, 3, 5}; 
        int start = findStartingPoint(petrol, distance); 
        System.out.println(start == -1 ? "No solution" : "Start at pump " + start); 
    } 
} 
