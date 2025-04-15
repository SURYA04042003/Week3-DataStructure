import java.util.Scanner;

public class CircularTourWithQueue {

        static class PetrolPump {
            int petrol;
            int distance;

            PetrolPump(int petrol, int distance) {
                this.petrol = petrol;
                this.distance = distance;
            }
        }

        public static int findStartingPoint(PetrolPump[] pumps) {
            int n = pumps.length;
            int start = 0, end = 1;

            int currPetrol = pumps[start].petrol - pumps[start].distance;

            while (start != end || currPetrol < 0) {
                while (currPetrol < 0 && start != end) {
                    currPetrol -= pumps[start].petrol - pumps[start].distance;
                    start = (start + 1) % n;

                    if (start == 0) {
                        return -1;
                    }
                }

                currPetrol += pumps[end].petrol - pumps[end].distance;
                end = (end + 1) % n;
            }

            return start;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of petrol pumps: ");
            int n = sc.nextInt();

            PetrolPump[] pumps = new PetrolPump[n];

            System.out.println("Enter petrol and distance for each pump:");
            for (int i = 0; i < n; i++) {
                System.out.print("Pump " + (i + 1) + " Petrol: ");
                int petrol = sc.nextInt();
                System.out.print("Pump " + (i + 1) + " Distance to next: ");
                int distance = sc.nextInt();
                pumps[i] = new PetrolPump(petrol, distance);
            }

            int result = findStartingPoint(pumps);

            if (result != -1) {
                System.out.println("\nTruck can complete the tour starting at pump index: " + result);
            } else {
                System.out.println("\nNo starting pump found to complete the tour.");
            }
        }
    }
    